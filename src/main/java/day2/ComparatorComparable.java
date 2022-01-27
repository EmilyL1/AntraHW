package day2;

import java.util.*;

public class ComparatorComparable {
    public static void main(String[] args) {
        //PriorityQueue
        Queue<Apple> pq = new PriorityQueue<>();
        pq.offer(new Apple(1));
        pq.offer(new Apple(2));
        pq.offer(new Apple(3));
        System.out.println(pq.peek().price);
        //TreeMap
        Map<Apple,Integer> map = new TreeMap<>(((o1, o2) -> o1.price - o2.price));
        map.put(new Apple(1),1);
        map.put(new Apple(2),2);
        map.put(new Apple(3),3);
        System.out.println(map.entrySet().stream().findFirst().get().getKey().price);
        //Map
        Map<Integer,Integer> hashtable = new Hashtable<>();
        Map<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,1);
        linkedHashMap.put(1,2);
        linkedHashMap.put(2,3);
        for(Map.Entry<Integer,Integer> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getValue());
        }
        System.out.println(linkedHashMap.entrySet().stream().anyMatch((o1) -> o1.getValue() == 1));
        //List
        List<Integer> arrayList = new ArrayList<>(1);
        arrayList.add(1);
        arrayList.add(2);
        Vector<Integer> stack = new Stack<>();
        //Queue
        Deque<Integer> stack1 = new ArrayDeque<>();
        stack1.addFirst(1);
        stack1.addFirst(2);
        stack1.addLast(3);
        stack1.push(4);
        for(int i : stack1){
            System.out.println(i);
        }

    }
}
class Apple implements Comparable<Apple>{
    int price = 1;
    Apple(int price){
        this.price = price;
    }

    @Override
    public int compareTo(Apple o) {
        if(this.price == o.price) return 0;
        else return this.price > o.price ? -1:1;
    }
}
