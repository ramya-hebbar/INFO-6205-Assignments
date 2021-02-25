package rhebbar;

import java.util.*;

public class SearchingSorting {

    //Wrapper functions

    public void print(int[] arr) {
        printArray(arr);
    }

    public int[] intersect(int[] arr1, int[] arr2) {
        return intersectionOfArrays(arr1, arr2);
    }

    public int findNthSmallest(int[] arr, int n){
        if(arr == null || n < 0 || n >= arr.length){
            return -1;
        }

        return findNthSmallest(arr, n, 0, arr.length -1);
    }

    public void sortColors(int[] arr) {
        sortDutchFlag(arr);
    }

    public void pancakeSort(int[] arr) {
        ArrayList<Integer> result = pancakeSorting(arr);

        System.out.print("Array sorted with the following indices - ");

        System.out.print("[");

        for (int i = 0; i < result.size() ; i++) {
            if(i == result.size() - 1) {
                System.out.print(result.get(i));
            }
            else {
                System.out.print(result.get(i) + ", ");
            }
        }

        System.out.print("]");
        System.out.println();
    }

    //Solution functions

    //Q1
    private int[] intersectionOfArrays(int[] array1, int[] array2) {
        HashSet<Integer> setOfArray1 = new HashSet<>();

        for (int k : array1) {
            setOfArray1.add(k);
        }

        HashSet<Integer> setOfArray2 = new HashSet<>();

        for (int k : array2) {
            setOfArray2.add(k);
        }

        setOfArray1.retainAll(setOfArray2);

        int[] intersectionSet = new int[setOfArray1.size()];
        int j = 0;

        for(Integer i : setOfArray1) {
            intersectionSet[j++] = i;
        }

        return intersectionSet;
    }

    //Q2
    private int findNthSmallest(int[] arr, int n, int low, int high){

        //check if n is within the partition
        if(n > 0 && n <= high-low+1){
            int pos = partition(arr, low, high);

            //check if element found
            if(pos-low == n-1){
                return arr[pos];
            }

            //check and search for element in the left partition
            if(pos-low > n-1) {
                return findNthSmallest(arr, n, low, pos - 1);
            }

            //search for element in the right partition
            return findNthSmallest(arr, n-pos+low-1, pos + 1, high);
        }
        else {
            System.out.println("N is out of bounds");
            return -1;
        }
    }

    //Q3
    private void sortDutchFlag(int[] array) {
        int pointerRed = 0;
        int currentIndex = 0;
        int pointerBlue = array.length - 1;

        int temp;

        while(currentIndex <= pointerBlue) {
            if(array[currentIndex] == 0) {
                temp = array[pointerRed];
                array[pointerRed++] = array[currentIndex];
                array[currentIndex++] = temp;
            }
            else if(array[currentIndex] == 2) {
                temp = array[currentIndex];
                array[currentIndex] = array[pointerBlue];
                array[pointerBlue--] = temp;
            }
            else {
                currentIndex++;
            }
        }
    }

    //Q4
    private ArrayList<Integer> pancakeSorting(int[] array) {
        ArrayList<Integer> resultList = new ArrayList<>();

        for(int i = array.length - 1; i > 0; i--) {
            for(int j = 0; j <= i; j++) {
                //looking for the largest element
                if(array[j] == i+1) {
                    //flip it and bring to front
                    flip(array, j);
                    resultList.add(j+1);
                    break;
                }
            }

            //largest element at the start - flip and send to the end
            flip(array, i);
            resultList.add(i+1);
        }

        return resultList;
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

    private void swap(int[] arr, int i , int j){
        if( arr == null || arr.length < 2 || i < 0 || j < 0 || i >= arr.length || j >= arr.length){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int wall = low -1;

        for(int i = low; i < high; i ++){
            //trying to bring all elements lesser than pivot to its left
            if(arr[i] < pivot){
                wall ++;
                swap(arr, i, wall);
            }
        }

        // swapping elements at pivot & wall positions such that pivot reaches desired index
        wall ++;
        swap(arr, high, wall);
        return wall;
    }

    private void flip(int[] arr, int flipIndex) {
        //performing a pancake flip - considering 2 elements at a time so looping through half time
        for(int i = 0; i <= flipIndex/2; i++) {
            swap(arr, i, flipIndex-i);
        }
    }
}
