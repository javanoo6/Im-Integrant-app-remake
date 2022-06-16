package ru.leroymerlin.reader

import ru.leroymerlin.FileResourceUtil
import ru.leroymerlin.data.Revenue
import ru.leroymerlin.protocol.ReportType

class RevenueReader {
    fun getRevenue(): Map<ReportType, Double> {
        val content = FileResourceUtil.getContentFromFile("billing/revenue.csv")

        return content.drop(1)
            .map { it.split(",".toRegex()).toTypedArray() }
            .map { Revenue(ReportType.valueOf(it.get(0)), it.get(1).toDouble()) }
            .associate { it.reportType to it.profit }
    }
}


