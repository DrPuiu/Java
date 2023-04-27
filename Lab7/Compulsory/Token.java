package org.lab_7.memory;

public record Token(int number) {
    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
