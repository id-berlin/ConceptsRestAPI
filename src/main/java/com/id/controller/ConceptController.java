package com.id.controller;

import com.id.model.Concept;
import com.id.storage.ConceptStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fhir/concept")
public class ConceptController {

  @Autowired
  private ConceptStorage storage;

  @GetMapping
  public List<Concept> get() {
    return storage.getAllConcepts();
  }

  @GetMapping(value = "/{code}")
  public Concept get(@PathVariable("code") String code) {
    return storage.getConcept(code);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public String create(@RequestBody Concept concept) {
    if (storage.addConcept(concept)) {
      return concept.getCode();
    }
    return null;
  }

  @DeleteMapping(value = "/{code}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("code") String code) {
    storage.deleteConcept(code);
  }

}
