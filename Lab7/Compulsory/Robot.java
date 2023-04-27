package org.lab_7.map;

import org.lab_7.Exploration;

import static java.lang.Thread.sleep;

public class Robot implements Runnable {
    private String name;
    private int row;
    private int col;
    private Direction direction;
    private int insertedTokens;
    private boolean running;
    Exploration explore;

    public Robot(String name, int row, int col, Direction direction) {
        this.name = name;
        this.running = true;
        this.row = row;
        this.col = col;
        this.direction = direction;
    }

    @Override
    public void run() {
        while(running) {
            synchronized (explore) {
                explore.getMap().visit(row, col, this);
                changeDirection();
                if(!checkMatrix()) {
                    //stop();
                    break;
                }
            }
            if(explore.getTimekeeper().isAlive()) {
                System.out.println("Time spent: " + explore.getTime() / 1_000 + "s");
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("The time limit gas been reached!");
                running = false;
                break;
            }
        }
        if(explore.getMem().getFinish()) {
            explore.getMem().setFinish(false);
            synchronized (explore) {
                explore.calculateTokens();
            }
        }
    }

    private boolean checkMatrix() {
        for(var row : explore.getMap().getMatrix()) {
            for(var col : row)
                if(col == null)
                    return true;
        }
        return false;
    }

    private boolean checkValidity(int coordinate) {
        return coordinate >= 0 && coordinate < explore.getMap().getNumber();
    }

    private void changeDirection() {
        if(direction == Direction.UP) {
            row--;
            if(!checkValidity(row))
                row++;
            if(explore.getMap().getElement(row, col) != null) {
                direction = Direction.RIGHT;
                row++;
                col++;
            }
        }
        else if(direction == Direction.DOWN) {
            row++;
            if(!checkValidity(row))
                row--;
            if(explore.getMap().getElement(row, col) != null) {
                direction = Direction.LEFT;
                row--;
                col--;
            }
        }
        else if(direction == Direction.LEFT) {
            col--;
            if(!checkValidity(col))
                col++;
            if(explore.getMap().getElement(row, col) != null) {
                direction = Direction.UP;
                row--;
                col++;
            }

        }
        else if(direction == Direction.RIGHT) {
            col++;
            if(!checkValidity(col))
                col--;
            if(explore.getMap().getElement(row, col) != null) {
                direction = Direction.DOWN;
                row++;
                col--;
            }
        }
    }

    public void stop() {
        this.running = false;
    }

    public String getName() {
        return name;
    }

    public int getInsertedTokens() {
        return insertedTokens;
    }

    public void incrementInsertedTokens() {
        insertedTokens++;
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }
}
