package com.example.infrastructure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebController {

    @Autowired
    lateinit var repository: OrderRepository

    @PostMapping("/orders")
    fun createOrder(@RequestBody orderDto: OrderDto): Long {
        val order = orderDto.toOrder()
        val result = repository.save(order)
        return result.id
    }
}