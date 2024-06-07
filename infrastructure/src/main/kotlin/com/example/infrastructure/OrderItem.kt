package com.example.infrastructure

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "items")
class OrderItem (
    val item: String,
    val quantity: Int,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1) {

    constructor() : this("", 0)
}