package oop1.ex;

public class RectangleProceduralMain {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,8);
        int area = rectangle.calculateArea();
        System.out.println("넓이: " + area);
        int perimeter = rectangle.calculatePerimeter();
        System.out.println("둘레 길이: " + perimeter);
        boolean square = rectangle.isSquare();
        System.out.println("정사각형 여부: " + square);
    }
}
