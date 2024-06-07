package com.example.infrastructure

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table


@Entity
@Table(name = "orders")
class Order (
    @OneToMany(cascade = [(CascadeType.ALL)])
    val items: MutableList<OrderItem>,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1) {

    constructor() : this(mutableListOf())
}