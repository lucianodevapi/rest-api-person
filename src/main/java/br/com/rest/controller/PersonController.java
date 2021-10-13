package br.com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.model.vo.PersonVO;
import br.com.rest.services.PersonService;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	PersonService services;

	@PostMapping(produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml"})
	public PersonVO create(@RequestBody PersonVO person) {
		return services.create(person);
	}

	@PutMapping(produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml"})
	public PersonVO update(@RequestBody PersonVO person) {
		return services.update(person);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping(produces = {"application/json", "application/xml"})
	public List<PersonVO> findAll() {
		return services.findAll();
	}

	@GetMapping(value ="/{id}", produces = {"application/json", "application/xml"})
	public PersonVO findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}
}
