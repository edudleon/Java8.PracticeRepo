package lambda.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class BasicsPractice {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
       //Consumer that prints the parameter
        Consumer<String> c1 = System.out::println;
        List<String> result = new ArrayList<>();

        //Consumer that add the parameter to result list
        Consumer<String> c2 = result::add;

        //andThen will chain the consumer methods
        strings.forEach(c1.andThen(c2));
        System.out.println("size of results: " +result.size());
    }
}
