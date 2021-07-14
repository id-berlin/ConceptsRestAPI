package com.id.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum Language {

  DE("de", "German"),
  EN("en", "English"),
  FR("fr", "French"),
  IT("it", "Italian"),
  JA("ja", "Japanese"),
  KO("ko", "Korean"),
  NL("nl", "Dutch"),
  NO("no", "Norwegian"),
  PL("pl", "Polish"),
  PT("pt", "Portuguese"),
  RU("ru", "Russian"),
  SR("sr", "Serbian"),
  SV("sv", "Swedish"),
  TE("te", "Telegu"),
  ZH("zh", "Chinese");

  private final String shortName;
  private final String longName;

  Language(String shortName, String longName) {
    this.shortName = shortName;
    this.longName = longName;
  }

  @JsonValue
  public String getShortName() {
    return shortName;
  }

  public String getLongName() {
    return longName;
  }
}
