package com.anonymous.game.repository

import com.anonymous.game.DummyJSON
import com.anonymous.game.model.PlayerResponse
import kotlinx.serialization.json.Json

class GameRepo {

    fun getGames() :PlayerResponse {
        return Json.decodeFromString(DummyJSON.json)
    }


}