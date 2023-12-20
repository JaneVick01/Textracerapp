package com.example.textracerapp.data

data class ListItem (
val id: Int,
val title: String,
val subtitle: String
)

val listItems = listOf(
    ListItem(1,"Jane doe", "Subtitle for item 1"),
    ListItem(2, "Robert C. Williams", "Subtitle for item 2")
)