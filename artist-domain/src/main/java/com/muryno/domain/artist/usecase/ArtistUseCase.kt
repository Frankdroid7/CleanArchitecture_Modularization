package com.muryno.domain.artist.usecase

import com.muryno.domain.artist.model.ArtistDomainModel
import com.muryno.domain.artist.repository.ArtistRepository
import com.muryno.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import com.muryno.domain.cleanarchitecture.usecase.BackgroundExecutingUseCase

class ArtistUseCase(
    private val artistRepository: ArtistRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<String, List<ArtistDomainModel>>(coroutineContextProvider) {
    override suspend fun executeInBackground(
        request: String
    ) = artistRepository.artistList(artistName = request)
}