package com.example.praktikum10_176.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum10_176.model.Mahasiswa
import com.example.praktikum10_176.repository.RepositoryMahasiswa
import kotlinx.coroutines.launch

class DetailViewModel(
    private val mhsRepository: RepositoryMahasiswa
) : ViewModel() {
    var uiState by mutableStateOf(DetailUiState())
        private set

    fun fetchDetailMahasiswa(nim: String) {
        viewModelScope.launch {
            uiState = DetailUiState(isLoading = true)
            try {
                val mahasiswa = mhsRepository.getMahasiswabyNim(nim)
                uiState = DetailUiState(detailUiEvent = mahasiswa.toDetailUiEvent())
            } catch (e: Exception) {
                e.printStackTrace()
                uiState = DetailUiState(isError = true, errorMessage = "Failed to fetch details: ${e.message}")
            }
        }
    }
}

data class DetailUiState(
    val detailUiEvent: InsertUiEvent = InsertUiEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
) {
    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != InsertUiEvent()
}

fun Mahasiswa.toDetailUiEvent(): InsertUiEvent {
    return InsertUiEvent(
        nim = nim,
        nama = nama,
        alamat = alamat,
        jenisKelamin = jenisKelamin,
        kelas = kelas,
        angkatan = angkatan
    )
}