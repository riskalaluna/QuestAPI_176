package com.example.praktikum10_176.applications

import android.app.Application
import com.example.praktikum10_176.container.AppContainer
import com.example.praktikum10_176.container.MahasiswaContainer

class MahasiswaApplications:Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}