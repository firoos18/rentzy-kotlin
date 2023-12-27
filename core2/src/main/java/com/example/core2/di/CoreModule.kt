package com.example.core2.di

import com.example.core2.remote.UnitRepositoryImpl
import com.example.core2.domain.repository.UnitRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.koin.dsl.module


val unitRefs = module {
    single {
        Firebase.firestore.collection("units")
    }
}

val repositoryModule = module {
    single<UnitRepository> {
        UnitRepositoryImpl(get())
    }
}