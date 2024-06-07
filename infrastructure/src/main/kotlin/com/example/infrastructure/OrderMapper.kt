package com.example.infrastructure

fun OrderDto.toOrder(): Order {
    val orderItems = items.map { OrderItem(it.item, it.quantity) }
    return Order(orderItems.toMutableList())
}