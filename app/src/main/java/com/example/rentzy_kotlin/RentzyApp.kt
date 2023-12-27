package com.example.rentzy_kotlin

import android.app.Application
import com.example.core2.di.repositoryModule
import com.example.core2.di.unitRefs
import com.example.rentzy_kotlin.di.unitListViewModelModule
import com.example.rentzy_kotlin.di.useCaseModule
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RentzyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(applicationContext)

        startKoin {
            androidContext(this@RentzyApp)
            modules(
                listOf(
                    unitRefs,
                    repositoryModule,
                    useCaseModule,
                    unitListViewModelModule,
                )
            )
        }
    }
}