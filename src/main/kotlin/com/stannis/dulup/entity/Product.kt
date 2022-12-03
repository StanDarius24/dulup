package com.stannis.dulup.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id : Long = 0

    @Column
    var name: String? = null

    @Column
    var description: String? = null

    @Column
    var category: String? = null

    @ElementCollection
    var images = listOf<String>()

    @Column
    var price: Long = 0

    @Column
    var location: String? = null

}