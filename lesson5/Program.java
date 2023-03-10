package lesson5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Program {
    public static void main(String[] args) {
        ShowResult(MaxSubArray(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7}));        
        ShowResult(MaxSubArray(new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0}));        
        ShowResult(MaxSubArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 0, 0, 0, 0}));        
        ShowResult(MaxSubArray(new int[] { 1, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 1}));        
        ShowResult(MaxSubArray(new int[] { 8 }, new int[] { 1, 2, 9}));       
        ShowResult(MaxSubArray(new int[] { 1, 2, 3, 3, 4, 0, 6, 7, 8, 0, 1 }, 
                               new int[] { 1, 2, 1, 3, 4, 0, 6, 7, 8, 9, 10}));        

    }

    static void ShowResult(Optional<ArrayDeque<Integer>> result) {
        if(result.isPresent()) {
            var resultArray = result.get();
            System.out.println(resultArray.size());
            System.out.printf("Повторяющийся подмассив с максимальной длиной равен " + resultArray + "\n\n");
        }
        else {
            System.out.println("Совпадения не найдены!");
        }
    }

    static Optional<ArrayDeque<Integer>> MaxSubArray(int[] mask, int[] range) {
        var subs = FindAllSubArrays(mask, range);
        var maxSubArray = FindMaxArray(subs);
        return maxSubArray;
    }
    
    static ArrayList<ArrayDeque<Integer>> FindAllSubArrays (int[] mask, int[] range) {
        var results = new ArrayList<ArrayDeque<Integer>>();
        var temp = new ArrayDeque<Integer>();

        int i = 0, j = 0;
        while ( i < mask.length )
        {
            while (mask[i] == range[j]) {
                temp.addLast(range[j]);
                i++;
                j++;
                if(i == mask.length || j == range.length) {
                    break;
                }
            }

            if(!temp.isEmpty()) {
                results.add(temp.clone());
                temp.clear();
            }

            j = ++j % range.length;
            if (j == 0) {
                i++; 
            } 
        }

        return results;
    }

    static Optional<ArrayDeque<Integer>> FindMaxArray(ArrayList<ArrayDeque<Integer>> arrays)
    {
        return arrays
                  .stream()
                  .max(new DequeComparator());      
    }

    static class DequeComparator implements Comparator<ArrayDeque<Integer>> {

        @Override
        public int compare(ArrayDeque<Integer> o1, ArrayDeque<Integer> o2) {
           Integer o1_size = o1.size();
           Integer o2_size = o2.size();

           return o1_size.compareTo(o2_size);
        }

    }
}
