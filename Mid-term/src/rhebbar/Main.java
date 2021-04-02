package rhebbar;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Q1: Write a function to determine whether two singly-linked lists are converging.
        System.out.println("Question 1: ");

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addToTail(1);
        list1.addToTail(3);
        list1.addToTail(5);
        list1.addToTail(7);
        list1.addToTail(9);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addToTail(2);
        list2.addToTail(4);
        list2.addToTail(7);
        list2.addToTail(9);

        if(list1.areConverging(list1.head, list2.head)) {
            System.out.println("Lists are converging");
        }
        else {
            System.out.println("Lists are not converging");
        }

        //Time complexity:O(list1.size + list2.size)
        //Space complexity:

        printSeparator();

        //Q2: Print perimeter of a tree (in clock-wise order).
        //     Example : Expected output for the following tree should be : [1,3,7,14,13,11,10,9,8,4,2]

        System.out.println("Question 2: ");

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = populateTree();

        tree.perimeterOfTree();

        //Time complexity:O(n)
        //Space complexity: O(n)

        printSeparator();

        //Q3: Given a binary array, find the maximum number of consecutive 1s in this array.

        System.out.println("Question 3: ");

        int[] binArray = new int[]{0,1,0,1,1,0,1,1,1,0,0,0};
        System.out.println("Input array is : " + Arrays.toString(binArray));
        System.out.println("Max ones found are : " + getMaxConsecutiveOnes(binArray));

        //Time complexity: O(n)
        //Space complexity: O(1)

        printSeparator();

        //Q4: Given a sorted array ‘nums’ , return the first occurrence of an integer ‘x’.
        System.out.println("Question 4: ");

        int[] array = new int[]{2,4,4,4,6,7,7,7,8,9,9,9};

        int x = 7;
        int index = getIndex(array, x);
        if(index != -1) {
            System.out.println(x + " found at index " + index);
        }

        x = 1;
        index = getIndex(array, x);
        if(index != -1) {
            System.out.println(x + " found at index " + index);
        }

        //Time complexity: O(n)
        //Space complexity: O(1)

        printSeparator();
    }

    //Solution functions

    public static int getIndex(int[] nums, int x) {
        if(nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length-1;

        while(low < high) {
            int mid = (low+high)/2;

            if(nums[mid] == x)
                return mid;
            else if(x < nums[mid])
                high = mid-1;
            else
                low = mid+1;
        }

        System.out.println(x + " not found");
        return -1;
    }

    public static int getMaxConsecutiveOnes(int[] nums) {
        int countOnes = 0;
        int maxCount = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                // Found a 1 - increment
                countOnes ++;
            } else {
                // Find the maximum till now.
                maxCount = Math.max(maxCount, countOnes);

                // Reset count of 1.
                countOnes = 0;
            }
        }
        return Math.max(maxCount, countOnes);
    }

    //Helper functions

    private static Node<Integer> populateTree() {
        Node<Integer> root = new Node<>(1);

        root.leftChild = new Node<>(2);
        root.rightChild = new Node<>(3);

        root.leftChild.leftChild = new Node<>(4);
        root.leftChild.rightChild = new Node<>(5);
        root.rightChild.leftChild = new Node<>(6);
        root.rightChild.rightChild = new Node<>(7);

        root.leftChild.leftChild.leftChild = new Node<>(8);
        root.leftChild.leftChild.rightChild = new Node<>(9);
        root.leftChild.rightChild.leftChild = new Node<>(10);
        root.leftChild.rightChild.rightChild = new Node<>(11);

        root.rightChild.leftChild.rightChild = new Node<>(13);
        root.rightChild.rightChild.leftChild = new Node<>(14);

        return root;
    }

    public static void printSeparator() {
        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();
    }
}
