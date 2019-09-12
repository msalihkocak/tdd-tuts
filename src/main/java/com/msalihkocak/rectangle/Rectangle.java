package com.msalihkocak.rectangle;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Rectangle {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double getAspectRatio(){
        return (double) width / height;
    }

    public boolean isSquare(){
        return width == height;
    }

    public int getArea(){
        return width * height;
    }

    public int[] getSides(){
        return new int[] { width, height};
    }

    public List<Integer> getSidesList(){
        return asList(width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width &&
                height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
