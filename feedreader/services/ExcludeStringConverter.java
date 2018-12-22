package com.spring.feedreader.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.feedreader.model.FeedMessage;

public class ExcludeStringConverter implements Converter {

	private static final Logger logger = LoggerFactory.getLogger(ExcludeStringConverter.class);
	
	private String excludingString;
			
	public String getExcludingString() {
		return excludingString;
	}

	public void setExcludingString(String excludingString) {
		this.excludingString = excludingString;
	}

	@Override
	public void convert(List<FeedMessage> input) {
		
		logger.info("String to be excluded: " + excludingString);
		
		for (FeedMessage entry : input) {
			excludeStringFromFeedMessage(entry);
		}
		
	}
	
	private FeedMessage excludeStringFromFeedMessage(FeedMessage feedMessage) {
		
		feedMessage.setTitle(excludeString(feedMessage.getTitle()));
		
		return feedMessage;
	}
	
	private String excludeString(String feedProperty) {
		
		if (feedProperty.contains(excludingString)) {
			return feedProperty.replace(excludingString, "");
		}
		
		return feedProperty;
	}
		
}
