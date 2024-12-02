package com.anonymous.game.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anonymous.game.databinding.ItemPlayerListBinding
import com.anonymous.game.model.PlayerData
import com.anonymous.game.model.PlayerResponse
import com.bumptech.glide.Glide

class SinglePlayerAdapter(val context : Context, val gamedata : ArrayList<PlayerData>) : RecyclerView.Adapter<SinglePlayerAdapter.SinglePlayerVH>() {


    inner class SinglePlayerVH(val binding: ItemPlayerListBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SinglePlayerAdapter.SinglePlayerVH {
        val binding = ItemPlayerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SinglePlayerVH(binding)

    }

    override fun onBindViewHolder(holder: SinglePlayerAdapter.SinglePlayerVH, position: Int) {

        val data = gamedata[position]
        holder.binding.txtGameName.text = data.gameName

        Glide.with(context).load(data.gameImg).into(holder.binding.roundedImageView);


    }

    override fun getItemCount(): Int = gamedata.size
}