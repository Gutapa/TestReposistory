package com.shreeganesh.SpringREST2.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shreeganesh.SpringREST2.exception.StudentException;

@RestController
public class RestControllera {

	@GetMapping("/test")
	String getmethod() throws StudentException {
		return "Get Mapping";
	}

	@PostMapping("/test")
	String postmethod() {
		return "POst Mapping";
	}

	@PutMapping("/test")
	String putmethod() {
		return "Put Mapping";
	}

	@PatchMapping("/test")
	String patchmethod() {
		return "Patch Mapping";
	}

	@DeleteMapping("/test")
	String deletemethod() {
		return "Delete Mapping";
	}

}
