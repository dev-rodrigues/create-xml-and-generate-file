package com.devrodrigues.http.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "TELEPHONE")
public class TelephoneXML {

    @JacksonXmlProperty(isAttribute = true, localName = "DD")
    private String ddd;

    @JacksonXmlProperty(isAttribute = true, localName = "NUMBER")
    private String number;

    public TelephoneXML() {
    }

    public TelephoneXML(String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
