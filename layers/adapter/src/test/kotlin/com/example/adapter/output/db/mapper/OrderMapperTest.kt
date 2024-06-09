package com.example.adapter.output.db.mapper

import com.example.domain.NewOrder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class OrderMapperTest {
    @Test
    fun test() {
        val newOrder = NewOrder()
        newOrder.addItem("a name", BigDecimal(0.99), 1)
        val result = newOrder.toDbEntity()
        assertThat(result.items.size).isOne()
    }
}