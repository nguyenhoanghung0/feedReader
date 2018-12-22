package com.spring.feedreader.services;

import java.util.List;

import com.spring.feedreader.model.FeedMessage;

public interface FeedServices {
	
	public List<FeedMessage> getFeedListForDisplaying(Converter converter, String url);
		
}
