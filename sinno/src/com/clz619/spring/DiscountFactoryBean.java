/**
 * 
 */
package com.clz619.spring;

import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @author ChenLizhong
 * @date 2013-3-22
 * @version v1.0
 * @description 自定义的折扣类。 它接受一个product属性和一个discount属性，将折扣应用到产品上并且作为一个新的Bean返回。
 *              通过扩展AbstractFactoryBean类
 *              ，DiscountFactoryBean能够重载createInstance()方法以创建目标Bean实例。
 *              此外，必须在getObjectType()中返回目标Bean的类型，使自动封装Auto-wiring功能正常工作。
 * 
 *              类似修饰模式
 */
public class DiscountFactoryBean extends AbstractFactoryBean<Product> {

	private Product product;
	private double discount;

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	protected Product createInstance() throws Exception {
		product.setPrice(product.getPrice() * (1 - discount));
		return product;
	}

	@Override
	public Class<Product> getObjectType() {
		return Product.class;
	}

}
