package com.example.adapter.input.rest.mapper

import com.example.adapter.input.rest.model.NewOrderRestDto
import com.example.api.input.CreateOrderCommand

fun NewOrderRestDto.toCommand(): CreateOrderCommand =
    CreateOrderCommand(items.map { CreateOrderCommand.OrderItem(it.name, it.price, it.quantity) })