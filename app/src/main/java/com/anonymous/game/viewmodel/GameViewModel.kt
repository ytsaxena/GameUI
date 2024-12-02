package com.anonymous.game.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.game.model.PlayerData
import com.anonymous.game.model.PlayerResponse
import com.anonymous.game.repository.GameRepo
import kotlinx.coroutines.launch


class GameViewModel(var repo: GameRepo) : ViewModel() {


   private var singlePlayerMutableLiveData  = MutableLiveData<ArrayList<PlayerData>>()

    private var multiPlayerMutableLiveData  = MutableLiveData<ArrayList<PlayerData>>()




    fun getSinglePlayerLiveData() : LiveData<ArrayList<PlayerData>> {
        return singlePlayerMutableLiveData as LiveData<ArrayList<PlayerData>>
    }

    fun getMultiPlayerLiveData() : LiveData<ArrayList<PlayerData>> {
        return multiPlayerMutableLiveData as LiveData<ArrayList<PlayerData>>
    }


    fun getGameDataSinglePlayerJSON() {

        viewModelScope.launch {

            try {
                val game = repo.getGames().singlePlayer
                singlePlayerMutableLiveData.value = game

                Log.d("dfsdf",""+game.get(0).gameName)

            }catch (e:Exception){
                Log.d("dfsdf",e.toString() + "" + e.message.toString())
            }

        }


    }



    fun getGameDataMultiPlayerJSON() {

        viewModelScope.launch {

            try {
                val game = repo.getGames().multiPlayer
                multiPlayerMutableLiveData.value = game

             //   Log.d("dfsdf",""+game.get(0).gameName)

            }catch (e:Exception){
                Log.d("dfsdf",e.toString() + "" + e.message.toString())
            }

        }


    }



}