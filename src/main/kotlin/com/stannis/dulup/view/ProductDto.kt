package com.stannis.dulup.view


data class ProductDto(

    var id : Long?,
    var name: String?,
    var description: String?,
    var category: String?,
    var images: List<String>?,
    var price: Long?,
    var location: String?,

)
