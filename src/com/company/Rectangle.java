package com.company;

public class Rectangle extends Shape {
    protected int width, height;

    public Rectangle(String label, int width, int height, int rowLabel) {
        super(label, width, rowLabel);
        this.board = new char[height][width * 2];
        this.width = width;
        this.height = height;

    }

    @Override
    public void generateShape() throws Exception {
        char[] word = label.toCharArray();

        int wordIndex = 0;
        int wordStart = width - word.length - 1;
        try {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < board[i].length; j = j + 2) {
                    if (rowLabel == i) {
                        if (word.length > width) throw new Exception("Word too long");
                        if (wordIndex < word.length) {
                            if (wordStart <= j) {  // Determine where to start to print the label
                                board[i][j] = word[wordIndex];
                                wordIndex++;
                            } else {
                                board[i][j] = '#';
                            }

                        } else {
                            board[i][j] = '#';
                        }

                    } else {
                        board[i][j] = '#';
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "!!!");
        }
    }

    public static void main(String[] args) throws Exception {
        Rectangle rec = new Rectangle("LU", 25, 8, 4);
        rec.generateShape();
        rec.showBoard();
    }

}
