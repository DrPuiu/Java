package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.print.Doc;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.*;

public class CatalogUtil {

    ObjectMapper mapper = new ObjectMapper();

    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }
    public static Catalog load(String path) throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        return catalog;
    }

    public static void view(Document doc) {
        System.out.println(doc);
    }
}