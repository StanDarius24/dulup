package com.stannis.dulup.converters

import com.stannis.dulup.entity.Order
import com.stannis.dulup.services.AccountService
import com.stannis.dulup.services.ProductService
import com.stannis.dulup.view.OrderDto
import org.springframework.stereotype.Service

@Service
class OrderConverter {

    fun toEntity(orderDto: OrderDto, accountService: AccountService, productService: ProductService) : Order {
        val order = Order()
        orderDto.status?.let { order.status = it }
        orderDto.date?.let { order.date = it }
        orderDto.buyerId?.let { accountService.getAccount(it).let { it2 -> order.buyer = it2 } }
        orderDto.sellerId?.let { accountService.getAccount(it).let { it2 -> order.seller = it2 } }
        orderDto.paypalOrderId?.let { order.paypalOrderId = it }
        orderDto.productId?.let { productService.getProductById(it).ifPresent { product -> order.product = product } }

        return order
    }

    fun toDto(entityOrder: Order): OrderDto {
        return OrderDto(
                entityOrder.id,
                entityOrder.status,
                entityOrder.date,
            entityOrder.buyer?.id,
            entityOrder.seller?.id,
                entityOrder.paypalOrderId,
            entityOrder.product?.id
        )
    }

}