package problemsolving.algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DiagonalSumSolution {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            firstDiagonalSum += arr.get(i).get(i);
            secondDiagonalSum += arr.get(i).get(arr.size()-1 - i);
        }

        return Math.abs(firstDiagonalSum - secondDiagonalSum);
    }

}

public class DiagonalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalSumSolution.diagonalDifference(arr);

        System.out.println(result);
    }
}

