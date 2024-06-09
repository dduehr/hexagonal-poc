package com.example.adapter.input.rest.mapper

import com.example.adapter.input.rest.model.NewOrderRestDto
import com.example.api.input.CreateOrderCommand
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class OrderRestDtoMapperTest {
    @Test
    fun `map an empty order`() {
        val dto = NewOrderRestDto(listOf())
        val result = dto.toCommand()
        assertThat(result.items).isEmpty()
    }

    @Test
    fun `map an non-empty order`() {
        val dto = NewOrderRestDto(listOf(
            NewOrderRestDto.NewOrderItemRestDto("a name", BigDecimal(.99), 1)))
        val result = dto.toCommand()
        assertThat(result.items).containsExactly(
            CreateOrderCommand.OrderItem("a name", BigDecimal(.99), 1))
    }
}