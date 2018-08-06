package com.condconv.vertical.products.api

import com.condconv.vertical.products.domain.Product
import com.condconv.vertical.products.domain.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/products")
class ProductController(
    private val productRepository: ProductRepository
) {

    @GetMapping
    fun index(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productRepository.findAll())
    }

    @GetMapping("/{id}")
    fun show(@PathVariable id: Long): ResponseEntity<Product> {
        return ResponseEntity.ok(productRepository.findById(id))
    }

    @PostMapping()
    fun create(@RequestBody request: CreateProductRequest): ResponseEntity<Product> {
        return ResponseEntity(productRepository.create(
            name = request.name
        ), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity.ok(productRepository.update(id, product))
    }

    @DeleteMapping("/{id}")
    fun destroy(@PathVariable id: Long): ResponseEntity<Void> {
        productRepository.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    data class CreateProductRequest(
        val name: String
    )
}

