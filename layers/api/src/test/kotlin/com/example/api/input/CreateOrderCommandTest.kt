package com.example.api.input

import jakarta.validation.Validation
import jakarta.validation.Validator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CreateOrderCommandTest {
    private lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        validator = Validation.buildDefaultValidatorFactory().validator
    }

    @Test
    @Disabled("FIXME: The validation does not fail")
    fun `The validation of an create order command with an empty item list should fail`() {
        val command = CreateOrderCommand(listOf())
        val violations = validator.validate(command)
        assertThat(violations).isNotEmpty
    }

    @Test
    @Disabled("FIXME: The validation does not fail")
    fun `The validation of an create order command with an invalid item should fail`() {
        val command = CreateOrderCommand(listOf(
            CreateOrderCommand.OrderItem("", BigDecimal(-0.99), -1)))
        val violations = validator.validate(command)
        assertThat(violations).isNotEmpty
    }
}