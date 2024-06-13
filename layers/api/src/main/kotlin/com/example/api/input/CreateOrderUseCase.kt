package com.example.api.input

import com.example.domain.PersistentOrder
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.springframework.validation.annotation.Validated
import java.math.BigDecimal

@Validated
interface CreateOrderUseCase {
    fun execute(@Valid command: CreateOrderCommand): PersistentOrder
}

data class CreateOrderCommand(
    @field:NotEmpty(message = "The list of order items may not be empty")
    val items: List<OrderItem>
) {
    data class OrderItem(
        @field:NotEmpty(message = "The name of the order item may not be empty")
        val name: String,
        @field:PositiveOrZero(message = "The price of the order item must be greater than or equal to zero")
        val price: BigDecimal,
        @field:Positive(message = "The quantity of the order item must be greater than zero")
        val quantity: Int
    )
}