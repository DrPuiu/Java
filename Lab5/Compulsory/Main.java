package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String args[]) {
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            app.testLoadView();
        } catch (InvalidCatalogException e) {
            throw new RuntimeException(e);
        }
    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("MyDocuments");

        var documentOne = new Document("1", "titleOne", "C:\\Users\\puiua\\IdeaProjects\\Lab_05");
        var documentTwo = new Document("2","titleTwo", "C:\\Users\\puiua\\IdeaProjects\\Lab_05");
        catalog.add(documentOne);
        catalog.add(documentTwo);

        CatalogUtil.save(catalog, "C:\\Users\\puiua\\IdeaProjects\\Lab_05\\catalog.json");
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = null;
        try {
            catalog = CatalogUtil.load("C:\\Users\\puiua\\IdeaProjects\\Lab_05\\catalog.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CatalogUtil.view(catalog.findById("1"));
        CatalogUtil.view(catalog.findById("2"));
    }

}