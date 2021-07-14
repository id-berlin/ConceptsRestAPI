package com.id.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.id.model.Concept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.core.io.support.ResourcePatternUtils.getResourcePatternResolver;

@Component
public class ConceptStorage {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConceptStorage.class);

  private static final String CONCEPT_FILE = "/data/concept-without-children.json";

  private final ObjectMapper jsonMapper = new ObjectMapper();
  private final Map<String, Concept> concepts;

  public ConceptStorage() {
    concepts = readConceptRessources();
  }

  private Map<String, Concept> readConceptRessources() {
    try {
      final InputStream inputStream = getResourcePatternResolver(null).getResource(CONCEPT_FILE).getInputStream();

      final List<Concept> fileConcepts = jsonMapper.readValue(inputStream, new TypeReference<List<Concept>>() {});

      return fileConcepts.stream().collect(Collectors.toMap(Concept::getCode, fileConcept -> fileConcept));
    } catch (Exception exception) {
      LOGGER.warn("Could not read the concepts.", exception);
    }
    return new HashMap<>();
  }

  public Concept getConcept(String code) {
    return concepts.get(code);
  }

  public List<Concept> getAllConcepts() {
    // TODO:
    return new ArrayList<>();
  }

  public boolean addConcept(Concept concept) {
    concepts.put(concept.getCode(), concept);
    return writeConceptsToFile();
  }

  public void deleteConcept(String code) {
    if (concepts.remove(code) != null) {
      writeConceptsToFile();
    }
  }

  public boolean updateConcept() {
    // TODO:
    return false;
  }

  private boolean writeConceptsToFile() {
    try {
      jsonMapper.writerWithDefaultPrettyPrinter()
          .writeValue(getResourcePatternResolver(null).getResource(CONCEPT_FILE).getFile(), concepts.values());
      return true;
    } catch (Exception exception) {
      LOGGER.warn("Could not write the concepts.", exception);
    }
    return false;
  }

}
