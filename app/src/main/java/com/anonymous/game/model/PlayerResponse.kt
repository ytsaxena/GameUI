package com.anonymous.game.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PlayerResponse(
    @SerialName("singlePlayer") val singlePlayer :ArrayList<PlayerData>,
    @SerialName("multiPlayer") val multiPlayer:ArrayList<PlayerData>
)
