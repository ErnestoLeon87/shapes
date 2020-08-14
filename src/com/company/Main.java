package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Triangle triangle = new Triangle("avatar", 10, 7);


//        System.out.print("Please enter the size: ");
//        int size = in.nextInt();
        try {
            triangle.drawShape();
            triangle.showBoard();
        } catch (Exception e) {

        }


    }
}
