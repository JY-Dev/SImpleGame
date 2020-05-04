package com.example.simplegame.numgame

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplegame.R
import kotlinx.android.synthetic.main.status_result_item.view.*


class MyStatusResultAdpater():RecyclerView.Adapter<MyStatusResultAdpater.MyViewHolder>(){

    var itemList= mutableListOf<NumGameActivity.ResultCount>()
   inner class MyViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.status_result_item, parent, false)) {
        val strikeTv = itemView.strike_tv
        val ballTv = itemView.ball_tv
        val inputTv = itemView.input_tv
        val countTv = itemView.count_tv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder(parent)

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        itemList[position].let {
            with(holder){
                ballTv.text = it.ballCount.toString()
                strikeTv.text = it.strikeCount.toString()
                inputTv.text = it.inputResult
                countTv.text = (position+1).toString()
            }
        }
    }

    fun setList(list : MutableList<NumGameActivity.ResultCount>){
        this.itemList = list
        notifyDataSetChanged()
    }
}