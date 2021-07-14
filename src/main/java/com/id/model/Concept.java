package com.id.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Concept {

  private String code;
  private String display;
  private String definition;
  @JsonProperty("designation")
  private List<Designation> designations;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDisplay() {
    return display;
  }

  public void setDisplay(String display) {
    this.display = display;
  }

  public String getDefinition() {
    return definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public List<Designation> getDesignations() {
    return designations;
  }

  public void setDesignations(List<Designation> designations) {
    this.designations = designations;
  }
}
