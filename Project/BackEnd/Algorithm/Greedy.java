package com.example.demo1.BackEnd.Algorithms;

import com.example.demo1.BackEnd.Model.Event;
import com.example.demo1.BackEnd.Model.Problem;
import com.example.demo1.BackEnd.Model.Room;
import com.example.demo1.BackEnd.Model.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Greedy {
    private final Problem problem;
    private final Solution solution;
    private final List<Event> lectures;
    private final List<Event> labs;
    private final List<Event> seminars;
    private final List<Room> lectureHalls;
    private final List<Room> computerLabs;
    private final List<Room> classRooms;

    public Solution getSolution() {
        return solution;
    }

    public Greedy(Problem problem) {
        this.problem = problem;
        solution = new Solution();
        lectures = new ArrayList<>();
        labs = new ArrayList<>();
        seminars = new ArrayList<>();
        lectureHalls = new ArrayList<>();
        computerLabs = new ArrayList<>();
        classRooms = new ArrayList<>();
        computeSolution();
    }

    //Separam event-urile si room-urile in liste diferite, apoi cream liste de adiacente pentru lectures, labs si seminare
    private void computeSolution() {
        separateEvents();
        separateRooms();

        Map<Event, List<Event>> lecturesAdjacencyList = createAdjacencyList(lectures);
        Map<Event, List<Event>> labsAdjacencyList = createAdjacencyList(labs);
        Map<Event, List<Event>> seminarsAdjacencyList = createAdjacencyList(seminars);

        if(!lectures.isEmpty() && !lectureHalls.isEmpty()) colorGraph(lecturesAdjacencyList, lectures, lectureHalls);
        if(!labs.isEmpty() && !computerLabs.isEmpty()) colorGraph(labsAdjacencyList, labs, computerLabs);
        if(!seminars.isEmpty() && !classRooms.isEmpty()) colorGraph(seminarsAdjacencyList, seminars, classRooms);
    }

    private void separateEvents() {
        List<Event> events = problem.getEvents();
        for (Event event : events) {
            switch (event.getType()) {
                case LECTURE -> lectures.add(event);
                case LABORATORY -> labs.add(event);
                case SEMINAR -> seminars.add(event);
                default -> {
                }
            }
        }
    }

    private void separateRooms() {
        List<Room> rooms = problem.getRooms();
        for (Room room : rooms) {
            switch (room.getType()) {
                case LECTURE_HALL -> lectureHalls.add(room);
                case COMPUTER_LAB -> computerLabs.add(room);
                case CLASSROOM -> classRooms.add(room);
                default -> {}
            }
        }
    }

    //Initializam un map gol adjacencyList si adaugam ca si cheie fiecare event si o lista goala ca si valoare
    private Map<Event, List<Event>> createAdjacencyList(List<Event> events) {
        Map<Event, List<Event>> adjacencyList = new HashMap<>();

        for (Event event : events) {
            adjacencyList.put(event, new ArrayList<>());
        }

        for (int i = 0; i < events.size() - 1; ++i) {
            for (int j = i + 1; j < events.size(); ++j) {
                Event event1 = events.get(i);
                Event event2 = events.get(j);
                //verificam daca event1 se intersecteaza cu event2 si in caz afirmativ adaugam event2 la lista de ad pt event 1 si viceversa
                if (intersect(event1,event2)) {
                    adjacencyList.get(event1).add(event2);
                    adjacencyList.get(event2).add(event1);
                }
            }
        }
        return adjacencyList;
    }

    private boolean intersect(Event event1, Event event2) {
        if (event1.getWeekday()!= event2.getWeekday()) return false;
        boolean b1 = event1.getStart() > event2.getStart() && event1.getStart() < event2.getEnd();
        boolean b2 = event1.getEnd() > event2.getStart() && event1.getEnd() < event2.getEnd();
        boolean b3 = event1.getStart() == event2.getStart() || event1.getEnd() == event2.getEnd();
        return b1 || b2 || b3;
    }

    private void colorGraph(Map<Event, List<Event>> adjacencyList, List<Event> events, List<Room> rooms){

        solution.addPair(events.get(0), rooms.get(0));

        for(int i =1; i<events.size(); ++i){
            Event event1 = events.get(i);

            List<Room> availableRooms = new ArrayList<>(List.copyOf(rooms));
            for(Event event2:events){
                Room event2room = solution.getRoom(event2);
                if (adjacencyList.get(event1).contains(event2) && event2room != null)
                    availableRooms.remove(event2room);
            }

            if (availableRooms.size() == 0)
                System.out.println("ERROR: not enough rooms for current event!");
            else
                solution.addPair(event1, availableRooms.get(0));

        }

    }

}
