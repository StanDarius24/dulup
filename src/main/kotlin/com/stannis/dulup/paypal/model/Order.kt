package com.stannis.dulup.paypal.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
data class Order(
    val price: Double,
    val currency: String,
    val method: String,
    val intent: String,
    val description: String,
)