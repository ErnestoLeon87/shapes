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
        Dimensions dim = new Dimensions();
        String shapeToDraw;
        String shapeLabel;
        int shapeSize = 0;
        int rowLabel = 0;
        boolean run = true;

        System.out.println("+------------------------------------+");
        System.out.println("|          Welcome to Draw           |");
        System.out.println("+------------------------------------+");

        while (run) {
//      Getting the shape the user wants to print
            while (true) {
                try {
                    System.out.println("  => What shape should I draw? ( Triangle | Square | Diamond | Rectangle ) ");
                    shapeToDraw = reader.readLine();
                    shapeToDraw = shapeToDraw.toLowerCase();
                    if (shapeToDraw.equals("triangle")
                            || shapeToDraw.equals("square")
                            || shapeToDraw.equals("diamond")
                            || shapeToDraw.equals("rectangle")) {
                        break;
                    } else {
                        throw new Exception("\n Invalid shape. ");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage() + " You can draw ( Triangle | Square | Diamond | Rectangle)");
                }
            }

//        Getting shape dimensions
            switch (shapeToDraw) {
                case "rectangle":
                    while (true) {
                        try {
                            System.out.println("  => For a " + shapeToDraw + " I need its width and height");
                            System.out.print("  => Please enter the width: ");
                            int width = Integer.parseInt(reader.readLine());
                            System.out.print("  => Please enter the height: ");
                            int height = Integer.parseInt(reader.readLine());
                            dim.setWidth(width);
                            dim.setHeight(height);

                            break;
                        } catch (Exception ex) {
                            System.out.println(" I'm sorry I didn't understand that,\n please enter a positive number");
                        }
                    }
                    break;
                default:
                    while (true) {
                        try {
                            System.out.print("  => How tall should the " + shapeToDraw + " be? ");
                            shapeSize = Integer.parseInt(reader.readLine());
                            break;
                        } catch (Exception ex) {
                            System.out.println(" I'm sorry I didn't understand that,\n please enter a positive number");
                        }
                    }
                    break;
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
                    if (shapeSize == 0) {
                        if (rowLabel > dim.getHeight())
                            throw new Exception(" Invalid row"); // Fix the exception
                    } else {
                        if (rowLabel > shapeSize)
                            throw new Exception(" Invalid row"); // Fix the exception
                    }
                    break;
                } catch (IOException nx) {
                    System.out.println(" Please enter a positive integer");
                } catch (Exception ex) {
                    System.out.println(" " + ex.getMessage());
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

                case "diamond":
                    try {
                        newShape = new Diamond(shapeLabel, shapeSize, rowLabel);
                        newShape.generateShape();
                        newShape.showBoard();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "rectangle":
                    try {
                        newShape = new Rectangle(shapeLabel, dim.getWidth(), dim.getHeight(), rowLabel);
                        newShape.generateShape();
                        newShape.showBoard();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

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
