package com.example.praktikum10_176.applications

import com.example.praktikum10_176.container.MahasiswaContainer

class MahasiswaApplications {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}