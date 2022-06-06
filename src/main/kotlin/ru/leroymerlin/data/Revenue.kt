package ru.leroymerlin.data

import ru.leroymerlin.protocol.ReportType

class Revenue(
    val reportType: ReportType,
    val profit:Double
) {
    override fun toString(): String {
        return "Reconciliation(reportType=$reportType, profit=$profit)"
    }
}