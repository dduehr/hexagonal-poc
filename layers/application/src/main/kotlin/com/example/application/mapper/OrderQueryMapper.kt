package com.example.application.mapper

import com.example.api.input.FindOrderByIdQuery
import com.example.domain.OrderId

fun FindOrderByIdQuery.toDomain(): OrderId = OrderId(id)