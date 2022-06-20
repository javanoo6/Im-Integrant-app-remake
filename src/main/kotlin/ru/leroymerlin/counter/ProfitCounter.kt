package ru.leroymerlin.counter

import ru.leroymerlin.data.ResultAsData
import ru.leroymerlin.reader.ItemReader
import ru.leroymerlin.reader.ServiceReader

class ProfitCounter {


    fun showMinProfitOfItemsAndService() {
        ItemReader().getItems()
            .associateBy { it.sum * it.commission * it.quantity / 100 }
            .map { ResultAsData(it.key, it.value.itemName, it.value.commission) }
            .minByOrNull { it.profit }
            ?.also { println("Минимальная выручка ${it.profit} по товару ${it.itemName} с комиссией ${it.commission}") }


        ServiceReader().getService()
            .associateBy { it.sum * it.commission / 100 }
            .map { ResultAsData(it.key, it.value.itemName, it.value.commission) }
            .minByOrNull { it.profit }
            ?.also { println("Минимальная выручка ${it.profit} по уcлуге ${it.itemName} с комиссией ${it.commission}") }
    }

}

