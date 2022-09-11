package com.devrodrigues.http;

import com.devrodrigues.repository.FilePort;
import com.devrodrigues.service.XmlService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;

import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import static org.springframework.http.MediaType.TEXT_PLAIN;

@RestController
@RequestMapping("/xml")
public class XmlTestController {

    private final XmlService service;
    private final FilePort port;

    public XmlTestController(XmlService service, FilePort port) {
        this.service = service;
        this.port = port;
    }

    @GetMapping("/")
    public ResponseEntity<Resource> teste() throws IOException {
        var xml = service.teste();
        var fileName = "teste.xml";

        var exportedPath = port.export(xml, fileName);

        URI exportedFileUri = exportedPath.toUri();
        Resource resource = new UrlResource(exportedFileUri);

        return ResponseEntity.ok()
                .header(CONTENT_DISPOSITION, "attachment;filename=" + fileName)
                .contentType(TEXT_PLAIN)
                .contentLength(resource.contentLength())
                .body(resource);
    }
}
