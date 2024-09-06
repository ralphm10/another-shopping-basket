package org.example

import java.math.BigDecimal

data class GroceryItem(val description: String, val unitPrice: String, var quantity: Int = 1) {
    fun subTotal(): BigDecimal = BigDecimal(unitPrice).multiply(BigDecimal(quantity))
}
