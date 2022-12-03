package com.stannis.dulup.view

import java.time.LocalDateTime

data class OrderDto(

    var id : Long?,
    var status: String?,
    var date: LocalDateTime?,
    var buyerId: Long?,
    var sellerId: Long?,
    var paypalOrderId: Long?,
    var productId: Long?,

)
