package com.stannis.dulup.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
class Order {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id : Long = 0

    @Column
    var status: String? = null

    @Column
    var date: LocalDateTime? = null

    @ManyToOne
    var buyer: Account? = null

    @ManyToOne
    var seller: Account? = null

    @Column
    var paypalOrderId: Long = 0

    @ManyToOne
    var product: Product? = null

}