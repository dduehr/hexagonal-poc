package com.example.adapter.output.db.repository

import com.example.adapter.output.db.model.OrderItemDbEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderItemDbRepository : CrudRepository<OrderItemDbEntity, Long>