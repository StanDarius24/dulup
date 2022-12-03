package com.stannis.dulup.converters

import com.stannis.dulup.entity.Product
import com.stannis.dulup.view.ProductDto
import org.springframework.stereotype.Service

@Service
class ProductConverter {

    fun toEntity(productDto: ProductDto) :Product {
        val product = Product()
        productDto.name?.let { product.name = it }
        productDto.description?.let { product.description = it }
        productDto.price?.let { product.price = it }
        productDto.category?.let { product.category = it }
        productDto.images?.let { product.images = it }
        productDto.location?.let { product.location = it }
        return product
    }

    fun toDto(entityProduct: Product): ProductDto {
        return ProductDto(
            entityProduct.id,
            entityProduct.name,
            entityProduct.description,
            entityProduct.category,
            entityProduct.images,
            entityProduct.price,
            entityProduct.location
        )
    }

}