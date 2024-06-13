package com.example.api.input

import com.example.domain.PersistentOrder
import jakarta.validation.Valid
import jakarta.validation.constraints.Positive
import org.springframework.validation.annotation.Validated

@Validated
interface FindOrderByIdUseCase {
    fun execute(@Valid query: FindOrderByIdQuery): PersistentOrder?
}

data class FindOrderByIdQuery(@field:Positive val id: Long)
