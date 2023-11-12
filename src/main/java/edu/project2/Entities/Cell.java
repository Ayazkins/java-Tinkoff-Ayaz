package edu.project2.Entities;

public class Cell {
    private final int row;
    private final int col;
    private Type type;

    public Cell(int row, int col, Type type) {
        this.col = col;
        this.row = row;
        this.type = type;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Type getType() {
        return type;
    }

    public void toPassage() {
        type = Type.PASSAGE;
    }
}
