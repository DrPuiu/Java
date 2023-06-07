package com.example.demo1.BackEnd.Model;

public class Event implements Comparable<Event> {
    private String name;
    private EventType type;
    private int start;
    private int end;
    private int weekday;
    private String group;

    public Event() {
        name = "test";
        type = EventType.LABORATORY;
    }

    public Event(String name, EventType type, int start, int end, int weekday, String group) {
        this.name = name;
        this.type = type;
        this.start = start;
        this.end = end;
        this.weekday = weekday;
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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }


    @Override
    public String toString() {
        return weekday + " " + start + "-" + end + " " + name;
    }


    @Override
    public int compareTo(Event event) {
        if (weekday == event.getWeekday()) {
            if (start == event.getStart()){
                if (name.compareTo(event.getName()) == 0){
                    return group.compareTo(event.getGroup());
                }
                else return name.compareTo(event.getName());
            }
            else if (start < event.getStart())
                return -1;
            else return 1;
        } else if (weekday < event.getWeekday())
            return -1;
        else return 1;

//        return name.compareTo(event.getName());
    }
}


