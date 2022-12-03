package com.stannis.dulup.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor


@Table(name = "accounts")
@Entity
@AllArgsConstructor
@NoArgsConstructor
class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long = 0

    @Column
    var name: String? = null

    @Column
    var email: String? = null

    @Column
    var encryptedPassword: String? = null

    @Column
    var reputation: Long = 0

    @ManyToMany
    var orders: ArrayList<Order>? = null
}
