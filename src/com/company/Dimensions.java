package com.company;

public class Dimensions {
    private int width;
    private int height;
    private int size;

    public Dimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Dimensions(int size) {
        this.height = size;
        this.width = size;
    }

    public Dimensions() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
