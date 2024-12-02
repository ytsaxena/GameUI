package com.anonymous.game.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anonymous.game.databinding.ActivityMainBinding
import com.anonymous.game.model.PlayerData
import com.anonymous.game.repository.GameRepo
import com.anonymous.game.viewmodel.GameVIewModelFactory
import com.anonymous.game.viewmodel.GameViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var playerAdapter: SinglePlayerAdapter
    lateinit var multiplayerAdapter :MultiPlayerAdapter

    lateinit var gameViewModel: GameViewModel
    lateinit var repo :GameRepo


    lateinit var singlePlayerlist : ArrayList<PlayerData>
    lateinit var multiPlayerlist : ArrayList<PlayerData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
      //  setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val repo = GameRepo()
        val factory = GameVIewModelFactory(repo)
        gameViewModel = ViewModelProvider(this,factory).get(GameViewModel::class.java)




         // single dummy json api
        gameViewModel.getGameDataSinglePlayerJSON()


         //setup RV
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,2)
        binding.RVSinglePlayer.setLayoutManager(layoutManager)
        singlePlayerlist = ArrayList<PlayerData>()
        playerAdapter = SinglePlayerAdapter(this,singlePlayerlist)
        binding.RVSinglePlayer.adapter = playerAdapter

        // Observe LiveData
        gameViewModel.getSinglePlayerLiveData().observe(this) { gamesResponse ->

            try {

                singlePlayerlist.clear()
                singlePlayerlist.addAll(gamesResponse)

            }catch (e:Exception){
                Log.d("sdfdsfds", e.message.toString())

            }

        }



        binding.multiplayerBtn.setOnClickListener{

            binding.singleP.setTextColor(Color.BLACK)
            binding.singleview.visibility = View.GONE
            binding.RVSinglePlayer.visibility=View.GONE



            binding.multiP.setTextColor(Color.WHITE)
            binding.multiv.visibility =View.VISIBLE
            binding.RVMultiPlayer.visibility =View.VISIBLE


            //setup RV
            val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,2)
            binding.RVMultiPlayer.setLayoutManager(layoutManager)
            multiPlayerlist = ArrayList<PlayerData>()
            multiplayerAdapter = MultiPlayerAdapter(this@MainActivity,multiPlayerlist)
            binding.RVMultiPlayer.adapter = multiplayerAdapter

            // multiple dummy json api
            gameViewModel.getGameDataMultiPlayerJSON()

            // Observe LiveData
            gameViewModel.getMultiPlayerLiveData().observe(this) { gamesResponse ->

                try {

                    multiPlayerlist.clear()
                    multiPlayerlist.addAll(gamesResponse)

                }catch (e:Exception){
                    Log.d("sdfdsfds", e.message.toString())

                }

            }



        }


        binding.singleplayerBtn.setOnClickListener{

            binding.singleP.setTextColor(Color.WHITE)
            binding.singleview.visibility = View.VISIBLE
            binding.RVSinglePlayer.visibility=View.VISIBLE

            binding.multiP.setTextColor(Color.BLACK)
            binding.multiv.visibility =View.GONE
            binding.RVMultiPlayer.visibility =View.GONE

        }


    }
}