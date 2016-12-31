package com.miradorlacala.apt.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Utils {
	public static String getMessageResourceString(String key, Object params[]) {
		String message;
		ResourceBundle bundle = ResourceBundle.getBundle("messages");

		try {
			message = bundle.getString(key);
		} catch (MissingResourceException e) {
			message = "?? key " + key + " not found ??";
		}

		if (params != null) {
			MessageFormat mf = new MessageFormat(message);
			message = mf.format(params, new StringBuffer(), null).toString();
		}

		return message;
	}
}
