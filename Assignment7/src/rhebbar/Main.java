package rhebbar;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q1: Rotate image
        System.out.println("Q1: Rotate image");

        System.out.println("Pass 1: ");

        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};

        System.out.println("Before rotate: ");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("After rotate: ");
        printMatrix(matrix);

        System.out.println("Pass 2: ");

        matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};

        System.out.println("Before rotate: ");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("After rotate: ");
        printMatrix(matrix);

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q2: Reverse words in a string
        System.out.println("Q2: Reverse words in a string");

        System.out.println("Pass 1: ");
        String s1 = "the sky is blue";
        System.out.println("Input string is : " + s1);
        System.out.println("Reversed string is : " + reverseWords(s1));

        System.out.println("Pass 2: ");
        s1 = "  Bob    Loves  Alice  ";
        System.out.println("Input string is : " + s1);
        System.out.println("Reversed string is : " + reverseWords(s1));

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q3: Set matrix zeroes
        System.out.println("Q3: Set matrix zeroes");

        System.out.println("Pass 1: ");
        matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println("Input matrix is: ");
        printMatrix(matrix);

        setZeroes(matrix);
        System.out.println("Output matrix is: ");
        printMatrix(matrix);

        System.out.println("Pass 2: ");
        matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("Input matrix is: ");
        printMatrix(matrix);

        setZeroes(matrix);
        System.out.println("Output matrix is: ");
        printMatrix(matrix);
        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q4: Valid anagram
        System.out.println("Q4: Valid anagram");

        System.out.println("Pass 1: ");
        String s = "anagram";
        String t = "nagaram";

        boolean result = isAnagram(s, t);

        if(result) {
            System.out.println("Strings -" + s + "- and -" + t + "- are anagrams");
        }
        else {
            System.out.println("Strings -" + s + "- and -" + t + "- are not anagrams");
        }

        System.out.println("Pass 2: ");
        s = "rat";
        t = "car";

        result = isAnagram(s, t);

        if(result) {
            System.out.println("Strings -" + s + "- and -" + t + "- are anagrams");
        }
        else {
            System.out.println("Strings -" + s + "- and -" + t + "- are not anagrams");
        }

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q5: Longest common prefix
        System.out.println("Q5: Longest common prefix");

        System.out.println("Pass 1: ");
        String[] strings = {"flower","flow","flight"};

        System.out.print("Input is : ");
        System.out.println(Arrays.toString(strings));

        String commonPrefix = longestCommonPrefix(strings);

        if(commonPrefix.length() > 0) {
            System.out.println("The longest common prefix is " + commonPrefix);
        }
        else {
            System.out.println("There is no common prefix");
        }

        System.out.println("Pass 2: ");
        strings = new String[] {"dog","racecar","car"};

        System.out.print("Input is : ");
        System.out.println(Arrays.toString(strings));

        commonPrefix = longestCommonPrefix(strings);

        if(commonPrefix.length() > 0) {
            System.out.println("The longest common prefix is " + commonPrefix);
        }
        else {
            System.out.println("There is no common prefix");
        }

        printSeparator();
    }

    //Solution functions

    //Q1
    private static void rotate(int[][] matrix) {
        int n = matrix.length;

        /* swapping elements at 4 places at a time */
        for(int i=0; i < (n+1)/2; i++) {
            for(int j=0; j < n/2; j++) {
                int temp = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    //Q2
    private static String reverseWords(String s) {
        //removing extra spaces if any
        s = s.trim();

        //splitting based on spaces
        List<String> words = Arrays.asList(s.split("\\s+"));

        //reversing the collection
        Collections.reverse(words);

        return String.join(" ", words);
    }

    //Q3
    private static void setZeroes(int[][] matrix) {

        int numberOfRows = matrix.length;
        int numberOfCols = matrix[0].length;

        Set<Integer> rowsWithZero = new HashSet<>();
        Set<Integer> colsWithZero = new HashSet<>();

        //store the rows and columns marked zero
        for(int i=0; i < numberOfRows; i++) {
            for(int j=0; j < numberOfCols; j++) {
                if(matrix[i][j] == 0) {
                    rowsWithZero.add(i);
                    colsWithZero.add(j);
                }
            }
        }

        //update elements on stored rows and columns
        for(int i=0; i < numberOfRows; i++) {
            for(int j=0; j < numberOfCols; j++) {
                if(rowsWithZero.contains(i) || colsWithZero.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //Q4
    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) //unequal lengths mean different strings
            return false;

        int[] charCount = new int[26];

        //count and store the occurrence of each character in 1st string
        for(int i=0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        //check each character occurrence in 2nd string and update count
        for(int i=0; i < t.length(); i++) {
            int i1 = charCount[t.charAt(i) - 'a'];
            i1--;

            //if count goes below 0, strings don't match
            if(i1 < 0)
                return false;
        }

        return true;
    }

    //Q5
    private static String longestCommonPrefix(String[] strings) {
        if(strings == null || strings.length == 0)
            return "";

        //assume first string to be the prefix
        String prefix = strings[0];

        for(int i=1; i<strings.length; i++) {

            while(strings[i].indexOf(prefix) != 0) { //0 means prefix matches the string
                //reduce by last character
                prefix = prefix.substring(0, prefix.length()-1);

                if(prefix.length() == 0)
                    return "";
            }
        }

        return prefix;
    }

    //Helper functions
    public static void printSeparator() {
        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();
    }

    public static void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j< matrix.length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
