package com.example.adapter.output.db.repository

import com.example.adapter.output.db.model.OrderDbEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
internal interface OrderDbRepository : CrudRepository<OrderDbEntity, Long>