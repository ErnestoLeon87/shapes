package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle extends Shape {
    protected int height, base, point, large;

    public Triangle(String label, int size, int rowLabel) {
        super(label, size, rowLabel);
        this.large = 1;
        this.point = size;
        this.board = new char[size + 1][(size * 2) + 1];
        this.rowLabel = rowLabel - 1;
    }

    @Override
    public void generateShape() throws Exception {
        char[] word = label.toCharArray();
        if (word.length > size) throw new Exception("Word is too large");

        // Calculate the center to print the word
        int start = size - word.length;

        try {
            int wordIndex = 0;
            int space = point + large;
            for (height = 0; height < board.length - 1; height++) {
                for (base = point; base < space; base = base + 2) {
                    if (height == rowLabel) {
                        if (word.length > space) throw new Exception("The word is too large for this level");
                        if (wordIndex < word.length) {
                            if (start <= base) {  // Determine where to start to print the label
                                start = start + 2;
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

//    @Override
//    protected int findCenterPrintWord(char[] word) {
//        return size - word.length;
////        if (rowLabel % 2 == 0) {
////            if (word.length > 4) {
////                return size - word.length;
////            } else {
////                return size - word.length / 2;
////            }
////        } else {
////            return (word.length > 4) ? (size - (word.length / 2)) : (size - (word.length / 2));
//////            if (word.length > 4) {
//////                return (size - (word.length / 2)) - 1;
//////            } else {
//////                return (size - (word.length / 2));
//////            }
////        }
//    }
}
