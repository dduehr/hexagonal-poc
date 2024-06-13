package com.example.adapter.output.db

import com.example.adapter.output.db.mapper.toDbEntity
import com.example.adapter.output.db.mapper.toDomain
import com.example.adapter.output.db.model.OrderDbEntity
import com.example.adapter.output.db.repository.OrderDbRepository
import com.example.adapter.output.db.repository.OrderItemDbRepository
import com.example.api.output.OrderRepository
import com.example.domain.Order
import com.example.domain.OrderId
import com.example.domain.PersistentOrder
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
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
        val unsavedOrder: OrderDbEntity = order.toDbEntity()
        val savedOrder: OrderDbEntity = orderDbRepository.save(unsavedOrder)
        return savedOrder.toDomain()
    }

    override fun findById(id: OrderId): PersistentOrder? {
        val foundOrder: OrderDbEntity? = orderDbRepository.findByIdOrNull(id.value)
        return foundOrder?.toDomain()
    }
}