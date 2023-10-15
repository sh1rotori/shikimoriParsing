package com.example.shikimoriparsing

import org.jsoup.Jsoup

class AnimeRepository {
    private val baseUrl = "https://shikimori.me"

    suspend fun fetchAnimeList(): List<Anime> {
        val animeList = mutableListOf<Anime>()
        try {
            val document = Jsoup.connect("$baseUrl/animes").get()
            val elements = document.select("div.cc-entries")

            elements.forEach { element ->
                val titleElements = element.select(".title.left_aligned .name-ru")
                val imageElements = element.select(".cover img")

                val formatElement = element.select(".misc span")
                val yearElement = element.select(".misc .right ")

                titleElements.forEachIndexed { index, titleElement ->
                    val title = titleElement.text()
                    val imageUrl = imageElements.getOrNull(index)?.attr("src") ?: ""

                    val format = formatElement.getOrNull(index)?.text() ?: ""
                    val year = yearElement.getOrNull(index)?.text() ?: ""

                    val anime = Anime(title, imageUrl, format, year)
                    animeList.add(anime)
                }
            }
        } catch (e: Exception) {
            // Обработка ошибок при парсинге данных
        }
        return animeList
    }
}

