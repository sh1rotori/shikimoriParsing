@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.shikimoriparsing

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: AnimeViewModel = viewModel()
            val animeList by viewModel.animeList.collectAsState(emptyList())

            LaunchedEffect(viewModel) {
                viewModel.fetchAnimeList()
            }

            AnimeList(
                animeList = animeList,
                onItemClick = { anime ->

                }
            )
        }
    }
}
