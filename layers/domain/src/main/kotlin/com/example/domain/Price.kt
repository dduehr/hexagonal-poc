package com.example.domain

import com.example.framework.stereotypes.domain.ValueObject
import java.math.BigDecimal

@JvmInline
@ValueObject
value class Price(val value: BigDecimal)