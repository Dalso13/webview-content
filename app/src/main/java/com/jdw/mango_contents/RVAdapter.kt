package com.jdw.mango_contents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RVAdapter(
    val list : MutableList<ContentsModel>,
    val context: Context
) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : ContentsModel) {
            val rvImg = itemView.findViewById<ImageView>(R.id.rv_img)
            val rvText = itemView.findViewById<TextView>(R.id.rv_text)

            rvText.text = item.title

            // 외부 이미지 띄우기
            Glide.with(context)
                .load(item.imageUrl)
                .into(rvImg)
        }

    }
}