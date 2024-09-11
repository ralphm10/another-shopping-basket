package org.example

import java.math.BigDecimal

data class GroceryItem(val description: String, val unitPrice: String, val vatRate: String = "0",  var quantity: Int = 1) {
    fun subTotal(): BigDecimal = unitPriceIncVat().multiply(BigDecimal(quantity)).setScale(2, BigDecimal.ROUND_HALF_UP)
    fun unitPriceIncVat(): BigDecimal = BigDecimal(unitPrice).multiply((BigDecimal("1").add(BigDecimal(vatRate)))).setScale(2, BigDecimal.ROUND_HALF_UP)
}
