package com.project.manzararecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.project.manzararecyclerview.R
import com.project.manzararecyclerview.model.Manzara

class ManzaraBaseAdapter(
    private val manzaraList: ArrayList<Manzara>,
    private val context: Context,
) : RecyclerView.Adapter<ManzaraBaseAdapter.ManzaraViewHolder>() {

    inner class ManzaraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val singleRowView = itemView
        val manzaraNameText: TextView =
            singleRowView.findViewById<TextView>(R.id.manzaraNameText)
        val manzaraDescText: TextView =
            singleRowView.findViewById<TextView>(R.id.manzaraDescText)
        val manzaraImageView: ImageView =
            singleRowView.findViewById<ImageView>(R.id.manzaraImageView)
        val imageCopy: ImageView = singleRowView.findViewById<ImageView>(R.id.imageCopy)
        val imageDelete: ImageView = singleRowView.findViewById<ImageView>(R.id.imageDelete)

    }

    override fun getItemCount(): Int {
        return manzaraList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManzaraViewHolder {

        val inflater = LayoutInflater.from(context)
        val singleRowView = inflater.inflate(R.layout.single_row, parent, false)

        return ManzaraViewHolder(singleRowView)
    }

    override fun onBindViewHolder(holder: ManzaraViewHolder, position: Int) {
        // holder.setData(manzaraList[position], position)

        holder.manzaraNameText.text = manzaraList[position].name
        holder.manzaraDescText.text = manzaraList[position].description
        holder.manzaraImageView.setImageResource(manzaraList[position].image)

        holder.imageDelete.setOnClickListener {
            manzaraList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, manzaraList.size)

        }

        holder.imageCopy.setOnClickListener {
            manzaraList.add(position, manzaraList[position])
            notifyItemInserted(position)
            notifyItemRangeChanged(position, manzaraList.size)
        }


    }
}