package com.miradorlacala.apt.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class JsfUtils {
	public static String getMessageResourceString(String key) {
		return getMessageResourceString(key, null);
	}
	
	public static String getMessageResourceString(String key, Object params[]) {
		String message;
		ResourceBundle bundle = ResourceBundle.getBundle("messages");

		try {
			message = bundle.getString(key);
			if (params != null) {
				MessageFormat mf = new MessageFormat(message);
				message = mf.format(params, new StringBuffer(), null).toString();
			}
		} catch (MissingResourceException e) {
			message = null;
		}

		return message;
	}
}
