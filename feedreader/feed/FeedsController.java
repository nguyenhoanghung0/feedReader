package com.spring.feedreader.feed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.feedreader.model.FeedMessage;
import com.spring.feedreader.model.RssSource;
import com.spring.feedreader.services.Converter;
import com.spring.feedreader.services.FeedServices;

@Controller
@RequestMapping("/feeds")
public class FeedsController {
	
	@Autowired
	@Qualifier("feedServiceImpl")
	FeedServices feedService;
	
	@Autowired
	@Qualifier("converter")
	Converter converter;
	
	@Autowired
	@Qualifier("rssSource")
	RssSource rssSource;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView feeds() {
		
		List<FeedMessage> feedList = feedService.getFeedListForDisplaying(converter, rssSource.getUrl());
		
		ModelAndView model = new ModelAndView("feeds");
		model.addObject("lists", feedList);
		
		return model;
	}
	
}
