package com.stannis.dulup.services

import com.stannis.dulup.converters.ProductConverter
import com.stannis.dulup.entity.Product
import com.stannis.dulup.repository.ProductRepository
import com.stannis.dulup.view.ProductDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var productConverter: ProductConverter

    fun getAllProducts(): MutableIterable<Product> = productRepository.findAll()

    fun getProductById(id: Long) = productRepository.findById(id)

    fun createProduct(product: ProductDto): ProductDto {
        val newProduct = productRepository.save(productConverter.toEntity(product))
        return productConverter.toDto(newProduct)
    }

}