package com.id.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Designation {

  private Language language;
  private DesignationUsage use;
  private String value;


  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public DesignationUsage getUse() {
    return use;
  }

  public void setUse(DesignationUsage use) {
    this.use = use;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
