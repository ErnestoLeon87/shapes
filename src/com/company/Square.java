package com.company;

public class Square extends Shape {


    public Square(String label, int size, int rowLabel) {
        super(label, size, rowLabel);
        this.board = new char[size * 2][size * 2];
        this.rowLabel = rowLabel - 1;
    }

    @Override
    public void generateShape() throws Exception {
        char[] word = label.toCharArray();
        int wordIndex = 0;
        int wordStart = size - word.length;
        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < board[size - 1].length; j = j + 2) {
                    if (rowLabel == i) {
                        if (word.length > size) throw new Exception("Word too long");
                        if (wordIndex < word.length) {
                            if (wordStart <= j) {  // Determine where to start to print the label
                                wordStart = wordStart + 2;
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

}
