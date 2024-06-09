package com.example.domain

import com.example.framework.stereotypes.domain.Aggregate
import java.math.BigDecimal

@Aggregate
sealed class Order(
    protected val items: MutableList<OrderItem> = mutableListOf()
) {
    val totalItems: List<OrderItem> get() = items.filter { it !is DiscardedOrderItem }
    val discardedItems: List<DiscardedOrderItem> get() = items.filterIsInstance<DiscardedOrderItem>()

    fun addItem(name: String, price: BigDecimal, quantity: Int) {
        require(items.none { it.name.equals(name, true) }) { "Item '$name' is included multiple times" }
        require(priceTotal.value < BigDecimal(MAX_PRICE_VALUE)) { "Total price must be less than $MAX_PRICE_VALUE,-" }
        items.add(NewOrderItem.create(name, price, quantity))
    }

    val priceTotal: Price get() = Price(totalItems
        .map { it.priceTotal.value }
        .fold(BigDecimal.ZERO, BigDecimal::add))

    companion object {
        const val MAX_PRICE_VALUE = 100.0
    }
}

class NewOrder : Order()

class PersistentOrder(val id: OrderId, items: List<PersistentOrderItem>) : Order(items.toMutableList()) {

    fun removeItemById(id: OrderItemId) {
        items.replaceAll { if (it is PersistentOrderItem && it.id == id) it.toDiscardedOrderItem() else it }
    }
}
