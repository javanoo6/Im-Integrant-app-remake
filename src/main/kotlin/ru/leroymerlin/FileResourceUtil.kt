package ru.leroymerlin

import java.nio.file.Files
import java.nio.file.Path

class FileResourceUtil {
 companion object {
    fun getContentFromFile(file: String): List<String> {
        val classLoader :ClassLoader = FileResourceUtil::class.java.classLoader
        val resource = classLoader.getResource(file)

        when (resource) {
            null -> {
                throw IllegalArgumentException("file not found!"+file)
            }
            else -> {
                return Files.readAllLines(Path.of(resource.toURI()))
            }
        }
    }
}}