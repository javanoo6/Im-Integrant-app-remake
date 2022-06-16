package ru.leroymerlin.counter

import ru.leroymerlin.protocol.ReportType
import ru.leroymerlin.reader.ItemReader
import ru.leroymerlin.reader.RevenueReader
import ru.leroymerlin.reader.ServiceReader

class RevenueCounter {

    private val revenue = RevenueReader().getRevenue()
    private val itemsRevenue = revenue[ReportType.ITEM] as Double
    private val serviceRevenue = revenue[ReportType.SERVICE] as Double

    private val itemsProfit = ItemReader().getItems().sumOf { it.sum * it.commission * it.quantity / 100 }
    private val serviceProfit = ServiceReader().getService().sumOf { it.sum * it.commission / 100 }

    private val isProfitEqualsToItemsRevenue: Boolean = itemsProfit.equals(itemsRevenue)
    private val isProfitEqualsToServiceRevenue: Boolean = serviceProfit.equals(serviceRevenue)

    fun isProfitToRevenueCorrect() {
        if (!isProfitEqualsToItemsRevenue) println("Выручка по товарам $itemsProfit не совпадает с выручкой из отчёта $itemsRevenue") else {
            return
        }

        if (!isProfitEqualsToServiceRevenue) println("Выручка по услугам $serviceProfit не совпадает с выручкой из отчёта $serviceRevenue") else {
            return
        }
    }


}