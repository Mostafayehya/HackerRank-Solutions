package javaproblems.datastructures;

import java.io.*;
import java.util.*;

/*Java's BitSet class implements a vector of bit values (i.e.:  () or  ()) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of  is called a set bit.

Given  BitSets,  and , of size  where all bits in both BitSets are initialized to , perform a series of  operations. After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.

Input Format

The first line contains  space-separated integers,  (the length of both BitSets  and ) and  (the number of operations to perform), respectively.
The  subsequent lines each contain an operation in one of the following forms:

AND
OR
XOR
FLIP
SET
In the list above,  is the integer  or , where  denotes  and  denotes .
 is an integer denoting a bit's index in the BitSet corresponding to .

For the binary operations , , and , operands are read from left to right and the BitSet resulting from the operation replaces the contents of the first operand. For example:

AND 2 1
 is the left operand, and  is the right operand. This operation should assign the result of  to .

Constraints

Output Format

After each operation, print the respective number of set bits in BitSet  and BitSet  as  space-separated integers on a new line.

Sample Input

5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1
Sample Output

0 0
1 0
1 1
1 2*/
public class JavaBitSet {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int size = scanner.nextInt();
        BitSet bs1 = new BitSet(size);
        BitSet bs2 = new BitSet(size);

        int operations = scanner.nextInt();
        int[][] arr = new int[operations][2];
        String currentOperation;
        int input1, input2;
        for (int i = 0; i < operations; i++) {
            currentOperation = scanner.next();
            input1 = scanner.nextInt();
            input2 = scanner.nextInt();

            switch (currentOperation) {
                case "AND": {
                    if(input1 < input2)
                       bs1.and(bs2);
                    else
                        bs2.and(bs1);
                    arr[i][0] = bs1.cardinality();
                    arr[i][1] = bs2.cardinality();
                } break;

                case "SET": {
                    if(input1 ==1)
                        bs1.set(input2);
                    else
                        bs2.set(input2);
                    arr[i][0] = bs1.cardinality();
                    arr[i][1] = bs2.cardinality();

                }  break;
                case "FLIP": {
                    if(input1 ==1)
                        bs1.flip(input2);
                    else
                        bs2.flip(input2);
                    arr[i][0] = bs1.cardinality();
                    arr[i][1] = bs2.cardinality();
                }  break;

                case "OR": {
                    if(input1 < input2)
                        bs1.or(bs2);
                    else
                        bs2.or(bs1);
                    arr[i][0] = bs1.cardinality();
                    arr[i][1] = bs2.cardinality();

                }  break;
                case "XOR": {
                    if(input1 < input2)
                        bs1.xor(bs2);
                    else
                        bs2.xor(bs1);
                    arr[i][0] = bs1.cardinality();
                    arr[i][1] = bs2.cardinality();

                }  break;
                default :{

                }

            }

        }

        for(int i =0 ; i<operations;i++){
            System.out.format("%d %d\n",arr[i][0],arr[i][1]);
        }

    }
}