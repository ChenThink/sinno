/**
 * 
 */
package com.clz619.spring;

/**
 * @author ChenLizhong
 * @date 2013-3-21
 * @version v1.0
 * @description TODO
 */
public class Disc extends Product {
	private int capacity;

	public Disc() {
		super();
	}

	public Disc(String name, double price) {
		super(name, price);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
