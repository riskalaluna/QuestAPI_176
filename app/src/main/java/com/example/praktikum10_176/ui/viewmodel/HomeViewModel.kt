package com.example.praktikum10_176.ui.viewmodel

import com.example.praktikum10_176.model.Mahasiswa

sealed class HomeUiState{
    data class Succsess(val mahasiswa: List<Mahasiswa>): HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}
