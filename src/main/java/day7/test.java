package day7;

import java.awt.*;

public class test {
    public static void main(String[] args) {
        doSomething(new Car());
    }
    public void pupAge() {
        int age = 0;
        age = age + 7;
        System.out.println("Puppy age is : " + age);
    }
    public static void doSomething(final Car aCar){
        aCar.setColor(Color.red);
    }
}
class Car{

    public void setColor(Color color){

    }
}
