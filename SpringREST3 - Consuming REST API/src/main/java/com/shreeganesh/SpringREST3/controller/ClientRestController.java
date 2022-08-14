package com.shreeganesh.SpringREST3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shreeganesh.SpringREST3.api.Studdentdto;


@RestController
public class ClientRestController {


	private String url = "http://springtest-env.eba-zapbyiiy.ap-south-1.elasticbeanstalk.com/students";
	@Autowired
	RestTemplate resttemplate;
	
	
	
	@GetMapping("/fetchstudents")
	String fetchstudents() {
		Studdentdto[] forObject = resttemplate.getForObject(url, Studdentdto[].class);
		for(Studdentdto s : forObject) {
		System.out.println(s);}
		return "testing get";
	}
}
