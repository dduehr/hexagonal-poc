package com.example.application.mapper

import com.example.api.input.CreateOrderCommand
import com.example.domain.NewOrder

fun CreateOrderCommand.toDomain(): NewOrder =
    NewOrder().apply { items.forEach { item -> addItem(item.name, item.price, item.quantity) } }
