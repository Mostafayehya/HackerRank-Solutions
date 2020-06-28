package javaproblems.datastructures;

import java.util.*;
import java.util.stream.Collectors;


public class JavaArrayList {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        int n = scanner.nextInt();

        List<List<String>> input = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            input.add(i, Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList()));
        }

        int q = scanner.nextInt();
        List<String> output = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            try {
                output.add(input.get(x - 1).get(y));
            } catch (Exception e) {
                output.add("ERROR!");
            }
        }

        for (String s : output) {
            System.out.println(s);
        }
    }

}





