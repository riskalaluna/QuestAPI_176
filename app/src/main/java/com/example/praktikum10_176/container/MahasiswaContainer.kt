package com.example.praktikum10_176.container

import com.example.praktikum10_176.model.Mahasiswa
import com.example.praktikum10_176.repository.NetworkKontakRepository
import com.example.praktikum10_176.repository.RepositoryMahasiswa
import com.example.praktikum10_176.service.MahasiswaService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface MahasiswaContainer {
    val kontakRepository: RepositoryMahasiswa
}

class MahasiswaContainer : AppContainer{
    private val baseUrl = "http://10.0.2.2:8000/umyTI/" //localhost diganti ip kl run di hp
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val mahasiswaService: MahasiswaService by lazy {
        retrofit.create(MahasiswaService::class.java) }

    override val kontakRepository: RepositoryMahasiswa by lazy {
        NetworkKontakRepository(mahasiswaService)
    }
}