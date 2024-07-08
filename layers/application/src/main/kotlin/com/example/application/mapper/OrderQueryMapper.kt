package com.example.application.mapper

import com.example.api.input.FindOrderByIdQuery
import com.example.domain.OrderId

internal fun FindOrderByIdQuery.toDomain(): OrderId = OrderId(id)