package com.stannis.dulup.repository

import com.stannis.dulup.entity.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: CrudRepository<Order, Long> {

}
