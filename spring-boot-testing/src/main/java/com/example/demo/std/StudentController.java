package com.example.demo.std;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentService stdService;
	
	@PostMapping("/saveStd")
	public StudentDto save(@Valid @RequestBody StudentDto std){
		return stdService.save(std);
	}
	
	@PostMapping("/updateStd")
	public StudentDto update(@Valid @RequestBody StudentDto std){
		return stdService.update(std);
	}
	
	
	@GetMapping(value={"/students","/students/{sid}"})
	public List<?> getList(@PathVariable("sid") Optional<Long> sid){
			return stdService.getList(sid);
	}
	
}
