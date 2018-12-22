package com.spring.feedreader.services;

import java.util.List;

import com.spring.feedreader.model.FeedMessage;

public interface Converter {
	
	public void convert(List<FeedMessage> input);
	
}
