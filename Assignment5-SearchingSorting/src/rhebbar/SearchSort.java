package rhebbar;

import java.util.*;

public class SearchSort {
    //Wrapper functions

    //General
    public void print(int[] arr) {
        printArray(arr);
    }

    //Q1
    public List<Integer> findClosestElementsFor(int[] arr, int k, int x) {
        return findClosestElements(arr, k, x);
    }

    //Q2
    public int[] getIntersectionOfArrays(int[] arr1, int[] arr2) {
        return intersection(arr1, arr2);
    }

    //Q3
    public int getPeakIndexInArray(int[] array) {
        return peakIndexInMountainArray(array);
    }

    //Q4
    public String reorganise(String s) {
        return reorganizeString(s);
    }

    //Q5
    public int countOnes(int[] arr, int low, int high) {
        return countNumberOfOnes(arr, low, high);
    }

    //Solution functions

    //Q1
    private List<Integer> findClosestElements(int[] arr, int k, int x) {

        ArrayList<Integer> array = new ArrayList<>(arr.length);

        for (int i : arr)
        {
            array.add(i);
        }

        int totalElements = array.size();

        if(x <= arr[0]) {
            //first k elements are closest
            return array.subList(0,k);
        }
        else if(x >= arr[totalElements-1]) {
            //last k elements are closest
            return array.subList(totalElements-k, totalElements);
        }
        else {
            //find index of element >= x
            int index = Collections.binarySearch(array, x);

            if(index < 0) {
                index = -index-1;
            }

            //low will be on the left side
            int lowIndex = Math.max(0, index-k-1);

            //high will be on the right side
            int highIndex = Math.min(totalElements-1, index+k-1);

            while(highIndex-lowIndex > k-1) {

                if(lowIndex < 0 || (x-array.get(lowIndex)) <= (array.get(highIndex)-x)) {
                    highIndex--;
                }
                else if(highIndex > totalElements-1 || (x-array.get(lowIndex)) > (array.get(highIndex)-x)) {
                    lowIndex++;
                }
                else {
                    System.out.println("Case not handled - " + lowIndex + " , " + highIndex);
                }
            }

            return array.subList(lowIndex, highIndex+1);
        }
    }

    //Q2
    private int[] intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> setOfArr1 = new HashSet<>();

        for (int k : arr1) {
            setOfArr1.add(k);
        }

        HashSet<Integer> setOfArr2 = new HashSet<>();

        for (int k : arr2) {
            setOfArr2.add(k);
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
    private String reorganizeString(String S) {
        int[] hash = new int[26];

        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }

        int max = 0, letter = 0;

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }

        if (max > (S.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[S.length()];
        int idx = 0;

        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }

        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }

        return String.valueOf(res);
    }

    //Q5
    private int countNumberOfOnes(int[] arr, int low, int high) {
        if(low <= high) {
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
