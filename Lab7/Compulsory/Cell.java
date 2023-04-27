package org.lab_7.map;

import org.lab_7.memory.Token;

import java.util.List;

public class Cell {
    private List<Token> element;

    public Cell(List<Token> element) {
        this.element = element;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("[");
        for(Token token : element) {
            msg.append(token).append(" ");
        }
        msg.append("]");
        return msg.toString();
    }
}
