package practice.basic;


import java.util.function.*;

interface SquareFunction1<T, R> {
    R apply(T a);
}

interface MyPrinter {
    void print(String s);
}

public class LambdaFunctionalInterface {
    public static void main(String[] atgs) {

        //Functional Interfaces example
        SquareFunction1<Integer,Integer> lambda = (a) -> {
            System.out.println("Executing..." + a);
            //multiply
            return a;
        };
        System.out.println(lambda.apply(10));

        MyPrinter myPrinter = (s) -> {
            System.out.println(s);
        };
        //Method reference s lamda
        MyPrinter myPrinter1 = System.out::println;


        //Built-in Functional Interfaces in Java
        Function<Long, Long> adder = (value) -> value + 3;
        Long resultLambda = adder.apply((long) 8);
        System.out.println("resultLambda = " + resultLambda);

        Predicate predicate = (value) -> value != null;
        UnaryOperator<Integer> unaryOperator = (a) -> {
            a = 10;
            return a;
        };

        BinaryOperator<String> binaryOperator = (value1, value2) -> {
            value1 = value1 + value2;
            return value1;
        };
        Supplier<Integer> supplier = () -> ((int) (Math.random() * 1000D));
        Consumer<Integer> consumer = (value) -> System.out.println(value);


        // Method References as Lambdas

        BiFunction<Character, Character, String> bf = (c1, c2) -> "Hello";
        System.out.println(bf.apply('a', 'b'));


    }
}
