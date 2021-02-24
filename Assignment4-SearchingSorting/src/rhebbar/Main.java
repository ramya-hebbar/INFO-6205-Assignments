package rhebbar;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here

        SearchingSorting ss = new SearchingSorting();

        printSeparator();

        /////
        //Q1: Find intersection of 2 unsorted arrays
        System.out.println("Question 1 - Find intersection of 2 unsorted arrays");

        System.out.println("Pass 1 :");

        int[] array1 = new int[] {4,9,5};
        System.out.print("Array 1 - ");
        ss.print(array1);

        int[] array2 = new int[] {9,4,9,8,4};
        System.out.print("Array 2 - ");
        ss.print(array2);

        int[] intersection = ss.intersect(array1, array2);
        System.out.print("Intersection - ");
        ss.print(intersection);

        System.out.println("Pass 2 : ");

        array1 = new int[] {1, 2, 2, 1};
        System.out.print("Array 1 - ");
        ss.print(array1);

        array2 = new int[] {2, 2};
        System.out.print("Array 2 - ");
        ss.print(array2);

        intersection = ss.intersect(array1, array2);
        System.out.print("Intersection - ");
        ss.print(intersection);

        printSeparator();

        /////
        //Q2 - Find nth Smallest of an unsorted array
        System.out.println("Question 2 - Find nth smallest of an unsorted array");


        printSeparator();

        /////
        //Q3 - Sort colours
        System.out.println("Question 3 - Dutch National Flag problem");

        System.out.println("Pass 1 : ");
        int[] arr = new int[] {2,0,2,1,1,0};
        System.out.print("Before sorting - ");
        ss.print(arr);
        ss.sortColors(arr);
        System.out.print("After sorting - ");
        ss.print(arr);

        System.out.println("Pass 2 : ");
        arr = new int[] {2,0,1};
        System.out.print("Before sorting - ");
        ss.print(arr);
        ss.sortColors(arr);
        System.out.print("After sorting - ");
        ss.print(arr);

        printSeparator();

        /////
        //Q4 - Pancake sort
        System.out.println("Question 4 - Pancake sort");

        printSeparator();
    }

    public static void printSeparator() {
        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();
    }
}
