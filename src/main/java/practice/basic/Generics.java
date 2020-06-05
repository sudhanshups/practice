package practice.basic;

import java.util.*;

class MyGen<T> {
    T obj;

    void add(T obj) {
        this.obj = obj;
    }

    T get() {
        return obj;
    }
}


/*
 * T - Type E - Element K - Key N - Number V - Value
 */

public class Generics {

    public static <T> T addAndReturn(T element, Collection<T> collection) {
        collection.add(element);
        return element;
    }

    public static void main(String[] args) {
        Generics g = new Generics();

        MyGen<Integer> m = new MyGen<Integer>();
        m.add(2);
        // m.add("vivek");//Compile time error
        System.out.println(m.get());

        MyGen<String> n = new MyGen<String>();
        n.add("sudhanshu");
        System.out.println(n.get());

        Integer[] intArray = {10, 20, 30, 40, 50};
        Character[] charArray = {'J', 'A', 'V', 'A', 'T', 'P', 'O', 'I', 'N', 'T'};

        System.out.println("Printing Integer Array");
        printArray(intArray);

        System.out.println("Printing Character Array");
        printArray(charArray);


        String stringElement = "stringElement";
        List<String> stringList = new ArrayList<String>();
        String theElements = addAndReturn(stringElement, stringList);

        Integer integerElement = 123;
        List<Integer> integerList = new ArrayList<Integer>();
        Integer theElement = addAndReturn(integerElement, integerList);


/*        List<?> listUknown1 = new ArrayList<>();
        List<? extends A> listUknown2 = new ArrayList<>();
        List<? super A> listUknown3 = new ArrayList<>();*/

        List<A> listA = new ArrayList<A>();
        List<B> listB = new ArrayList<B>();
        List<O> listO = new ArrayList<>();

        //Wildcard is helpful while receiving the arguments in  method
        //unbounded
        processElements1(listA);
        processElements1(listB);

        removeEle(listA);
        removeEle(listB);

        addEle(listA);
        addEle(listO); //A can be added in O as method defined as ? super A


    }

    //Unbounded wildcard
    static public void processElements1(List<?> elements){
        for(Object a : elements){
            System.out.println(a);
        }
    }

    //Upper Bounded Wildcards , relax the restrictions on a variable. All list have A or A as base class can be received.
    static public void removeEle(List<? extends A> elements){
        for(A a : elements){
            System.out.println(a);
        }
    }

    //Lower Bounded Wildcards, tight the restriction. All list with object is A or superClass of A can be received.
    static public void addEle(List<? super A> elements){
        elements.add(new A()); //here, either A or subclass of A can be added as subclass of A is A also.
        for(Object a : elements){
            System.out.println(a);
        }
    }

    public static <E> void printArray(E[] elements) {
        for (E element : elements) {
            System.out.println(element);
        }
        System.out.println();
    }


}
class O{
}

class A extends O {
}

class B extends A {
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> vals;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        vals = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, vals.size());
        vals.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int last = vals.get(vals.size() - 1);
        vals.set(map.get(val), last);
        map.put(last, map.get(val));
        map.remove(val);
        vals.remove(vals.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random rand = new Random();
        int r = rand.nextInt(vals.size());
        return vals.get(r);
    }
}


