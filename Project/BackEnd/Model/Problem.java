package com.example.demo1.BackEnd.Model;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    private  List<Event> events;
    private  List<Room> rooms;

    public Problem() {
        events = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public void addRoom(Room room){
        rooms.add(room);
    }


    @Override
    public String toString() {
        return "Backend.Problem{" +
                "\nevents=" + events +
                ", \nrooms=" + rooms +
                '}';
    }

}
