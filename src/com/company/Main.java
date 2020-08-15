package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Triangle triangle = new Triangle("LU", 10, 5);
        Square square = new Square("LU", 10, 5);


//        System.out.print("Please enter the size: ");
//        int size = in.nextInt();
        try {
            triangle.generateShape();
            triangle.showBoard();

            square.generateShape();
            square.showBoard();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }


    }
}
