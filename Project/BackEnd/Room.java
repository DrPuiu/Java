package org.example;

public class Room {
    private String name;
    private RoomType type;
    private int size;

    public Room() {
        name = "test";
        type = RoomType.Classroom;
    }

    public Room(String name, RoomType type, int size) {
        this.name = name;
        this.type = type;
        this.size = size;
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

    @Override
    public String toString() {
        return name;
    }
}