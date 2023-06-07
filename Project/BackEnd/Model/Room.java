package com.example.demo1.BackEnd.Model;

public class Room {
    private String name;
    private RoomType type;
    private int size;
    private int floor;

    public Room() {
        name = "test";
        type = RoomType.CLASSROOM;
    }

    public Room(String name, RoomType type, int size, int floor) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return name;
    }
}
