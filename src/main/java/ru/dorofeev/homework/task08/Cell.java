package ru.dorofeev.homework.task08;

public class Cell {
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Cell(int value) {
        if (value == 0) this.value = value;
        else this.value = 1;
    }
}
