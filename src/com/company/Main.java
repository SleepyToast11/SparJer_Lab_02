package com.company;

/**
 * Name: Jerome Sparnaay
 * Date: January 18th, 2022
 * Description: method of array manipulation program and testing of said method
 */
public class Main {
    /**
     * Displays name of the author of the program
     * */
    public static void displayName(){
        System.out.println("Jerome Sparnaay");
    }

    /**
     * prints array on a single line with elements
     * separated with spaces and ended with an end-line
     * @param array one-dimensional array
     */
    public static void displayArray(int[] array){
    StringBuilder arrayString = new StringBuilder();
        for (int j : array) arrayString.append(j).append(" ");
    System.out.println(arrayString);
    }

    /**
     * prints each row of a two-dimensional array by passing each
     * row separately to displayArray
     * @param array two-dimensional array
     * */
    public static void displayArray(int[][] array){

        for (int[] ints : array) displayArray(ints);
    }

    /**
     * verifies if two one-dimensional array are of equal length and if every
     * index of the arrays are equal in value
     * as a result
     * @param array1 one-dimensional array
     * @param array2 one-dimensional array
     * @return boolean value of if the two provided arrays are equal
     * */
    public static boolean arrayEqual(int[] array1,int[] array2){

        if (array1.length != array2.length)
            return false;

        for (int i = 0; i < array1.length; i++){
            if (array1[i] != array2[i])
                return false;}

        return true;
    }

    /**
     * verifies if two two-dimensional array have same number of rows and if every
     * rows are the same by passing each row as a single dimension array
     * to arrayEqual and returns a boolean as a result
     * @param array1 first two-dimensional array
     * @param array2 second two-dimensional array
     * @return boolean value of if the two provided arrays are equal
     * */
    public static boolean arrayEqual(int[][] array1,int[][] array2){

        if (array1.length != array2.length)
            return false;

        for (int i = 0; i < array1.length; i++)
            if (!arrayEqual(array1[i], array2[i]))
                return false;

        return true;
    }

    /**
     * Sums all the elements of a one-dimensional
     * @param array one-dimensional array
     * @return the sum of the 1d array as an int
     * */
    public static int arraySum(int[] array){

        int result = 0;
        for (int i : array) result += i;
        return result;
    }

    /**
     * Sums all the rows of a two-dimensional array by passing
     * them as a one dimensional array into the method for 1d array summation
     * the result as an int
     * @param array two-dimensional array
     * @return the sum of the 2d array as an int
     * */
    public static int arraySum(int[][] array){
        int result = 0;
        for (int[] i : array) result += arraySum(i);
        return result;
    }

    /**
     * Multiply the values of an array1 with the homologous value of array2
     * ,storing value to a two-dimensional of same size and returning it
     * @param array1 two-dimensional array
     * @param array2 two-dimensional array
     * @return a two-dimensional array that contain the value of each index of the two arrays multiplied
     * */
    public static int[][] multiplyArray(int[][] array1, int[][] array2){
        int n = array1.length, m = array1[0].length;
        int[][] result = new int[array1.length][array1[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                result[i][j] = array1[i][j] * array2[i][j];
            }
        }
        return result;
    }

    /**
     * Main function serving to test for the methods.
     * As many methods rely on another method to work some won't be tested directly
     * as it would be redundant
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int[][] twoDArray1={{1,2},{3,4},{12,43}}, twoDArray2 = {{3,4},{55,2},{4,2}}, twoDArray1Copy={{1,2},{3,4},{12,43}};
    int[] oneDArray1 = {2,4,6}, oneDArray1Copy = {2,4,6}, oneDArray2 = {1,2,3};
        System.out.println("this is a test printing 1d array");
    displayArray(oneDArray1);

        System.out.println("\nthis is a test printing 2d array");
    displayArray(twoDArray1);

        System.out.println("\nmultiply two arrays:");
        displayArray(twoDArray1);
        System.out.println("X");
        displayArray(twoDArray2);
        System.out.println("=");
        displayArray(multiplyArray(twoDArray1, twoDArray2));

        System.out.println("\nare two 2d arrays equal (first: different, second: same)");
        System.out.println(arrayEqual(twoDArray1, twoDArray2));
        System.out.println(arrayEqual(twoDArray1,twoDArray1Copy));
        System.out.println(arrayEqual(oneDArray1,oneDArray1Copy));

    }
}
