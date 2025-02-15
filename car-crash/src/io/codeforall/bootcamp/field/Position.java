package io.codeforall.bootcamp.field;

public class Position {

    private int col;

    private int row;

    public Position() {
        this.col = ((int) Math.floor(Math.random() * 100));
        this.row = ((int) Math.floor(Math.random() * 30));
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
