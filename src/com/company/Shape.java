package com.company;

public abstract class Shape {
    protected String label = "LU";
    protected int size;
    protected int rowLabel;
    protected char[][] board;

    public Shape(String label, int size, int rowLabel) {
        this.label = label;
        this.size = size;
        this.rowLabel = rowLabel;
    }

    public void showBoard() {
        System.out.println("");
        for (char[] Strings : this.board) {
            for (char aChar : Strings) {
                if (aChar != 0) {
                    System.out.print(aChar);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    private void alignText() {
    }


    public abstract void generateShape() throws Exception;

    protected abstract int findCenterPrintWord(char[] aWord);
}
