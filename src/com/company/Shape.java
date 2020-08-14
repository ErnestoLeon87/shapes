package com.company;

public abstract class Shape {
    protected String label = "LU";
    protected int labelLevel;
    protected char[][] board;

    public Shape(String label, int size, int labelLevel) {
        this.label = label;
        this.board = new char[size + 1][(size * 2) + 1];
        this.labelLevel = size / 2;

    }

    public void showBoard() {
        for (char[] chars : this.board) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    System.out.print(aChar);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }


    public abstract void drawShape() throws Exception;
}
