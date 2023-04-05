package org.example;

import java.util.Map;
import java.util.HashMap;

public class Document implements Serializable{
    private String id;
    private String title;
    private String location; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    public Document(){};

    public Document(String id, String title, String location)
    {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Catalogul are documentele cu id-ul: " + id + " titlul " + title + " si path-ul " + location;
    }
}