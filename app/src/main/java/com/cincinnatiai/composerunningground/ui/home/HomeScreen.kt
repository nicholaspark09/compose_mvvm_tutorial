package com.cincinnatiai.composerunningground.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val searchText by remember {
        mutableStateOf("")
    }
    val isSearching by remember {
        mutableStateOf(false)
    }


    Scaffold(Modifier.padding(16.dp),
        topBar = {
            SearchBar(query = searchText, onQueryChange = {}, onSearch = {}, active = isSearching, onActiveChange = {}) {
                
            }
        }) {
        Text(text = "Home")
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}