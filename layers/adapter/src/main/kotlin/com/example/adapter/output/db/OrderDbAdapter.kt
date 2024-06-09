package com.example.adapter.output.db

import com.example.adapter.output.db.mapper.toDbEntity
import com.example.adapter.output.db.mapper.toDomain
import com.example.adapter.output.db.repository.OrderDbRepository
import com.example.adapter.output.db.repository.OrderItemDbRepository
import com.example.api.output.OrderRepository
import com.example.domain.Order
import com.example.domain.PersistentOrder
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class OrderDbAdapter(
    private val orderDbRepository: OrderDbRepository,
    private val orderItemDbRepository: OrderItemDbRepository
) : OrderRepository {

    @Transactional
    override fun save(order: Order): PersistentOrder {
        if (order is PersistentOrder) {
            orderItemDbRepository.deleteAllById(order.discardedItems.map { it.id.value })
        }
        val unsavedOrder = order.toDbEntity()
        val savedOrder = orderDbRepository.save(unsavedOrder)
        return savedOrder.toDomain()
    }
}