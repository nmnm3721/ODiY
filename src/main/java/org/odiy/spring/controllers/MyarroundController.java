package org.odiy.spring.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyarroundController {

	@RequestMapping(value = "/mainpage/myArround.do", method = RequestMethod.GET)
	public String myArround(Locale locale, Model model) {

		return "mainpage/my_arround";
	}
	
}
