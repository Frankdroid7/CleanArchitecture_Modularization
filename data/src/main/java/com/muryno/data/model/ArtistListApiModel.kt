package com.muryno.data.model

data class ArtistListApiModel(
    val artists: List<ArtistApiModel>,
    val count: Int,
    val created: String,
    val offset: Int
)