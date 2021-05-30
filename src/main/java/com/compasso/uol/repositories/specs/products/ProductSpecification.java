package com.compasso.uol.repositories.specs.products;

import com.compasso.uol.models.dto.ProductDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodrigo da Cruz
 * @version 1.0
 * @since 2021-05-27
 *
 */
@Repository
public class ProductSpecification {

	public static Specification<ProductDTO> params(String q, Double min_price, Double max_price){

		if(!q.isEmpty() && min_price != null && max_price != null) {
			return (root, query, builder)->builder.and(builder.like(builder.upper(
					builder.concat(root.get("name"), root.get("description"))), "%" + q.toUpperCase() + "%"),
					builder.between(root.get("price"), min_price, max_price ));
		}
		else if(!q.isEmpty() && min_price != null && max_price == null) {
			return (root, query, builder)->builder.and(builder.like(builder.upper(
					builder.concat(root.get("name"), root.get("description"))), "%" + q.toUpperCase() + "%"),
					builder.greaterThanOrEqualTo(root.get("price"), min_price));
		}
		else if(!q.isEmpty() && min_price == null && max_price != null) {
			return (root, query, builder)->builder.and(builder.like(builder.upper(
					builder.concat(root.get("name"), root.get("description"))), "%" + q.toUpperCase() + "%"),
					builder.lessThanOrEqualTo(root.get("price"), max_price ));
		}
		else if(!q.isEmpty() && min_price == null && max_price == null) {
			return (root, query, builder)->builder.like(builder.upper(
					builder.concat(root.get("name"), root.get("description"))), "%" + q.toUpperCase() + "%");
		}
		else if(q.isEmpty() && min_price != null && max_price != null) {
			return (root, query, builder)->builder.between(root.get("price"), min_price, max_price );
		}
		else if(q.isEmpty() && min_price != null && max_price == null) {
			return (root, query, builder)->builder.greaterThanOrEqualTo(root.get("price"), min_price);
		}
		else if(q.isEmpty() && min_price == null && max_price != null) {
			return (root, query, builder)->builder.lessThanOrEqualTo(root.get("price"), max_price );
		}
		else {
			return null;
		}
	}
}