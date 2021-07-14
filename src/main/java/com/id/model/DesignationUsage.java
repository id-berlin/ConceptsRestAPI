package com.id.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DesignationUsage {

  PREFERRED_TERM("900000000000003001", "Fully specified name"),
  SYNONYM("900000000000013009", "Synonym");

  private final String code;
  private final String display;

  DesignationUsage(String code, String display) {
    this.code = code;
    this.display = display;
  }

  public String getCode() {
    return this.code;
  }

  public String getDisplay() {
    return this.display;
  }

  @JsonCreator
  public static DesignationUsage findCorrectValue(@JsonProperty("code") String code, @JsonProperty("display") String display) {
    for (DesignationUsage designationUsage : DesignationUsage.values()) {
      if (designationUsage.getCode().equalsIgnoreCase(code) && designationUsage.getDisplay().equalsIgnoreCase(display)) {
        return designationUsage;
      }
    }
    return null;
  }
}
