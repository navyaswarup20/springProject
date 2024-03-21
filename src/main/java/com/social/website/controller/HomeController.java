package com.social.website.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String homeControllerHandler() {
		return "Hye! Welocome to Main Page";
	}

	@GetMapping("/home")
	public String homeController1() {
		return "Hye! This is second Controller";
	}
	@GetMapping("/home1")
	public String homeController2() {
		return "Hye! This is third Controller";
	}
}
