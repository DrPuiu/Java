package org.lab_7;

import org.lab_7.command.CommandReader;
import org.lab_7.map.Direction;
import org.lab_7.map.ExplorationMap;
import org.lab_7.map.Robot;
import org.lab_7.map.Timekeeper;
import org.lab_7.memory.SharedMemory;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final int n = 5;
    private final SharedMemory mem = new SharedMemory(n);
    private final ExplorationMap map = new ExplorationMap(n);
    private final List<Robot> robots = new ArrayList<>();
    private Thread timekeeper;
    private CommandReader commandReader;
    private long startTime = 0;

    public static void main(String[] args) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E", 0, 0, Direction.RIGHT));
        explore.addRobot(new Robot("R2D2", 0, explore.getNumber() - 1, Direction.DOWN));
        explore.addRobot(new Robot("Optimus-Prime", explore.getNumber() - 1, explore.getNumber() - 1, Direction.LEFT));
        explore.addRobot(new Robot("Dante-II", explore.getNumber() - 1, 0, Direction.UP));
        explore.start();
    }

    public void addRobot(Robot robot) {
        robot.setExplore(this);
        robots.add(robot);
    }

    public void start() {
        startTime = System.nanoTime();
        timekeeper = new Thread(new Timekeeper());
        timekeeper.setDaemon(true);
        timekeeper.start();
        commandReader = new CommandReader(this);
        new Thread(commandReader).start();
        for(Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public void calculateTokens() {
        System.out.println("The exploration of the matrix is done!");
        for(Robot robot : this.robots) {
            System.out.println(robot.getName() + "->" + robot.getInsertedTokens());
            robot.stop();
        }
        System.out.println(map);
        //commandReader.stop();
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public Robot getRobot(String robotName) {
        for(var robot : getRobots()) {
            if(robot.getName().equals(robotName))
                return robot;
        }
        return null;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public SharedMemory getMem() {
        return mem;
    }

    public Thread getTimekeeper() {
        return timekeeper;
    }

    public long getTime() {
        return (System.nanoTime() - startTime) / 1_000_000;
    }

    public int getNumber() {
        return n;
    }
}
