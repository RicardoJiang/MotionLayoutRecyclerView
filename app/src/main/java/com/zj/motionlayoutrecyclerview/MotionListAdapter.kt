package com.zj.motionlayoutrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.RecyclerView


class MotionListAdapter(val context: Context, val list: ArrayList<ContactPerson>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mLayoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MotionViewHolder(mLayoutInflater.inflate(
            R.layout.motion_list_rv_item, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userText = holder.itemView.findViewById<TextView>(R.id.item_username)
        val userDesc = holder.itemView.findViewById<TextView>(R.id.item_desc)
        val userAvatar = holder.itemView.findViewById<ImageView>(R.id.item_user_avatar)

        val motionBox = holder.itemView.findViewById<MotionLayout>(R.id.motionContainer)
        userText.text = list[position].name
        userDesc.text = list[position].desc
        userAvatar.setImageResource(list[position].avatar)

    }

    class MotionViewHolder(item: View): RecyclerView.ViewHolder(item)
}