package com.example.adapter.input.rest

import com.example.adapter.input.rest.mapper.toCommand
import com.example.adapter.input.rest.model.NewOrderRestDto
import com.example.api.input.CreateOrderCommand
import com.example.api.input.CreateOrderUseCase
import com.example.domain.PersistentOrder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderRestController(private var createOrderUseCase: CreateOrderUseCase) {

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@RequestBody dto: NewOrderRestDto): Long {
        val command: CreateOrderCommand = dto.toCommand()
        val orderCreated: PersistentOrder = createOrderUseCase.execute(command)
        return orderCreated.id.value
    }
}