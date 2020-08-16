package com.company;

public abstract class Shape {
    protected String label;
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
    
    public abstract void generateShape() throws Exception;

}
