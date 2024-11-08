

package com.apirest.demo.service;


import com.apirest.demo.model.Autor;
import com.apirest.demo.model.Libro;
import com.apirest.demo.repository.AutorRepository;
import com.apirest.demo.repository.LibroRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public ByteArrayInputStream exportResumen() throws IOException {
        List<Libro> libros = libroRepository.findAll();
        List<Autor> autores = autorRepository.findAll();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Resumen");

            // Crear encabezados
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Total de Libros");
            headerRow.createCell(1).setCellValue("Total de Autores");
            headerRow.createCell(2).setCellValue("Autor");
            headerRow.createCell(3).setCellValue("Total de Libros por Autor");

            // Crear datos
            Row dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue(libros.size());
            dataRow.createCell(1).setCellValue(autores.size());

            int rowNum = 2;
            for (Autor autor : autores) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(2).setCellValue(autor.getNombre());
                row.createCell(3).setCellValue(autor.getLibros().size());
            }

            // Escribir el archivo en un ByteArrayOutputStream
            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                workbook.write(out);
                return new ByteArrayInputStream(out.toByteArray());
            }
        }
    }
}
