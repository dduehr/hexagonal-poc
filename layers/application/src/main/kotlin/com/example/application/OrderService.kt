package com.example.application

import com.example.api.input.CreateOrderCommand
import com.example.api.input.CreateOrderUseCase
import com.example.api.input.FindOrderByIdQuery
import com.example.api.input.FindOrderByIdUseCase
import com.example.api.output.OrderRepository
import com.example.application.mapper.toDomain
import com.example.domain.NewOrder
import com.example.domain.OrderId
import com.example.domain.PersistentOrder
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: OrderRepository) :
    CreateOrderUseCase, FindOrderByIdUseCase {

    override fun execute(command: CreateOrderCommand): PersistentOrder {
        val newOrder: NewOrder = command.toDomain()
        return orderRepository.save(newOrder)
    }

    override fun execute(query: FindOrderByIdQuery): PersistentOrder? {
        val id: OrderId = query.toDomain()
        return orderRepository.findById(id)
    }
}