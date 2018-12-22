package com.spring.feedreader.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.feedreader.model.RssSource;
import com.spring.feedreader.services.ExcludeStringConverter;

@Controller
@RequestMapping("/configuration")
public class ConfigurationController {

	private static final Logger logger = LoggerFactory.getLogger(ConfigurationController.class);
	
	@Autowired
	@Qualifier("rssSource")
	RssSource rssSource;
	
	@Autowired
	@Qualifier("converter")
	ExcludeStringConverter converter;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView configuration() {
		
		ConfigurationForm form = new ConfigurationForm(rssSource.getUrl(), converter.getExcludingString());
						
		return new ModelAndView("configuration", "configurationForm", form);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String updateConfiguration(@ModelAttribute("configurationForm") ConfigurationForm form,			
			ModelAndView model) {
		
		this.rssSource.setUrl(form.getUrl());
		this.converter.setExcludingString(form.getExcludingString());
		return "redirect:/#configuration";
	}
}
