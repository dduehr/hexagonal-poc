package com.example.adapter.input.rest

import com.example.adapter.input.rest.mapper.toCommand
import com.example.adapter.input.rest.mapper.toRestDto
import com.example.adapter.input.rest.model.NewOrderRestDto
import com.example.adapter.input.rest.model.OrderRestDto
import com.example.api.input.CreateOrderCommand
import com.example.api.input.CreateOrderUseCase
import com.example.api.input.FindOrderByIdQuery
import com.example.api.input.FindOrderByIdUseCase
import com.example.domain.PersistentOrder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class OrderRestController(
    private var createOrderUseCase: CreateOrderUseCase,
    private var findOrderByIdUseCase: FindOrderByIdUseCase
) {

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@RequestBody dto: NewOrderRestDto): Long {
        val command: CreateOrderCommand = dto.toCommand()
        val orderCreated: PersistentOrder = createOrderUseCase.execute(command)
        return orderCreated.id.value
    }

    @GetMapping("/orders/{id}")
    fun findOrderById(@PathVariable("id") id: Long): OrderRestDto {
        val query = FindOrderByIdQuery(id)
        val orderFound: PersistentOrder = findOrderByIdUseCase.execute(query)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        return orderFound.toRestDto()
    }
}