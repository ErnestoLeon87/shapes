package com.company;

public class Diamond extends Shape {
    public Diamond(String label, int size, int rowLabel) {
        super(label, size, rowLabel);
        board = new char[size + 1][(size * 2) + 2];
    }

    @Override
    public void generateShape() throws Exception {
        char[] word = label.toCharArray();
        int large = size * 2 + 2;
        int rowStart = 0;
        int l = board.length / 2;
        int wordStart = size - word.length;
        int wordIndex = 0;

        try {
            for (int i = board.length / 2; i < board.length + 1; i++) {
                for (int j = rowStart; j < large; j = j + 2) {
                    if (i == rowLabel) {
                        if (word.length > large) throw new Exception("The word is too large for this level");
                        if (wordIndex < word.length) {
                            if (wordStart <= j) {
                                board[]
                            }
                        }
                    }

                    board[i][j] = 'X';
                    if (board.length / 2 != l) board[l][j] = 'X';

                }

                large = large - 2;
                l--;
                rowStart = rowStart + 2;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) throws Exception {
        Diamond diamond = new Diamond("LU", 10, 5);
        diamond.generateShape();
        diamond.showBoard();
    }
}
