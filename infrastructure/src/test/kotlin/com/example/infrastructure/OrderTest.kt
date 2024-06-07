package com.example.infrastructure

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

class OrderTest {
    @Test
    fun `should return an order`() {
        val objectMapper = ObjectMapper()
        val order = Order(mutableListOf(OrderItem("item one", 1)))
        val json = objectMapper.writeValueAsString(order)
        println(json)
    }
}

// {
// "items":[{"item":"item one","quantity":1}]
// }