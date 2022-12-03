package com.stannis.dulup.controller

import com.stannis.dulup.services.ProductService
import com.stannis.dulup.view.ProductDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ProductController {

    @Autowired
    private lateinit var productService: ProductService

    @GetMapping("/products")
    fun getAll() = try {
        productService.getAllProducts()
    } catch (e: Exception) {
        throw e
    }

    @GetMapping("/products/{id}")
    fun getProductById(@PathVariable id: Long) = try {
        productService.getProductById(id)
    } catch (e: Exception) {
        throw e
    }

    @PostMapping("/product")
    fun createProduct(product: ProductDto) = try {
        productService.createProduct(product)
    } catch (e: Exception) {
        throw e
    }

}