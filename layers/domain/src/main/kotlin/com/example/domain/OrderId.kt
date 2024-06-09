package com.example.domain

import com.example.framework.stereotypes.domain.ValueObject

@JvmInline
@ValueObject
value class OrderId(val value: Long)