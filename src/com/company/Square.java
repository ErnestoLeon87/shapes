package com.company;

public class Square extends Shape {


    public Square(String label, int size, int labelLevel) {
        super(label, size, labelLevel);
        this.board = new char[size * 2][size * 2];
    }

    @Override
    public void generateShape() throws Exception {
        char[] word = label.toCharArray();
        int wordIndex = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < board[size - 1].length; j = j + 2) {
                if (labelLevel == i) {
                    if (word.length > size) throw new Exception("Word too long");
                    if (wordIndex < word.length) {
                        board[i][j] = word[wordIndex];
                    } else {
                        board[i][j] = '#';
                    }
                    wordIndex++;
                } else {
                    board[i][j] = '#';
                }
            }
        }


    }
}
