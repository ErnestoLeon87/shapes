package com.company;

public class Diamond extends Shape {
    public Diamond(String label, int size, int rowLabel) {
        super(label, size, rowLabel);
        board = new char[size + 1][(size * 2) + 2];
        this.rowLabel = rowLabel;
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
                    if (l == rowLabel && rowLabel != board.length / 2) {
                        wordIndex = setWordHelper(word, large, wordStart, wordIndex, l, j);
                    } else {
                        if (board.length / 2 != l) board[l][j] = 'X';
                    }

                    if (i == rowLabel) {
                        wordIndex = setWordHelper(word, large, wordStart, wordIndex, i, j);

                    } else {
                        board[i][j] = 'X';
                    }
                }
                large = large - 2;
                l--;
                rowStart = rowStart + 2;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int setWordHelper(char[] word, int large, int wordStart, int wordIndex, int i, int j) throws Exception {
        if (word.length > large / 2) throw new Exception("The word is too large for this level");
        if (wordIndex < word.length) {
            if (wordStart <= j) {
                board[i][j] = word[wordIndex];
                wordIndex++;
            } else {
                board[i][j] = 'X';
            }
        } else {
            board[i][j] = 'X';
        }
        return wordIndex;
    }
}
