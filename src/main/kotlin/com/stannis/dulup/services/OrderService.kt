package com.stannis.dulup.services

import com.stannis.dulup.converters.OrderConverter
import com.stannis.dulup.entity.Order
import com.stannis.dulup.repository.OrderRepository
import com.stannis.dulup.view.OrderDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.context.annotation.Lazy


@Service
class OrderService {

    @Autowired
    private lateinit var orderRepository: OrderRepository

    @Autowired
    private lateinit var orderConverter: OrderConverter

    @Lazy
    @Autowired
    private lateinit var accountService: AccountService

    @Lazy
    @Autowired
    private lateinit var productService: ProductService

    fun findById(id: Long) = orderRepository.findById(id)

    fun getAllOrders(): MutableIterable<Order> = orderRepository.findAll()

    fun createOrder(order: OrderDto): OrderDto {
        val entityOrder = orderRepository.save(orderConverter.toEntity(order, accountService, productService))
        return orderConverter.toDto(entityOrder)
    }

}