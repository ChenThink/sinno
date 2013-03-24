/**
 * 
 */
package com.clz619.spring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenLizhong
 * @date 2013-3-22
 * @version v1.0
 * @description TODO
 */
public class ShoppingCart {
	private List<Product> items = new ArrayList<Product>();

	public void addItem(Product item) {
		items.add(item);
	}

	public List<Product> getItems() {
		return items;
	}

}
