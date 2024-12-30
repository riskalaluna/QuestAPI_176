package com.example.praktikum10_176.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum10_176.MahasiswaApplications
import com.example.praktikum10_176.ui.viewmodel.DetailViewModel
import com.example.praktikum10_176.ui.viewmodel.HomeViewModel
import com.example.praktikum10_176.ui.viewmodel.InsertViewModel
import com.example.praktikum10_176.ui.viewmodel.UpdateViewModel

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiKontak().container.kontakRepository) }
        initializer { InsertViewModel(aplikasiKontak().container.kontakRepository) }
        initializer { DetailViewModel(aplikasiKontak().container.kontakRepository) }
        initializer { UpdateViewModel(createSavedStateHandle(),aplikasiKontak().container.kontakRepository) }
    }
}
fun CreationExtras.aplikasiKontak(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)