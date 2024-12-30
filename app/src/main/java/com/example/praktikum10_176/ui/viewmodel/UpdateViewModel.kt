package com.example.praktikum10_176.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum10_176.repository.RepositoryMahasiswa
import kotlinx.coroutines.launch


class UpdateViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMahasiswa: RepositoryMahasiswa
): ViewModel(){
    var updateUiState by mutableStateOf(InsertUiState())
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinasiUpdate.NIM])

    init {
        viewModelScope.launch {
            updateUiState = repositoryMahasiswa.getMahasiswabyNim(_nim)
                .toUiStateMhs()
        }
    }

    fun updateInsertMhsState(insertUiEvent: InsertUiEvent) {
        updateUiState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun updateMhs() {
        viewModelScope.launch {
            try {
                repositoryMahasiswa.updateMahasiswa(_nim, updateUiState.insertUiEvent.toMhs())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

}