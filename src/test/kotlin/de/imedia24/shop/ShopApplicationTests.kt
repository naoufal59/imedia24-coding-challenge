package de.imedia24.shop

import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus

import de.imedia24.shop.controller.ProductController
import de.imedia24.shop.domain.product.PartialProductRequest
import de.imedia24.shop.domain.product.ProductResponse
import de.imedia24.shop.service.ProductService
import java.math.BigDecimal


@SpringBootTest
class ShopApplicationTests {
	private val productServiceMock = mock(ProductService::class.java)
	private val productController = ProductController(productServiceMock)

	@Test
	fun contextLoads() {
	}

	@Test
	fun `test findProductBySku with existing product`() {
		val sku = "123"
		val productResponse = ProductResponse(sku, "Test Product", "Description", BigDecimal.valueOf(19.99), 5)

		`when`(productServiceMock.findProductBySku(sku)).thenReturn(productResponse)

		val result = productController.findProductBySku(sku)

		assert(result.statusCode == HttpStatus.OK)
		assert(result.body == productResponse)
	}

	@Test
	fun `test findProductBySku with non-existing product`() {
		val sku = "456"

		`when`(productServiceMock.findProductBySku(sku)).thenReturn(null)

		val result = productController.findProductBySku(sku)

		assert(result.statusCode == HttpStatus.NOT_FOUND)
	}

	@Test
	fun `test partiallyUpdateProduct with existing product`() {
		val sku = "123"
		val partialProductRequest = PartialProductRequest("Updated Name", "Updated Description", BigDecimal.valueOf(29.99))
		val updatedProductResponse = ProductResponse(sku, "Updated Name", "Updated Description", BigDecimal.valueOf(29.99),5)

		`when`(productServiceMock.partiallyUpdateProduct(sku, partialProductRequest)).thenReturn(updatedProductResponse)

		val result = productController.partiallyUpdateProduct(sku, partialProductRequest)

		assert(result.statusCode == HttpStatus.OK)
		assert(result.body == updatedProductResponse)
	}

	@Test
	fun `test partiallyUpdateProduct with non-existing product`() {
		val sku = "456"
		val partialProductRequest = PartialProductRequest("Updated Name", "Updated Description", BigDecimal.valueOf(29.99))

		`when`(productServiceMock.partiallyUpdateProduct(sku, partialProductRequest)).thenReturn(null)

		val result = productController.partiallyUpdateProduct(sku, partialProductRequest)

		assert(result.statusCode == HttpStatus.NOT_FOUND)
	}
}
