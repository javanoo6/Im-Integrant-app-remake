package ru.leroymerlin

import ru.leroymerlin.counter.ProfitCounter
import ru.leroymerlin.counter.RevenueCounter

class BillingMenu {
    fun greeting() {
        println("Приветствуем в билинговой системе! Что вам требуется? \n")

        showBillingCommands()

        while (true) {
            when (readLine()) {
                "q" -> {
                    println("Надеемся, вам понравилось наше приложение!")
                    return
                }
                "1" -> {
                    println("Вы выбрали : Подсчёт минимальной прибыли по товару и услуге")
                    ProfitCounter().showMinProfitOfItemsAndService()
                }
                "2" -> {
                    println("Вы выбрали : Сверка прибыли по услугам и товарам")
                    RevenueCounter().isProfitToRevenueCorrect()
                }
                else -> {
                    println("Команды не существует")
                }
            }
            showBillingCommands()
        }
    }

    private fun showBillingCommands() {
        println("Рассчёты: ")
        println("1 - Подсчёт минимальной прибыли по товару и услуге")
        println("2 - Сверка прибыли по услугам и товарам")
        println("Для завершения работы, нажмите 'q'")
    }
}
