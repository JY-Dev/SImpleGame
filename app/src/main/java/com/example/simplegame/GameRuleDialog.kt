package com.example.simplegame

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import kotlinx.android.synthetic.main.game_rule_dialog.*

class GameRuleDialog(context: Context) : Dialog(context){
    init {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.setContentView(R.layout.game_rule_dialog)
        this.setCanceledOnTouchOutside(false)
        ok_sel_btn.setOnClickListener {
            this.dismiss()
        }

        this.show()
    }
}