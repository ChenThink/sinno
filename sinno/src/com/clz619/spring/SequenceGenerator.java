package com.clz619.spring;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SequenceGenerator {
	private String prefix;
	private String suffix;
	private int initial;
	private int counter;
	private PrefixGenerator prefixGenerator;
	private List<Object> list;

	public SequenceGenerator() {
	}

	public SequenceGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}

	/* Spring 注入bean constructor-arg choice (String or int)? */
	/*
	 * <bean id="sequenceGenerator1"
	 * class="com.clz619.spring.SequenceGenerator"> <constructor-arg value="30"
	 * /> <constructor-arg value="10000" /> <property name="suffix" value="A" />
	 * </bean>
	 * 
	 * 300A 301A
	 * 
	 * 这个备案注入调用了第一个带有prefix和suffix参数的构造程序，而不是initial。这是因为Spring默认将两个参数都解析为String类型
	 * ，第一个构造程序不需要类型转换，所以被认定为最适合的。为了指定参数的预期类型，必须设置<constructor-arg>中的type属性
	 */
	public SequenceGenerator(String prefix, String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public SequenceGenerator(int initial, String suffix) {
		this.suffix = suffix;
		this.initial = initial;
	}

	public SequenceGenerator(String prefix, int initial) {
		this.prefix = prefix;
		this.initial = initial;
	}

	public SequenceGenerator(String prefix, String suffix, int initial) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.initial = initial;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	@Autowired
	@Qualifier("datePrefixGenerator1")
	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public synchronized String getSequence() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(prefix);
		if (prefixGenerator != null) {
			buffer.append(prefixGenerator.getPrefix());
		}
		if (list != null) {
			DecimalFormat format = new DecimalFormat("0000");
			for (Object l : list) {
				buffer.append("-");
				buffer.append(format.format((Integer) l));
			}
		}
		buffer.append(initial + counter++);
		buffer.append(suffix);
		return buffer.toString();
	}
}
