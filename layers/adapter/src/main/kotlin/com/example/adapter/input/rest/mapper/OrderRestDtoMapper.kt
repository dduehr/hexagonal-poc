package com.example.adapter.input.rest.mapper

import com.example.adapter.input.rest.model.NewOrderRestDto
import com.example.adapter.input.rest.model.OrderRestDto
import com.example.api.input.CreateOrderCommand
import com.example.domain.PersistentOrder

fun NewOrderRestDto.toCommand(): CreateOrderCommand =
    CreateOrderCommand(items.map { CreateOrderCommand.OrderItem(it.name, it.price, it.quantity) })

fun PersistentOrder.toRestDto(): OrderRestDto =
    OrderRestDto(id.value, persistentItems.map { it.toRestDto() })
