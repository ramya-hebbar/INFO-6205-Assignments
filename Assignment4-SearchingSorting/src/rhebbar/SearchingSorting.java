package rhebbar;

import java.util.HashSet;

public class SearchingSorting {

    //Wrapper functions

    public void print(int[] arr) {
        printArray(arr);
    }

    public int[] intersect(int[] arr1, int[] arr2) {
        return intersectionOfArrays(arr1, arr2);
    }

    public void sortColors(int[] arr) {
        sortDutchFlag(arr);
    }

    //Solution functions

    //Q1
    private int[] intersectionOfArrays(int[] array1, int[] array2) {
        HashSet<Integer> setOfArray1 = new HashSet<>();

        for(int i=0; i<array1.length; i++) {
            setOfArray1.add(array1[i]);
        }

        HashSet<Integer> setOfArray2 = new HashSet<Integer>();

        for(int i=0; i<array2.length; i++) {
            setOfArray2.add(array2[i]);
        }

        setOfArray1.retainAll(setOfArray2);

        int[] intersectionSet = new int[setOfArray1.size()];
        int j = 0;

        for(Integer i : setOfArray1) {
            intersectionSet[j++] = i;
        }

        return intersectionSet;
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
