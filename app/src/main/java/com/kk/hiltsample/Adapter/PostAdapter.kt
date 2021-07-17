package com.kk.hiltsample.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kk.hiltsample.databinding.EachRowBinding
import com.kk.hiltsample.model.Post

class PostAdapter(private var postList: Post): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private lateinit var binding: EachRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding =  EachRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.tvTitle.text  = postList[position].title

    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
    fun setData(postList: Post){
        this.postList = postList
        notifyDataSetChanged()
    }
}