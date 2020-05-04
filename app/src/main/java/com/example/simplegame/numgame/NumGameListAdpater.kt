package com.example.simplegame.numgame

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.simplegame.numgame.NumGameActivity

class NumGameListAdpater : BaseAdapter() {
    private var resultCountList = mutableListOf<NumGameActivity.ResultCount>()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): Any {
        return resultCountList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return resultCountList.size
    }
}