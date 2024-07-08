package com.example.adapter.input.rest.mapper

import com.example.adapter.input.rest.model.OrderRestDto
import com.example.domain.PersistentOrderItem

internal fun PersistentOrderItem.toRestDto(): OrderRestDto.OrderItemRestDto =
    OrderRestDto.OrderItemRestDto(id.value, name, price.value, quantity.value)