package com.example.api.output

import com.example.domain.Order
import com.example.domain.OrderId
import com.example.domain.PersistentOrder

interface OrderRepository {
    fun save(order: Order): PersistentOrder
    fun findById(id: OrderId): PersistentOrder?
}