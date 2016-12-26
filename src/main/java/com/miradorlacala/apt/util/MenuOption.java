package com.miradorlacala.apt.util;

public enum MenuOption {
	PRICES("prices.xhtml"),
	NEW_RENTAL("newRental.xhtml"),
	SEARCH_RENTAL("searchRental.xhtml"),
	NEW_TENANT("newTenant.xhtml"),
	SEARCH_TENANT("searchTenant.xhtml"),
	STATS("stats.xhtml");

    private String url;

    MenuOption(String url) {
    	this.url = url;
    }
    
    public String url() {
        return url;
    }
}
