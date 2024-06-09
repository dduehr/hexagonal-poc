package com.example.domain

import com.example.framework.stereotypes.domain.ValueObject

@JvmInline
@ValueObject
value class Quantity(val value: Int)