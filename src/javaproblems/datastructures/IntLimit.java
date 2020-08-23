package javaproblems.datastructures;

import java.util.ArrayList;
import java.util.List;

public class IntLimit {

    public static void main(String[] args) {

        System.out.println(print(1));
    }

    static Exception print(int i){
        if(i == 1)
            return new Exception();
        else
            throw new RuntimeException();
    }
}
