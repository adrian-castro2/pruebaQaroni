package com.apirest.demo.controller;

import com.apirest.demo.service.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;


@RestController
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private ExcelExportService excelExportService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/resumen")
    public ResponseEntity<byte[]> exportResumen() throws IOException {
        ByteArrayInputStream in = excelExportService.exportResumen();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=resumen.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(in.readAllBytes());
    }
}