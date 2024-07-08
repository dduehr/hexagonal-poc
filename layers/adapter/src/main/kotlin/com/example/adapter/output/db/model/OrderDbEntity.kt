package com.example.adapter.output.db.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table


@Entity
@Table(name = "orders")
internal class OrderDbEntity (
    @OneToMany(cascade = [(CascadeType.ALL)])
    val items: MutableList<OrderItemDbEntity>,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1) {

    constructor() : this(mutableListOf())
}