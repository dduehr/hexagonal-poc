package com.example.adapter.input.rest.model

import java.math.BigDecimal

data class OrderRestDto(
    val id: Long,
    val items: List<OrderItemRestDto>
) {
    data class OrderItemRestDto(
        val id: Long,
        val name: String,
        val price: BigDecimal,
        val quantity: Int
    )
}
