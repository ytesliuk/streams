import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Yuliia Tesliuk on 10/25/2018
 */
public class Main {
    public static void main(String[] args){
        Random random = new Random();


        int[] array =  random.ints(-10,10)
                .limit(20).toArray();

        System.out.println("Initial array: " + Arrays.toString(array));

        System.out.format("Average: %.2f%n",
                IntStream.of(array).average().getAsDouble());

        System.out.println("Min (index / indexes): " +
                IntStream.range(0,array.length)
                .boxed()
                .collect(Collectors.toMap(
                        i -> array[i],
                        i -> String.format(" (index %d)", i),
                        (a, b) -> String.join(", ", a, b)))
                .entrySet().stream()
                .min(Comparator.comparing((a) -> a.getKey())).get().toString());


        System.out.println("Number of elements equal to 0: " +
                IntStream.of(array)
                .filter(x -> x == 0)
                .count());

        System.out.println("Number of elements greater than 0: " +
                IntStream.of(array)
                .filter(x -> x > 0)
                .count());

        System.out.println("New array. Elements are multiplied by 5: " +
        Arrays.toString(IntStream.of(array)
                .map(x -> x * 5)
                .boxed()
                .toArray()));


    }
}
