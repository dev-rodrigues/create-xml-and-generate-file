package com.devrodrigues.service;

import com.devrodrigues.config.TransformXML;
import com.devrodrigues.http.dto.RootXML;
import com.devrodrigues.http.dto.TelephoneXML;
import com.devrodrigues.http.dto.UserXML;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XmlService {

    private final XmlMapper mapper;
    private final TransformXML transformXML;

    public XmlService(XmlMapper mapper, TransformXML transformXML) {
        this.mapper = mapper;
        this.transformXML = transformXML;
    }

    public String teste() throws JsonProcessingException {
        var xml = new RootXML();

        xml.xmlAtribute = "atribute";
        xml.xmlElement = "element";
        xml.userXMLS = List.of(
                new UserXML(
                        "carlos",
                        List.of(new TelephoneXML("21", "998761567")))
                , new UserXML(
                        "aline",
                        List.of(
                                new TelephoneXML("21", "24249034"),
                                new TelephoneXML("21", "24249033"),
                                new TelephoneXML("21", "24249033")
                        ))
        );

        return transformXML.pretty(mapper.writeValueAsString(xml));
    }
}
