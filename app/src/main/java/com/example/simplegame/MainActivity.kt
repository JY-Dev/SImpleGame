package com.example.simplegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.simplegame.numgame.NumGameActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var game = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        val items = resources.getStringArray(R.array.game_array)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,items)
        spinner.adapter = myAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position){
                    0 -> {
                        game = position
                    }
                    1 -> {
                        game = position
                    }
                    2 -> {
                        game = position
                    }
                    3 -> {
                        game = position
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
        start_btn.setOnClickListener {
            when(game){
                0 -> startActivity(Intent(this,
                    NumGameActivity::class.java))
                1 -> Toast.makeText(this,"아직 미정입니다.",Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this,"아직 미정입니다.",Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this,"아직 미정입니다.",Toast.LENGTH_SHORT).show()
            }

        }

    }
}
