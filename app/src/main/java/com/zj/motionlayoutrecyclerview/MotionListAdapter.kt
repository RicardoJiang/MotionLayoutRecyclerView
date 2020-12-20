package com.zj.motionlayoutrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.RecyclerView


class MotionListAdapter(val context: Context, val result: ArrayList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val TYPE_CONTACT = 1
        private const val TYPE_TITLE = 2
    }

    private var mLayoutInflater: LayoutInflater = LayoutInflater.from(context)
    private val expandList = BooleanArray(result.size)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_CONTACT) {
            return MotionViewHolder(
                mLayoutInflater.inflate(
                    R.layout.motion_list_rv_item, parent, false
                )
            )
        } else {
            return TitleViewHolder(
                mLayoutInflater.inflate(
                    R.layout.layout_title, parent, false
                )
            )
        }
    }

    override fun getItemCount(): Int = result.size

    override fun getItemViewType(position: Int): Int {
        return if (result[position] is ContactPerson) {
            TYPE_CONTACT
        } else {
            TYPE_TITLE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MotionViewHolder) {
            val userText = holder.itemView.findViewById<TextView>(R.id.item_username)
            val userDesc = holder.itemView.findViewById<TextView>(R.id.item_desc)
            val userAvatar = holder.itemView.findViewById<ImageView>(R.id.item_user_avatar)
            val motionBox = holder.itemView.findViewById<MotionLayout>(R.id.motionContainer)
            if (expandList[position]){
                motionBox.progress = 1.0f
            }else{
                motionBox.progress = 0f
            }

            holder.itemView.setOnClickListener {
                expandList.fill(false)
                if (motionBox.progress == 1.0f) {
                    motionBox.transitionToStart()
                } else if (motionBox.progress == 0.0f) {
                    motionBox.transitionToEnd()
                    expandList[position] = true
                }
                for (i in 0 until itemCount) {
                    if (i != position) {
                        notifyItemChanged(i, "collapse")
                    }
                }
            }
            val item = result[position] as ContactPerson
            userText.text = item.name
            userDesc.text = item.desc
            userAvatar.setImageResource(item.avatar)
        } else if (holder is TitleViewHolder) {
            val tvTitle = holder.itemView.findViewById<TextView>(R.id.tv_title)
            val item = result[position] as String
            tvTitle.text = item
        }

    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNullOrEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            if (holder is MotionViewHolder) {
                val motionBox = holder.itemView.findViewById<MotionLayout>(R.id.motionContainer)
                motionBox.transitionToStart()
            }
        }
    }

    class MotionViewHolder(item: View) : RecyclerView.ViewHolder(item)
    class TitleViewHolder(item: View) : RecyclerView.ViewHolder(item)
}