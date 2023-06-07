package com.example.demo1.BackEnd.Model;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    Map<Event, Room> solution;

    public Solution() {
        solution = new TreeMap<>();
    }

    public void addPair(Event event, Room room) {solution.put(event, room);}

    public Room getRoom(Event event) {
        return solution.get(event);
    }

    @Override
    public String toString() {
        return "solution:" + solution;
    }

}
