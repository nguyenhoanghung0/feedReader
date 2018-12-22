package com.spring.feedreader.services;

import java.util.List;

import com.spring.feedreader.model.Feed;
import com.spring.feedreader.model.FeedMessage;
import com.spring.feedreader.read.RSSFeedParser;

public class FeedServicesImpl implements FeedServices {
		
	@Override
	public List<FeedMessage> getFeedListForDisplaying(Converter converter, String url) {
		
		List<FeedMessage> feedList = getFeedList(url);
		filterString(feedList, converter);
		
		return feedList;
	}
	
	private List<FeedMessage> getFeedList(String url) {
		
		RSSFeedParser feedParser = new RSSFeedParser(url);
        Feed feed = feedParser.readFeed();
        List<FeedMessage> feedList = feed.getMessages();
        
		return feedList;
	}
	
	private List<FeedMessage> filterString(List<FeedMessage> feedsToFilter, Converter converter) {
		
		converter.convert(feedsToFilter);
		
		return feedsToFilter;
	}	
}
