package ru.leroymerlin

import ru.leroymerlin.counter.ProfitCounter
import ru.leroymerlin.counter.RevenuerCounter
import ru.leroymerlin.reader.ItemReader
import ru.leroymerlin.reader.RevenueReader
import ru.leroymerlin.reader.ServiceReader

class BillingMenu {
    fun greeting() {
        println("Приветствуем в билинговой системе! Что вам требуется?")
        print()
//        var input = readLine()
        while (true) {
            when (readLine()) {
                "q" -> {
                    println("Надеемся, вам понравилось наше приложение!")
                    return
                }
                "1" -> {
                    println("Вы выбрали : Подсчёт минимальной прибыли по товару и услуге")
                    for (items in ItemReader().getItems().indices) {
                        val itemsProfit = ProfitCounter(ItemReader().getItems().get(items))
                        itemsProfit.showResultOfItems()
                    }
                    println()
                    for (service in ServiceReader().getService().indices) {
                        val servicesProfit = ProfitCounter(ServiceReader().getService().get(service))
                        servicesProfit.showResultOfServices()
                    }
                    print()
                }
                "2" -> {
                    println("Вы выбрали : Сверка прибыли по услугам и товарам")
                    val revenueCounter = RevenuerCounter(
                        ItemReader().getItems(),
                        ServiceReader().getService(),
                        RevenueReader().getRevenue()
                    )

                    if (revenueCounter.comparingItemsRevenue == false) {
                        revenueCounter.printResultOfItemsComparison()
                    }
                    if (revenueCounter.comparingServiceRevenue == false) {
                        revenueCounter.printResultOfServiceComparison()
                    }
                    print()

                }
                else -> {println("Команды не существует")
                print()}
            }

        }
    }

    private fun print() {
        println("Рассчёты: ")
        println("1 - Подсчёт минимальной прибыли по товару и услуге")
        println("2 - Сверка прибыли по услугам и товарам")
        println("Для завершения работы, нажмите 'q'")
    }
}