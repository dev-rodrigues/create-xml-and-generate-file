package com.devrodrigues.http.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "ROOT")
public class RootXML {

    @JacksonXmlProperty(isAttribute = true, localName = "XML-ATRIBUTE")
    public String xmlAtribute;

    public String xmlElement;

    @JacksonXmlElementWrapper(localName = "USERS")
    @JacksonXmlProperty(localName = "USER")
    public List<UserXML> userXMLS;

    public String getXmlAtribute() {
        return xmlAtribute;
    }

    public void setXmlAtribute(String xmlAtribute) {
        this.xmlAtribute = xmlAtribute;
    }

    public String getXmlElement() {
        return xmlElement;
    }

    public void setXmlElement(String xmlElement) {
        this.xmlElement = xmlElement;
    }

    public List<UserXML> getUserXMLS() {
        return userXMLS;
    }

    public void setUserXMLS(List<UserXML> userXMLS) {
        this.userXMLS = userXMLS;
    }
}
