package com.anonymous.game.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PlayerData(
    @SerialName("gameName") val gameName: String,
    @SerialName("imgName") val gameImg: String
)
