package com.example.simplegame.numgame

import android.os.Bundle
import android.view.MenuItem
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplegame.FinishGameDialog
import com.example.simplegame.GameRuleDialog
import com.example.simplegame.R
import kotlinx.android.synthetic.main.activity_numgame.*
import java.util.*

class NumGameActivity : AppCompatActivity() {
    private val MAX = 9
    private val MIN = 0
    private val random = Random()
    private var resultNumFir = 0
    private var resultNumSec = 0
    private var resultNumThd = 0
    private var life = 10
    private var resultCount = mutableListOf<ResultCount>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MyStatusResultAdpater
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numgame)

        viewAdapter = MyStatusResultAdpater()
        viewManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        setSupportActionBar(app_toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setValue(num_fir)
        setValue(num_sec)
        setValue(num_thd)
        init()

        recyclerView = findViewById<RecyclerView>(R.id.status_result_list).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
        sel_btn.setOnClickListener {
            checkNum(num_fir.value, num_sec.value, num_thd.value)
        }

        game_rule_tv.setOnClickListener {
            GameRuleDialog(this)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        //숫자 0~9까지 랜덤 set
        setResult(0, 9)
        life = 10
        resultCount = mutableListOf()
        viewAdapter.setList(resultCount)
        sel_btn.text = "게임시작"
    }

    private fun setResult(from: Int, to: Int) {
        resultNumFir = random.nextInt(to - from) + from
        do {
            resultNumSec = random.nextInt(to - from) + from
        } while (resultNumFir == resultNumSec)

        do {
            resultNumThd = random.nextInt(to - from) + from
        } while (resultNumFir == resultNumThd || resultNumSec == resultNumThd)
    }

    private fun checkNum(numFir: Int, numSec: Int, numThd: Int) {
        if (numFir == numSec || numSec == numThd || numFir == numThd) {
            Toast.makeText(this, "중복된 숫자는 입력할수없습니다.", Toast.LENGTH_LONG).show()
        } else {
            if (sel_btn.text == "게임시작") Toast.makeText(
                this,
                "게임이 시작되었습니다.",
                Toast.LENGTH_LONG
            ).show()
            sel_btn.text = "실행"
            var bC = 0
            var sC = 0
            when (numFir) {
                resultNumFir -> sC += 1
                resultNumSec -> bC += 1
                resultNumThd -> bC += 1
            }

            when (numSec) {
                resultNumFir -> bC += 1
                resultNumSec -> sC += 1
                resultNumThd -> bC += 1
            }

            when (numThd) {
                resultNumFir -> bC += 1
                resultNumSec -> bC += 1
                resultNumThd -> sC += 1
            }
            resultCount.add(
                ResultCount(
                    bC,
                    sC,
                    numFir.toString() + numSec.toString() + numThd.toString()
                )
            )
            viewAdapter.setList(resultCount)
            recyclerView.scrollToPosition(viewAdapter.itemCount - 1)


            if (sC != 3) {
                life -= 1
                if (life == 0) finishGame()
            } else finishGame()
            life_tv.text = life.toString()
        }
    }

    private fun setValue(numberPicker: NumberPicker) {
        numberPicker.maxValue = MAX
        numberPicker.minValue = MIN
    }

    private fun finishGame() {
        FinishGameDialog(this, life)
        init()
    }

    class ResultCount(val ballCount: Int, val strikeCount: Int, val inputResult: String)
}