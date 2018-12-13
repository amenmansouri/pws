package com.project.company.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.company.Entity.Line;
import com.project.company.Repository.LineRepository;

@RestController
@RequestMapping("lines")
public class LineController {
	@Autowired
	LineRepository lr;
	@GetMapping("/{dep}")
	@ResponseBody ResponseEntity<Iterable<Line>> findLineWithDepart(@PathVariable String dep){
		Iterable<Line> lines=lr.findByAerodepNom(dep);
		return new ResponseEntity<Iterable<Line>>(lines,HttpStatus.OK);
	} 
	@GetMapping("/{dep}/{arr}")
	@ResponseBody ResponseEntity<Iterable<Line>> findLineWithDepart(@PathVariable String dep,@PathVariable String arr){
		Iterable<Line> lines=lr.findByAerodepNomAndAeroarrNom(dep,arr);
		return new ResponseEntity<Iterable<Line>>(lines,HttpStatus.OK);
	} 

}
