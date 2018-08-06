package com.condconv.vertical.products.persistence

import com.condconv.vertical.products.domain.Product
import com.condconv.vertical.products.domain.ProductRepository
import org.springframework.stereotype.Service

@Service
class InMemoryProductRepository: ProductRepository {

    private val products = ArrayList<Product>();

    override fun create(name: String): Product {
        val product = Product(
            id = (products.lastOrNull()?.id ?: 0L).plus(1L),
            name = name
        )
        products.add(product)
        return product
    }

    override fun findAll(): List<Product> {
        return products
    }

    override fun findById(id: Long): Product {
        return products.find { it.id == id } ?: throw Exception()
    }

    override fun findByName(name: String): List<Product> {
        return products.filter { it.name == name }
    }

    override fun update(id: Long, product: Product): Product {
        val index = products.indexOfFirst { it.id == id }
        if (index < 0) throw Exception()
        products[index] = product
        return findById(id)
    }

    override fun delete(id: Long) {
        products.removeIf { it.id == id }
    }
}