package com.devrodrigues.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;


@Configuration
public class TransformConfig {

    @Bean
    public Transformer transformer() throws TransformerConfigurationException {
        Transformer serializer = TransformerFactory.newInstance().newTransformer();
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        return serializer;
    }

    @Bean
    public TransformXML transformXML(Transformer transformer) {
        return new TransformXML(transformer);
    }
}
