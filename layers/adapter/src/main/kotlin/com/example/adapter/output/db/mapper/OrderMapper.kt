package com.example.adapter.output.db.mapper

import com.example.adapter.output.db.model.OrderDbEntity
import com.example.domain.Order
import com.example.domain.OrderId
import com.example.domain.PersistentOrder

internal fun Order.toDbEntity(): OrderDbEntity = OrderDbEntity(totalItems.map { it.toDbEntity() }.toMutableList())

internal fun OrderDbEntity.toDomain(): PersistentOrder = PersistentOrder(OrderId(id), items.map { it.toDomain() })
