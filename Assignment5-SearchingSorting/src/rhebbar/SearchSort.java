package rhebbar;

import java.util.*;

public class SearchSort {
    //Wrapper functions

    public void print(int[] arr) {
        printArray(arr);
    }

    public int[] getIntersectionOfArrays(int[] arr1, int[] arr2) {
        return intersection(arr1, arr2);
    }

    public int getPeakIndexInArray(int[] array) {
        return peakIndexInMountainArray(array);
    }

    public int countOnes(int[] arr, int low, int high) {
        return countNumberOfOnes(arr, low, high);
    }

    //Solution functions

    //Q2
    private int[] intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> setOfArr1 = new HashSet<Integer>();

        for(int i=0; i<arr1.length; i++) {
            setOfArr1.add(arr1[i]);
        }

        HashSet<Integer> setOfArr2 = new HashSet<Integer>();

        for(int i=0; i<arr2.length; i++) {
            setOfArr2.add(arr2[i]);
        }

        setOfArr1.retainAll(setOfArr2);

        int[] intersectionSet = new int[setOfArr1.size()];
        int j = 0;

        for(Integer i : setOfArr1) {
            intersectionSet[j++] = i;
        }

        return intersectionSet;
    }

    //Q3
    private int peakIndexInMountainArray(int[] arr) {
        if(arr.length < 3)
            return -1;

        int index = -1;

        for(int i=1; i<arr.length-1; i++) {
            if((arr[i-1] < arr[i]) && (arr[i] > arr[i+1]))
            {
                index = i;
                break;
            }
        }

        return index;
    }

    //Q4

    //Q5
    private int countNumberOfOnes(int[] arr, int low, int high) {
        while(low <= high) {
            int mid = (low+high)/2;

            //check if the element at the middle index is the last 1
            if ((mid == high || arr[mid + 1] == 0) && (arr[mid] == 1))
                return mid + 1;

            // If element is not last 1, check on the right side
            if (arr[mid] == 1)
                return countNumberOfOnes(arr, (mid + 1), high);

            // else check on the left side
            return countNumberOfOnes(arr, low, (mid - 1));
        }

        return 0;
    }

    //Helper functions
    private void printArray(int[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.print(array[i]);
            }
            else {
                System.out.print(array[i] + ", ");
            }
        }

        System.out.print("]");
        System.out.println();
    }
}
