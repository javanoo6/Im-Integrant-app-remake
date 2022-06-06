package ru.leroymerlin.reader

import ru.leroymerlin.FileResourceUtil
import ru.leroymerlin.data.Revenue
import ru.leroymerlin.protocol.ReportType
import java.util.stream.Collectors

class RevenueReader{
    fun getRevenue(): Map<ReportType,Double>{
        val content = FileResourceUtil.getContentFromFile("billing/revenue.csv")
        return content.stream().skip(1)
//            .map { it.split(",").}
            .map { it.split(",".toRegex()).toTypedArray() }
//            .map{ Revenue(ReportType),it.get(1).toDouble())}
            .map{ Revenue(ReportType.valueOf(it.get(0)),it.get(1).toDouble()) }
            .collect(Collectors.toMap(Revenue::reportType, Revenue::profit))
    }
}


