package com.spring.feedreader.model;

public class RssSource {
	
	private String url;

	public RssSource(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
}
