package org.example;


public class Event {
    private String name;
    private EventType type;
    private String group;

    public Event() {
        name = "test";
        type = EventType.Lab;
    }

    public Event(String name, EventType type, String group) {
        this.name = name;
        this.type = type;
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
    
}

