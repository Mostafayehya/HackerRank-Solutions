package javaproblems.datastructures;

import java.util.*;
public class SumOfList {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int n = scanner.nextInt();
        int sum = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
            list.add(scanner.nextInt());

        for (int i = 0; i < n; i++) {
            int s=0;
            for (int j = i; j < n; j++) {
                s +=list.get(j);

                if (s<0) sum++;
            }
        }

        System.out.println(sum);

    }

    static int sumOfList(List<Integer> list) {
        Integer sum = 0;
        for (Integer i : list)
            sum += i;
        return sum;
    }
}





