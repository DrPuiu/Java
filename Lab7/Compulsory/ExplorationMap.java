package org.lab_7.map;

import org.lab_7.memory.Token;

import java.util.*;

public class ExplorationMap {
    private final int n;
    private final Cell[][] matrix;

    public ExplorationMap(int n) {
        this.matrix = new Cell[n][n];
        this.n = n;
    }

    public boolean visit(int row, int col, Robot robot) {
        if(matrix[row][col] == null) {
            List<Token> extracted = robot.explore.getMem().extractTokens(n);
            matrix[row][col] = new Cell(extracted);
            robot.incrementInsertedTokens();
            System.out.println("Robot: " + robot.getName() + " successfully inserted a token into the matrix at (" + row + ", " + col + ")");
            return true;
        }
        return false;
    }

    public int getNumber() {
        return n;
    }

    public Cell getElement(int row, int col) {
        return matrix[row][col];
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for(var row : matrix) {
            for(var col : row) {
                msg.append(col).append(" ");
            }
            msg.append("\n");
        }
        return msg.toString();
    }
}
