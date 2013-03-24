/**
 * 
 */
package com.clz619.spring;

import java.util.Map;

/**
 * @author ChenLizhong
 * @date 2013-3-22
 * @version v1.0
 * @description TODO
 */
public class ProductCreator {
	private Map<String, Product> products;

	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}

	public Product createProduct(String productId) {
		Product product = products.get(productId);
		if (product != null) {
			return product;
		}
		throw new IllegalArgumentException("unknow product!");
	}
}
