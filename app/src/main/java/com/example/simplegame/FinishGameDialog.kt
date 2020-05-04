package com.example.simplegame

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import kotlinx.android.synthetic.main.game_finish_dialog.*
import kotlinx.android.synthetic.main.status_result_item.*


class FinishGameDialog(context: Context,score:Int) : Dialog(context) {
    init {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.setContentView(R.layout.game_finish_dialog)
        this.setCanceledOnTouchOutside(false)
        score_tv.text = score.toString()
        ok_sel_btn.setOnClickListener {
            this.dismiss()
        }
        this.show()
    }
}