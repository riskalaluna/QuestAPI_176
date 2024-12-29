package com.example.praktikum10_176.repository

import com.example.praktikum10_176.model.Mahasiswa

interface RepositoryMahasiswa {
    suspend fun getMahasiswa(): List<Mahasiswa>

    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)

    suspend fun deleteMahasiswa(nim: String)

    suspend fun getMahasiswaById(nim: String): Mahasiswa
}

class NetworkKontakRepository(
    private val kontakApiService:

    overide suspend fun 
)