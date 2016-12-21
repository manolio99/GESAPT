package com.miradorlacala.apt.beans;

import java.io.Serializable;

public class ControlAjaxTimeout implements Serializable {

	private static final long serialVersionUID = 5252983185170893823L;

	private long ajaxTimeout;

	public long getAjaxTimeout() {
		return ajaxTimeout;
	}

	public void setAjaxTimeout(long ajaxTimeout) {
		this.ajaxTimeout = ajaxTimeout;
	}
}
