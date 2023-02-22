package lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MinMaxMean {
    public static void main(String[] args) {
        var randomList = GetRandomIntArray();
        System.out.println(randomList);
        
        System.out.printf("Min: %d, Max: %d, Average: %.2f \n",
        Min(randomList), Max(randomList), Avarage(randomList));
        
        System.out.print("Only odds numbers: ");
        for (Integer integer : GetOnlyEvens(randomList)) {
            System.out.printf("%d ", integer);
        }
    }
    public static ArrayList<Integer> GetRandomIntArray()
    {
        var rnd = new Random();

        var list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(rnd.nextInt(-100, 100));
        }
        return list;
    }

    public static int Min(ArrayList<Integer> list) {
        var minimum = list
                        .stream()
                        .min(Comparator.comparing(num -> num));
        return minimum.get();
    }

    public static int Max(ArrayList<Integer> list) {
        return Collections.max(list);
    }

    public static double Avarage(ArrayList<Integer> list) {
       return list
                .stream()
                .mapToInt(num -> num)
                .average()
                .getAsDouble();
    }

    public static List<Integer> GetOnlyEvens(ArrayList<Integer> list) {
        return  list 
                    .stream()
                    .filter(num -> num % 2 != 0)
                    .collect(Collectors.toList());
    }
}
