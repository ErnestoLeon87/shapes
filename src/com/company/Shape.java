package com.company;

public abstract class Shape {
    protected String label = "LU";
    protected int size;
    protected int labelLevel;
    protected char[][] board;

    public Shape(String label, int size, int labelLevel) {
        this.label = label;
        this.size = size;
        this.labelLevel = labelLevel;
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
}
