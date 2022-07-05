package com.example.rickyandmortyapp.presentation.characterlist.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.rickyandmortyapp.data.remote.dto.CharacterResponseDto

@Composable
fun CharacterListItem(
    character: CharacterResponseDto,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${character.id} - ${character.name} - ${character.status}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}