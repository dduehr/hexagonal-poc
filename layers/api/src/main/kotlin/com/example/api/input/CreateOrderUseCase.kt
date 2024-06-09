package com.example.api.input

import com.example.domain.PersistentOrder
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated

@Validated
interface CreateOrderUseCase {
    fun execute(@Valid command: CreateOrderCommand): PersistentOrder
}