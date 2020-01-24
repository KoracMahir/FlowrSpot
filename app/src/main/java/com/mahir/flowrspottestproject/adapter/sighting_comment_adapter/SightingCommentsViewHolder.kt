package com.mahir.flowrspottestproject.adapter.sighting_comment_adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mahir.flowrspottestproject.model.Comment
import kotlinx.android.synthetic.main.recycler_view_comment.view.*

class SightingCommentsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindItems(commentsList: Comment){
        itemView.name.text = commentsList.user_full_name
        itemView.text.text = commentsList.content
    }
}