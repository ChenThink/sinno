package com.clz619.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clz619.spring.Product;
import com.clz619.spring.SequenceGenerator;
import com.clz619.spring.ShoppingCart;

public class Main {
	private static final ApplicationContext context = new ClassPathXmlApplicationContext(
			"bean.xml");

	public static void main(String[] args) {
		Product aaa = (Product) context.getBean("aaa");
		Product aaa1 = (Product) context.getBean("aaa1");
		Product aaadiscount = (Product) context.getBean("aaadiscount");
		Product cdrw = (Product) context.getBean("cdrw");

		SequenceGenerator sequence = (SequenceGenerator) context
				.getBean("sequenceGenerator");
		SequenceGenerator sequence1 = (SequenceGenerator) context
				.getBean("sequenceGenerator1");
		SequenceGenerator sequence2 = (SequenceGenerator) context
				.getBean("sequenceGenerator2");
		SequenceGenerator sequence3 = (SequenceGenerator) context
				.getBean("sequenceGenerator3");
		SequenceGenerator sequence4 = (SequenceGenerator) context
				.getBean("sequenceGenerator4");
		SequenceGenerator sequence5 = (SequenceGenerator) context
				.getBean("sequenceGenerator5");

		System.out.println(aaa);
		System.out.println(aaa1);
		System.out.println(aaadiscount);
		System.out.println(cdrw);
		System.out.println(sequence.getSequence());
		System.out.println(sequence1.getSequence());
		System.out.println(sequence2.getSequence());
		System.out.println(sequence3.getSequence());
		System.out.println(sequence4.getSequence());
		System.out.println(sequence5.getSequence());

		ShopCart();
	}

	public static void ShopCart() {
		Product aaa = (Product) context.getBean("aaa");
		Product cdrw = (Product) context.getBean("cdrw");
		Product dvdrw = (Product) context.getBean("dvdrw");

		ShoppingCart cart1 = (ShoppingCart) context.getBean("shoppingCart");
		cart1.addItem(aaa);
		cart1.addItem(cdrw);
		System.out.println("Shopping cart 1 contains " + cart1.getItems());
		ShoppingCart cart2 = (ShoppingCart) context.getBean("shoppingCart");
		cart2.addItem(dvdrw);
		System.out.println("Shopping cart 2 contains " + cart2.getItems());
	}
}
