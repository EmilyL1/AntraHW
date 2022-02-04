package day6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Java8 {
    public static void main(String[] args) {
//        q1();
//        q2();
//        q3();
        q4();
    }

    static void q1(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("abc",1,"f"));
        list.add(new Person("ab",1,"f"));
        list.add(new Person("acc",1,"f"));
        list.add(new Person("abcd",1,"f"));
        System.out.println(search(list));

    }

    public static List<String> search(List<Person> list) {
        List<String> res = new ArrayList<>();
        list.stream()
                .filter(person -> person.getName().startsWith("a"))
                .filter(person -> person.getName().length() == 3)
                .map(person -> person.getName())
                .forEachOrdered(res::add);
        return res;


    }

    static void q2(){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(44);
        System.out.println(getString(list));

    }
    public static String getString(List<Integer> list) {
        return list.stream()
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(joining(","));
    }

    static void q3(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(average(list));

    }

    public static Double average(List<Integer> list) {
        return list.stream().mapToInt(i -> i).average().getAsDouble();
    }

    static void q4(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("bb");
        System.out.println(upperCase(list));

    }

    public static List<String> upperCase(List<String> list) {
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }




}

class Person{
    private String name;
    private int age;
    private String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
