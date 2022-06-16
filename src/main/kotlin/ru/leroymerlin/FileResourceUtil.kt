package ru.leroymerlin

import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Path

object FileResourceUtil {
    fun getContentFromFile(file: String): List<String> {
        val classLoader: ClassLoader = FileResourceUtil::class.java.classLoader
        val resource = classLoader.getResource(file)
        return resource?.let { Files.readAllLines(Path.of(it.toURI())) }
            ?: throw FileNotFoundException("$file was not found, please specify root")
    }

}
