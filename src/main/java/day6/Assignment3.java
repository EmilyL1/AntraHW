package day6;

import java.util.*;

public class Assignment3 {
    public static void main(String[] args) {
//        q1();
        q2();
    }

    public static void q1(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(10);
        Map<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","10");

        List<Integer> res = new ArrayList<>();
        for(int i : list){
            if(!map.containsValue(i + "")){
                res.add(i);
            }
        }
        System.out.println(res);
    }

    public static void q2(){
        Circle circle = new Circle(1.0);
        Square square = new Square(2.0);
        Rectangle rectangle = new Rectangle(1,2);
        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(square);
        shapes.add(rectangle);
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return Double.compare(o1.calculate(),o2.calculate());
            }
        });
        System.out.println(shapes);
    }
}

abstract class Shape{
    abstract double calculate();

}

class Circle extends Shape{
    double radius;

    public Circle(double radius) {
        this.radius = radius;

    }

    @Override
    double calculate() {
        return 3.14 * Math.pow(radius,2);
    }

    @Override
    public String toString() {
        return "Circle(" + radius + "):" + calculate();
    }
}

class Rectangle extends Shape{
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculate() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle(" + length + " " + width +"):" + calculate();
    }
}

class Square extends Shape{

    double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    double calculate() {
        return Math.pow(side,2);
    }

    @Override
    public String toString() {
        return "Square(" + side + "):" + calculate();
    }

}
