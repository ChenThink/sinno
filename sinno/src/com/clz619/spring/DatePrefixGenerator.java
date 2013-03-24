/**
 * 
 */
package com.clz619.spring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ChenLizhong
 * @date 2013-3-21
 * @version v1.0
 * @description TODO
 */
public class DatePrefixGenerator implements PrefixGenerator {

	private DateFormat formatter;

	public void setPattern(String pattern) {
		this.formatter = new SimpleDateFormat(pattern);
	}

	@Override
	public String getPrefix() {
		if (formatter != null)
			return formatter.format(new Date());
		return null;
	}

}
