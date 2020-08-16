package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle extends Shape {
    protected int height, base, point, large;

    public Triangle(String label, int size, int labelLevel) {
        super(label, size, labelLevel);
        this.large = 1;
        this.point = size;
        this.board = new char[size + 1][(size * 2) + 1];
        this.labelLevel = labelLevel - 1;
    }

    @Override
    public void generateShape() throws Exception {
        char[] word = label.toCharArray();
        if (word.length > size) throw new Exception("Word is too large");

        // Calculate the center to print the word
        int start = 0;
        if (labelLevel % 2 == 0) {
            start = (size - (word.length / 2)) - 1;
        } else {
            start = size - (word.length / 2);
        }


        try {
            int wordIndex = 0;
            int space = point + large;
            for (height = 0; height < board.length - 1; height++) {
                for (base = point; base < space; base = base + 2) {
                    if (height == labelLevel) {

                        if (word.length > space) throw new Exception("The word is too large for this level");
                        if (wordIndex < word.length) {
                            if (start == base) {  // Determine where to start to print the label
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


    protected char[] stringGenerator(int space, String aWord) throws Exception {
        // Check is the word is too long for this position.
        // Build an string with the word wrapped with Xs
        // or just return the word

        int totalSpace = size * 2;
        int front = (totalSpace - space) / 2;
        if (aWord.length() > space)
            throw new Exception("The label is too long for this position. ");

        char[] rowResutl = new char[totalSpace];

//        int j = aWord.length() / 2;
//        int w = word.length / 2;
//        int z = 0;
//        int y = rowResutl.length / 2;

        char[] word = aWord.toCharArray();
        int startIndex = (totalSpace - word.length) / 2;
        for (int x = 0; x < word.length; x++) {
            rowResutl[startIndex] = word[x];
            startIndex++;
        }


        return rowResutl;
    }
}
