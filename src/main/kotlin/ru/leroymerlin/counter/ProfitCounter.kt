package ru.leroymerlin.counter

import ru.leroymerlin.data.Item
import ru.leroymerlin.data.Service

class ProfitCounter {
    private val itemName: String
    private val sum: Double
    private val quantity: Int
    private val commission: Double


    constructor(item: Item) {
        this.itemName = item.itemName
        this.sum = item.sum
        this.quantity = item.quantity
        this.commission = item.commission


    }

    constructor(service: Service) {
        this.itemName = service.itemName
        this.sum = service.sum
        this.quantity = 1
        this.commission = service.commission
    }

    fun showResultOfItems(){
        println("Минимальная выручка  ${countProfit()}  по товару  $itemName, c комиссией $commission")
    }
    fun showResultOfServices(){
        println("Минимальная выручка  ${countProfit()}  по услуге  $itemName, c комиссией $commission")
    }
    fun countProfit():Double{
        return this.sum*this.quantity*this.commission/100
    }

}