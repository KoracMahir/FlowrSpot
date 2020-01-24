package com.mahir.flowrspottestproject.adapter.sighting_comment_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.adapter.sightings_adapter.SightingsViewHolder
import com.mahir.flowrspottestproject.model.Comment
import com.mahir.flowrspottestproject.model.CommentsResponse

class SightingCommentAdapter : RecyclerView.Adapter<SightingCommentsViewHolder>(){

    var commentsList: List<Comment> = emptyList()

    fun addItems(flist:List<Comment>){
        this.commentsList = flist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SightingCommentsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_comment, parent, false)
        return SightingCommentsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    override fun onBindViewHolder(holder: SightingCommentsViewHolder, position: Int) {
        holder.bindItems(commentsList[position])
    }
}