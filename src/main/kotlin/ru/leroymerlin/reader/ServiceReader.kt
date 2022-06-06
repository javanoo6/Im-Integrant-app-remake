package ru.leroymerlin.reader

import ru.leroymerlin.FileResourceUtil
import ru.leroymerlin.data.Service
import java.util.stream.Collectors

class ServiceReader{
    fun getService(): List<Service>{
        val content = FileResourceUtil.getContentFromFile("reports/services.csv")
        return  content.stream().skip(1)
            .map { it.split(",".toRegex()).toTypedArray() }
            .map{ Service(it.get(0),it.get(1).toDouble(),it.get(2).toDouble()) }
            .collect(Collectors.toList())
    }
}