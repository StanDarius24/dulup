package com.stannis.dulup.controller

import com.stannis.dulup.services.OrderService
import com.stannis.dulup.view.OrderDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class OrderController {

    @Autowired
    private lateinit var orderService: OrderService

    @GetMapping("/orders")
    fun getAll() = try {
        orderService.getAllOrders()
    } catch (e: Exception) {
        throw e
    }

    @GetMapping("/orders/{id}")
    fun getOrderById(@PathVariable id: Long) = try {
        orderService.findById(id)
    } catch (e: Exception) {
        throw e
    }

    @PostMapping("/order")
    fun createOrder(order: OrderDto) = try {
        orderService.createOrder(order)
    } catch (e: Exception) {
        throw e
    }

}