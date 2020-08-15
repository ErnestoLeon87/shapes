package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Triangle triangle;
        Square square;
        String shapeToDraw;
        String shapeLabel;
        int shapeSize, rowLabel;

        System.out.println("+------------------------------------+");
        System.out.println("|           Welcome to draw          |");
        System.out.println("+------------------------------------+");

//      Getting the shape the user wants to print
        while (true) {
            try {
                System.out.print("  => What shape should I draw? ( Triangle | Square | Diamond ) ");
                shapeToDraw = reader.readLine();
                shapeToDraw = shapeToDraw.toLowerCase();
                if (!shapeToDraw.equals("triangle")) {
                    throw new Exception("\n Wrong shape");
                } else {
                    break;
                }
            } catch (Exception ex) {
                System.out.println(" Invalid shape, you can draw ( Triangle | Square | Diamond)");
            }
        }

//        Getting how tall should be the shape
        while (true) {
            try {
                System.out.print("  => How tall should the " + shapeToDraw + " be? ");
                shapeSize = Integer.parseInt(reader.readLine());
                break;
            } catch (Exception ex) {
                System.out.println(" I'm sorry I didn't understand that,\n please enter a positive number");
            }
        }

//        Getting the label to print in the shape
        while (true) {
            try {
                System.out.print("  => What label should I print for this " + shapeToDraw + "\n\t (Leave blank for 'LU')?");
                shapeLabel = reader.readLine();
                if (shapeLabel.equals("")) shapeLabel = "LU";
                break;
            } catch (Exception ignored) {
            }
        }

//        Getting the row to print the label
        while (true) {
            try {
                System.out.print(String.format("   => On what row should I print %s ?", shapeLabel));
                rowLabel = Integer.parseInt(reader.readLine());
                if (rowLabel > shapeSize) throw new Exception(" Invalid row");
                break;
            } catch (IOException nx) {
                System.out.println(" Please enter a positive integer");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
