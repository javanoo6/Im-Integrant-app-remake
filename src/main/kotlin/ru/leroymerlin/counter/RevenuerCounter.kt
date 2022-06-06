package ru.leroymerlin.counter

import ru.leroymerlin.data.Item
import ru.leroymerlin.data.Service
import ru.leroymerlin.protocol.ReportType

class RevenuerCounter(items: List<Item>, services: List<Service>, revenue: Map<ReportType, Double>) {

    var fullSumOfItemsFromItems: Double = .0
    var fullSumOfServicesFromServices: Double = .0
    var fullSumOfItemsFromRevenue: Double
    var fullSumOfServicesFromRevenue: Double



    init {
        fullSumOfItemsFromRevenue = revenue.get(ReportType.ITEM) as Double
        fullSumOfServicesFromRevenue = revenue.get(ReportType.SERVICE) as Double

        for (item in items) {
            fullSumOfItemsFromItems += item.sum * item.quantity / 100 * item.commission
        }

        for (service in services) {
            fullSumOfServicesFromServices += service.sum / 100 * service.commission
        }

    }

    val comparingItemsRevenue: Boolean
        get() = fullSumOfItemsFromItems.equals(fullSumOfItemsFromRevenue)

    val comparingServiceRevenue: Boolean
        get() = fullSumOfServicesFromServices.equals(fullSumOfServicesFromRevenue)

    fun printResultOfItemsComparison(){
        println("Выручка по товарам $fullSumOfItemsFromItems не совпадает с выручкой из отчёта $fullSumOfItemsFromRevenue")
    }
    fun printResultOfServiceComparison(){
        println("Выручка по услугам $fullSumOfServicesFromServices не совпадает с выручкой из отчёта $fullSumOfServicesFromRevenue")
    }


}