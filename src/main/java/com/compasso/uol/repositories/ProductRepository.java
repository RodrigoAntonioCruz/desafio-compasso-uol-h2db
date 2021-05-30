package com.compasso.uol.repositories;

import com.compasso.uol.models.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.compasso.uol.models.Product;

/**
 *
 * @author Rodrigo da Cruz
 * @version 1.0
 * @since 2021-02-25
 * 
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<ProductDTO> {
}
