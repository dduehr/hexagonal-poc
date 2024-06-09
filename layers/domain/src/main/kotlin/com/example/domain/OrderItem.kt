package com.example.domain

import com.example.framework.stereotypes.domain.Entity
import java.math.BigDecimal

@Entity
sealed class OrderItem(
    val name: String,
    val price: Price,
    val quantity: Quantity
) {
    val priceTotal: Price get() = Price(price.value.multiply(BigDecimal(quantity.value)))
}

class NewOrderItem private constructor(name: String, price: Price, quantity: Quantity) :
    OrderItem(name, price, quantity) {

    companion object {
        fun create(name: String, price: BigDecimal, quantity: Int): NewOrderItem {
            require(name.isNotEmpty()) { "Name cannot be empty" }
            require(price >= BigDecimal(0)) { "Price must be zero or positive" }
            require(quantity > 0) { "Quantity must be greater than zero" }
            return NewOrderItem(name, Price(price), Quantity(quantity))
        }
    }
}

class PersistentOrderItem(val id: OrderItemId, name: String, price: Price, quantity: Quantity) :
    OrderItem(name, price, quantity) {

    fun toDiscardedOrderItem() = DiscardedOrderItem(id, name, price, quantity)
}

class ModifiedOrderItem(val id: OrderItemId, name: String, price: Price, quantity: Quantity) :
    OrderItem(name, price, quantity)

class DiscardedOrderItem(val id: OrderItemId, name: String, price: Price, quantity: Quantity) :
    OrderItem(name, price, quantity)