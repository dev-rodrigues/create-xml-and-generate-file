package com.devrodrigues.http.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class UserXML {

    @JacksonXmlProperty(isAttribute = true, localName = "NAME")
    private String name;

    @JacksonXmlElementWrapper(useWrapping = false, localName = "TELEPHONE")
    @JacksonXmlProperty(localName = "TELEPHONE")
    private List<TelephoneXML> telephones;

    public UserXML() {
    }

    public UserXML(String name, List<TelephoneXML> telephones) {
        this.name = name;
        this.telephones = telephones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TelephoneXML> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneXML> telephones) {
        this.telephones = telephones;
    }
}