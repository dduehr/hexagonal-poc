package com.example.adapter.output.db.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal


@Entity
@Table(name = "items")
internal class OrderItemDbEntity (
    val name: String,
    val price: BigDecimal,
    val quantity: Int,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1) {

    constructor() : this("", BigDecimal.ZERO, 0)
}