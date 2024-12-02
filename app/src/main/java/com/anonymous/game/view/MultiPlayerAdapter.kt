package com.anonymous.game.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anonymous.game.databinding.ItemPlayerListBinding
import com.anonymous.game.model.PlayerData
import com.anonymous.game.model.PlayerResponse
import com.bumptech.glide.Glide

class MultiPlayerAdapter(val context: Context ,val gamedata : ArrayList<PlayerData>) : RecyclerView.Adapter<MultiPlayerAdapter.MultiPlayerVH>() {


    inner class MultiPlayerVH(val binding: ItemPlayerListBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MultiPlayerAdapter.MultiPlayerVH {
        val binding = ItemPlayerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MultiPlayerVH(binding)

    }

    override fun onBindViewHolder(holder: MultiPlayerAdapter.MultiPlayerVH, position: Int) {

        val data = gamedata[position]
        holder.binding.txtGameName.text = data.gameName

      //  Log.d("sdsdf",data.gameImg.toString())
        Glide.with(context).load(data.gameImg).into(holder.binding.roundedImageView);

    }

    override fun getItemCount(): Int = gamedata.size
}