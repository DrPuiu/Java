package com.example.demo1.BackEnd.Input;

import com.example.demo1.BackEnd.Model.Event;
import com.example.demo1.BackEnd.Model.EventType;
import com.example.demo1.BackEnd.Model.Room;
import com.example.demo1.BackEnd.Model.RoomType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static final String COMMA_DELIMITER = ",";

    public static List<Event> readCSV(String filePath) {
        List<Event> events = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] eventDetails = line.split(COMMA_DELIMITER);
                Event event = createEventFromCSV(eventDetails);
                events.add(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return events;
    }
    public static List<Room> readCSVRooms(String filePath){
        List<Room> rooms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] eventDetails = line.split(COMMA_DELIMITER);
                Room room = createRoomFromCSV(eventDetails);
                rooms.add(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rooms;
    }
    private static Room createRoomFromCSV(String[] roomDetails){
        String name = roomDetails[0];
        RoomType roomType = RoomType.valueOf(roomDetails[1]);
        int size = Integer.parseInt(roomDetails[2]);
        int floor = Integer.parseInt(roomDetails[3]);
        return new Room(name,roomType,size,floor);
    }
    private static Event createEventFromCSV(String[] eventDetails) {
        String name = eventDetails[0];
        EventType type = EventType.valueOf(eventDetails[1]);
        int start = Integer.parseInt(eventDetails[2]);
        int end = Integer.parseInt(eventDetails[3]);
        int weekday = Integer.parseInt(eventDetails[4]);
        String group = eventDetails[5];

        return new Event(name, type, start, end, weekday, group);
    }

    public static void main(String[] args) {
        List<  Event> events = readCSV("./Events.csv");
        List <Room> rooms = readCSVRooms("./Rooms.csv");
        System.out.println(events);
        System.out.println(rooms);
        // Use the events list as needed
    }
}
