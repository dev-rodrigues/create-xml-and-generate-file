package com.devrodrigues.config;

import org.xml.sax.InputSource;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TransformXML {

    private final Transformer transformer;

    public TransformXML(Transformer transformer) {
        this.transformer = transformer;
    }

    public String pretty(String xml) {
        try{
            Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
            StreamResult res = new StreamResult(new ByteArrayOutputStream());
            transformer.transform(xmlSource, res);
            return ((ByteArrayOutputStream) res.getOutputStream()).toString();
        } catch(Exception e){
            return xml;
        }
    }
}
