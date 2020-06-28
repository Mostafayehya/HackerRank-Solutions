package javaproblems.datastructures;

import java.io.*;
import java.util.*;

public class JavaList {
        public static Scanner scanner = new Scanner(System.in);

        /*
    5
    12 0 1 78 12
    2
    Insert
    5 23
    Delete
    0
    */
        public static void main(String[] args) {

            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                  list.add(scanner.nextInt());
            }
            int operations= scanner.nextInt();
            for (int i = 0; i <operations ; i++) {
                String op = scanner.next();
                if (op.equals("Insert")){
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    list.add(x,y);
                }
                if (op.equals("Delete")){
                    int x = scanner.nextInt();
                    list.remove(x);
                }
            }

            for (int i = 0; i <list.size() ; i++) {
                System.out.print(list.get(i)+" ");
            }

        }
}