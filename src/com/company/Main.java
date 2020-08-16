package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Shape newShape;
        String shapeToDraw;
        String shapeLabel;
        int shapeSize, rowLabel;
        boolean run = true;

        System.out.println("+------------------------------------+");
        System.out.println("|           Welcome to draw          |");
        System.out.println("+------------------------------------+");

        while (run) {
//      Getting the shape the user wants to print
            while (true) {
                try {
                    System.out.print("  => What shape should I draw? ( Triangle | Square | Diamond ) ");
                    shapeToDraw = reader.readLine();
                    shapeToDraw = shapeToDraw.toLowerCase();
                    if (shapeToDraw.equals("triangle") || shapeToDraw.equals("square")) {
                        break;
                    } else {
                        throw new Exception("\n Wrong shape");
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
                } catch (Exception ex) {
                    System.out.println("Invalid inputs");
                }
            }

//        Getting the row to print the label
            while (true) {
                try {
                    System.out.print(String.format("   => On what row should I print %s? ", shapeLabel));
                    rowLabel = Integer.parseInt(reader.readLine());
                    if (rowLabel > shapeSize) throw new Exception(" Invalid row"); // Fix the exception
                    break;
                } catch (IOException nx) {
                    System.out.println(" Please enter a positive integer");
                } catch (Exception ex) {
                    System.out.println(" Invalid row");
                }
            }


            switch (shapeToDraw) {
                case "triangle":
                    try {
                        newShape = new Triangle(shapeLabel, shapeSize, rowLabel);
                        newShape.generateShape();
                        newShape.showBoard();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;


                case "square":

                    try {
                        newShape = new Square(shapeLabel, shapeSize, rowLabel);
                        newShape.generateShape();
                        newShape.showBoard();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;


                default:
                    System.out.println();
            }


            while (true) {
                try {
                    System.out.print("Would you like to draw another shape? Y/N ");
                    String dec = reader.readLine();
                    dec = dec.toUpperCase();
                    if (dec.equals("Y")) {
                        break;
                    } else if (dec.equals("N")) {
                        run = false;
                        break;
                    } else {
                        throw new Exception("Please just type Y (Yes) or N (No)");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }
}
