package rhebbar;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        SearchSort ss = new SearchSort();

        printSeparator();

        ////
        //Q1: Find K Closest Elements
        System.out.println("Question 1 - Find K closest elements");

        System.out.println("Pass 1 : ");

        int[] closeArr = new int[] {1,2,3,4,5};
        int numberOfElements = 4;
        int toElement = 3;

        System.out.println("Input array is : ");
        ss.print(closeArr);

        System.out.println("Closest elements to " + toElement + " are : "
                + ss.findClosestElementsFor(closeArr, numberOfElements, toElement));

        System.out.println("Pass 2 : ");

        closeArr = new int[] {1,2,3,4,5};
        numberOfElements = 4;
        toElement = -1;

        System.out.println("Input array is : ");
        ss.print(closeArr);

        System.out.println("Closest elements to " + toElement + " are : "
                + ss.findClosestElementsFor(closeArr, numberOfElements, toElement));

        printSeparator();

        /////
        //Q2: Find Intersection of 2 sorted arrays
        System.out.println("Question 2 - Find intersection of 2 sorted arrays");

        System.out.println("Pass 1 :");

        int[] array1 = new int[] {4,9,5};
        System.out.print("Array 1 - ");
        ss.print(array1);

        int[] array2 = new int[] {9,4,9,8,4};
        System.out.print("Array 2 - ");
        ss.print(array2);

        int[] intersection = ss.getIntersectionOfArrays(array1, array2);
        System.out.print("Intersection - ");
        ss.print(intersection);

        System.out.println("Pass 2 : ");

        array1 = new int[] {1, 2, 2, 1};
        System.out.print("Array 1 - ");
        ss.print(array1);

        array2 = new int[] {2, 2};
        System.out.print("Array 2 - ");
        ss.print(array2);

        intersection = ss.getIntersectionOfArrays(array1, array2);
        System.out.print("Intersection - ");
        ss.print(intersection);

        printSeparator();

        /////
        //Q3: Peak Index in a mountain
        System.out.println("Question 3 - Peak Index in a mountain");

        System.out.println("Pass 1 :");

        int[] arr = new int[] {0,1,0};
        System.out.print("Array is - ");
        ss.print(arr);

        int peakIndex = ss.getPeakIndexInArray(arr);
        System.out.println("Peak is at index " + peakIndex);

        System.out.println("Pass 2 :");

        arr = new int[] {24,69,100,99,79,78,67,36,26,19};
        System.out.print("Array is - ");
        ss.print(arr);

        peakIndex = ss.getPeakIndexInArray(arr);
        System.out.println("Peak is at index " + peakIndex);

        printSeparator();

        /////
        //Q4: Reorganize string
        System.out.println("Question 4 - Reorganize string");

        String s = "aab";
        System.out.println("Pass 1 : " + s);

        String output = ss.reorganise(s);

        if(output.length() > 0)
            System.out.println("Reorganised string is " + output);
        else
            System.out.println("Cannot reorganise string");

        s = "aaab";
        System.out.println("Pass 2 : " + s);

        output = ss.reorganise(s);

        if(output.length() > 0)
            System.out.println("Reorganised string is " + output);
        else
            System.out.println("Cannot reorganise string");

        printSeparator();

        /////
        //Q5: Count number of 1's in sorted binary array
        System.out.println("Question 5 - Count number of 1's in sorted binary array");

        int[] binArr = { 1, 1, 1, 1, 0, 0, 0 };
        System.out.println("Pass 1 : " + Arrays.toString(binArr));

        int n = binArr.length;
        System.out.println(ss.countOnes(binArr, 0, n-1) + " number of 1s found in the array");

        binArr = new int[] {1, 1, 1, 1, 1, 1, 1};
        System.out.println("Pass 2 : " + Arrays.toString(binArr));

        n = binArr.length;
        System.out.println(ss.countOnes(binArr, 0, n-1) + " number of 1s found in the array");

        printSeparator();
    }

    public static void printSeparator() {
        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();
    }
}
