package com.binaryones;

import java.util.Stack;

/**
 * Given an integer n, return the length of the longest consecutive run of 1s in its binary representation.
 * For example, given 156, you should return 3.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int n = 156;
        String binary = "";
        binary = toBinary(n);
        int countOnes = 0;
        countOnes = countOnes(binary);
        printData(n, binary, countOnes);
    }
    // to binary method
    private static String toBinary(int n){
        // Stack to hold nums First In Last Out
        Stack<Integer> binaryStack = new Stack<Integer>();
        // Loop until n = 0
        while (n != 0){
            // Push remainder to stack
            binaryStack.push(n%2);
            // Divide by 2 to update n
            n = n/2;
        }
        // Plop the stack into a string
        String binaryString = "";
        // Pop each element into the string
        while(!binaryStack.empty()){
            binaryString += binaryStack.pop();
        }
        // return string
        return binaryString;
    }
    // Count the ones method
    private static int countOnes(String s){
        // Set length for loop
        int length = s.length();
        // Initialize number of 1's
        int count = 0;
        int max = count;
        // Loop through each char
        for (int i = 0; i < length; i++){
            if (s.charAt(i) == '1'){
                // Increment count if 1 detected
                count++;
                // Set max
                if (count > max){
                    max = count;
                }
            }
            // Restart count at every 0
            else {
                count = 0;
            }
        }
        return max;
    }
    // Print method
    private static void printData(int decimal, String binary, int onesCount){
        System.out.printf("\nOriginal Decimal Value:\t%d", decimal);
        System.out.printf("\nNew Binary Value:\t%s", binary);
        System.out.printf("\nNumber of 1's:\t\t%d\n", onesCount);
    }
}
