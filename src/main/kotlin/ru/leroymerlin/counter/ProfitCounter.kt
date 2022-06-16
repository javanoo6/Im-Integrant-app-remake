package ru.leroymerlin.counter

import ru.leroymerlin.reader.ItemReader
import ru.leroymerlin.reader.ServiceReader

class ProfitCounter {

    fun showMinProfitOfItemsAndService() {
        ItemReader().getItems().associateBy { it.sum * it.commission * it.quantity / 100 }.minByOrNull { it.key }
            ?.also { println("Минимальная выручка ${it.key} по товару ${it.value.itemName} с комиссией ${it.value.commission}") }

        ServiceReader().getService().associateBy { it.sum * it.commission / 100 }.minByOrNull { it.key }
            ?.also { println("Минимальная выручка ${it.key} по уcлуге ${it.value.itemName} с комиссией ${it.value.commission}") }
    }

}

