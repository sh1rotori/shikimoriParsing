package com.example.shikimoriparsing

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import java.time.format.TextStyle

@Composable
fun AnimeList(animeList: List<Anime>, onItemClick: (Anime) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(animeList) { anime ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.clickable { onItemClick(anime) }
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = anime.previewImageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )

                    Text(
                        text = anime.title,
                        style = androidx.compose.ui.text.TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(8.dp)
                    )

                    Text(
                        text = anime.releaseFormat,
                        style = androidx.compose.ui.text.TextStyle(fontWeight = FontWeight.Normal), fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )

                    Text(
                        text = anime.releaseYear,
                        style = androidx.compose.ui.text.TextStyle(fontWeight = FontWeight.Normal), fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                }
            }

        }
    }
}



@Composable
fun AnimeItem(anime: Anime, onItemClick: (Anime) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.clickable { onItemClick(anime) }
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = anime.previewImageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                text = anime.title,
                style = androidx.compose.ui.text.TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(8.dp)
            )



        }
    }
}
