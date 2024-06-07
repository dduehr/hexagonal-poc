package com.example.infrastructure

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderItemsRepository : CrudRepository<OrderItem, Long>