package com.company;

public class Triangle extends Shape {
    protected int size;
    protected int height, base, point, large;

    public Triangle(String label, int size, int labelLevel) {
        super(label, size, labelLevel);
        this.large = 1;
    }

    @Override
    public void drawShape() throws Exception {
        char[] word = label.toCharArray();
        
        if (this.label.length() > this.size) {
            throw new Exception("Word is too large");
        }
        try {
            for (height = 0; height < board.length - 1; height++) {
                for (base = point; base < point + large; base = base + 2) {
                    board[height][base] = 'X';
                }
                // Set new line "large"
                large = large + 2;
                // Move pointer for the next iteration
                point = point - 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Something went wrong!!!");
        }

    }
}
