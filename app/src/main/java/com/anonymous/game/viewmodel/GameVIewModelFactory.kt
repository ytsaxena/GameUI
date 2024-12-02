package com.anonymous.game.viewmodel

import android.app.GameState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anonymous.game.repository.GameRepo

class GameVIewModelFactory(val repo: GameRepo) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GameViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}



