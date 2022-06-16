package ru.leroymerlin.reader

import ru.leroymerlin.FileResourceUtil
import ru.leroymerlin.data.Item

class ItemReader {
    fun getItems(): List<Item> {
        val content: List<String> = FileResourceUtil.getContentFromFile("reports/items.csv")

        return content.drop(1)
            .map { it.split(",".toRegex()).toTypedArray() }
            .map { Item(it[0], it[1].toDouble(), it[2].toInt(), it[3].toDouble()) }

    }
}