package com.example.rickyandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickyandmortyapp.presentation.characterlist.CharacterListScreen
import com.example.rickyandmortyapp.ui.theme.RickyAndMortyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharacterListScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickyAndMortyAppTheme {
        CharacterListScreen()
    }
}