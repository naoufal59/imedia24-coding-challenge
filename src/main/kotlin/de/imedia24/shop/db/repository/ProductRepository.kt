package de.imedia24.shop.db.repository

import de.imedia24.shop.db.entity.ProductEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<ProductEntity, String> {

    fun findBySku(sku: String): ProductEntity?

    @Query("SELECT p FROM ProductEntity p LEFT JOIN FETCH p.stockQuantity WHERE p.sku = :sku", nativeQuery = true)
    fun findBySkuWithStock(@Param("sku") sku: String): ProductEntity?
}