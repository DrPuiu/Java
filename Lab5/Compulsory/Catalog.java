package org.example;

import java.util.List;
import java.util.ArrayList;

public class Catalog implements Serializable{
    private String name;
    private List<Document> documents = new ArrayList<>();
    public Catalog(){};

    public Catalog(String name)
    {
        this.name = name;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public String getName() {
        return name;
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    public var findById(String id) {
        for (var doc : documents) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name + " --> " + documents;
    }
}