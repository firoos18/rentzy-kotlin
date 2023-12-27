package com.example.rentzy_kotlin.unitList

import android.util.Log
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun UnitListScreen(
    viewModel: UnitListViewModel = koinViewModel()
) {
    Log.e("DATA",viewModel.state.value.toString())
}