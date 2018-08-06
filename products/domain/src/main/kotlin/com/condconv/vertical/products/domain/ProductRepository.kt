package com.condconv.vertical.products.domain

interface ProductRepository {
    fun create(name: String): Product;

    fun findAll(): List<Product>
    fun findById(id: Long): Product
    fun findByName(name: String): List<Product>

    fun update(id: Long, product: Product): Product

    fun delete(id: Long)
}
