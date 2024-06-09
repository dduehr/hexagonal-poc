package com.example.adapter.output.db.mapper

import com.example.adapter.output.db.model.OrderItemDbEntity
import com.example.domain.ModifiedOrderItem
import com.example.domain.NewOrderItem
import com.example.domain.OrderItem
import com.example.domain.OrderItemId
import com.example.domain.PersistentOrderItem
import com.example.domain.Price
import com.example.domain.Quantity

fun OrderItem.toDbEntity(): OrderItemDbEntity {
    return when(this) {
        is NewOrderItem -> OrderItemDbEntity(name, price.value, quantity.value)
        is PersistentOrderItem -> OrderItemDbEntity(name, price.value, quantity.value, id.value)
        is ModifiedOrderItem -> OrderItemDbEntity(name, price.value, quantity.value, id.value)
        else -> throw IllegalArgumentException("Unsupported OrderItem type $this")
    }
}

fun OrderItemDbEntity.toDomain() = PersistentOrderItem(OrderItemId(id), name, Price(price), Quantity(quantity))