package com.project.company.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.company.Entity.Voyager;
import com.project.company.Repository.VoyagerRepository;
@RestController
@RequestMapping(path="/voyager")
public class VoyagerController {
	@Autowired
	VoyagerRepository vr;
	@PostMapping("add")
	@ResponseBody ResponseEntity<Voyager> addvoyager(@RequestBody Voyager v){
					vr.save(v);
					return new ResponseEntity<Voyager>(v,HttpStatus.CREATED);
	}

}
