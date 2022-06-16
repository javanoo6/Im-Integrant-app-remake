package ru.leroymerlin.reader

import ru.leroymerlin.FileResourceUtil
import ru.leroymerlin.data.Service

class ServiceReader {
    fun getService(): List<Service> {
        val content = FileResourceUtil.getContentFromFile("reports/services.csv")

        return content.drop(1)
            .map { it.split(",".toRegex()).toTypedArray() }
            .map { Service(it[0], it[1].toDouble(), it[2].toDouble()) }
    }
}