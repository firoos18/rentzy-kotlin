package com.example.rentzy_kotlin.unitList

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun UnitListScreen(
    viewModel: UnitListViewModel = koinViewModel(),
    modifier : Modifier
) {
    val state = viewModel.state.value

    LazyColumn(
        modifier.fillMaxSize()
    ) {
        items(state.units) { units ->
            Text(text =  units.name ?: "Test")
        }
    }
}