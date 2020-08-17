package com.company;

public class Diamond extends Shape {
    public Diamond(String label, int size, int rowLabel) {
        super(label, size, rowLabel);
        board = new char[size + 1][(size * 2) + 2];
    }

    @Override
    public void generateShape() throws Exception {
        int large = size * 2 + 2;
        int start = 0;
        int l = board.length / 2;
        try {
            for (int i = board.length / 2; i < board.length + 1; i++) {
                for (int j = start; j < large; j = j + 2) {
                    if (i == rowLabel) {

                    }

                    board[i][j] = 'X';
                    if (board.length / 2 != l) board[l][j] = 'X';

                }


                large = large - 2;
                l--;
                start = start + 2;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        for (int i = 0; i < board.length; i++) {
//            for (int j = start; j <= start + large; j = j + 2) {
//                board[i][j] = 'X';
//            }
//            large = large + 2;
//            start--;
//        }
    }


    public static void main(String[] args) throws Exception {
        Diamond diamond = new Diamond("LU", 10, 5);
        diamond.generateShape();
        diamond.showBoard();
    }
}
