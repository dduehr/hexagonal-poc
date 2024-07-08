package com.example.adapter.input.rest.model

import java.math.BigDecimal

internal data class NewOrderRestDto(
    val items: List<NewOrderItemRestDto>
) {
    data class NewOrderItemRestDto(
        val name: String,
        val price: BigDecimal,
        val quantity: Int
    )
}
