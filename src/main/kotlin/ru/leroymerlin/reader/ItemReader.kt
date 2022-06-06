package ru.leroymerlin.reader

import ru.leroymerlin.FileResourceUtil
import ru.leroymerlin.data.Item
import java.util.stream.Collectors

class ItemReader {
    fun getItems():List<Item> {
        val content:List<String> = FileResourceUtil.getContentFromFile("reports/items.csv")
        return content.stream().skip(1).limit(content.size.toLong())

            .map {it.split(",".toRegex()).toTypedArray()}
            .map { Item(it.get(0), it.get(1).toDouble(), it.get(2).toInt(), it.get(3).toDouble()) }
            .collect(Collectors.toList())


    }
}