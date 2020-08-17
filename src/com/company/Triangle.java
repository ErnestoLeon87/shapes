package com.company;


public class Triangle extends Shape {
    protected int height, base, point, large;

    public Triangle(String label, int size, int rowLabel) {
        super(label, size, rowLabel);
        this.large = 1;
        this.point = size;
        this.board = new char[size + 1][(size * 2) + 1];
    }

    @Override
    public void generateShape() throws Exception {
        char[] word = label.toCharArray();
        if (word.length > size) throw new Exception("Word is too large");

        // Calculate the center to print the word
        int wordStart = size - word.length;
        int wordIndex = 0;
        int space = point + large;
        try {
            for (height = 0; height < board.length - 1; height++) {
                for (base = point; base < space; base = base + 2) {
                    if (height == rowLabel) {
                        if (word.length > space) throw new Exception("The word is too large for this level");
                        if (wordIndex < word.length) { // Prevent index out of range
                            if (wordStart <= base) {  // Determine where to start to print the label
                                wordStart = wordStart + 2;
                                board[height][base] = word[wordIndex];
                                wordIndex++;
                            } else {
                                board[height][base] = 'X';
                            }
                        } else {
                            board[height][base] = 'X';
                        }

                    } else {
                        board[height][base] = 'X';
                    }
                }
                // Set new line "large"
                large = large + 2;
                // Move pointer for the next iteration
                point = point - 1;
                // Word space
                space = point + large;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " - Something went wrong!!! ");
        }

    }
}
