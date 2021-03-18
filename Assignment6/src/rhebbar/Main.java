package rhebbar;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q1: Subtree of Another Tree
        System.out.println("Q1: Find out if a tree is a subtree of another");

        System.out.println("Pass 1: ");

        BinaryTree<Integer> t1 = new BinaryTree<>();
        t1.root = generateTree1ForQ1();

        System.out.print("Main tree is : ");
        t1.printTree();

        BinaryTree<Integer> s1 = new BinaryTree<>();
        s1.root = generateSubtree1ForQ1();

        System.out.print("Subtree is : ");
        s1.printTree();

        if(t1.checkForSubtree(t1.root,s1.root)) {
            System.out.println("It is a subtree");
        }
        else {
            System.out.println("It is not a subtree");
        }

        System.out.println("Pass 2: ");

        t1 = new BinaryTree<>();
        t1.root = generateTree2ForQ1();

        System.out.print("Main tree is : ");
        t1.printTree();

        s1 = new BinaryTree<>();
        s1.root = generateSubtree2ForQ1();

        System.out.print("Subtree is : ");
        s1.printTree();

        if(t1.checkForSubtree(t1.root,s1.root)) {
            System.out.println("It is a subtree");
        }
        else {
            System.out.println("It is not a subtree");
        }

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q2: Asteroid collision
        System.out.println("Q2: Find out the state of the asteroids after all collisions");

        System.out.println("Pass 1: ");

        int[] asteroids = {5,10,-5};
        System.out.print("Asteroids before collision: ");
        System.out.println(Arrays.toString(asteroids));

        System.out.print("Asteroids after collision: ");
        asteroids = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(asteroids));

        System.out.println("Pass 2: ");

        asteroids = new int[] {8, -8};
        System.out.print("Asteroids before collision: ");
        System.out.println(Arrays.toString(asteroids));

        System.out.print("Asteroids after collision: ");
        asteroids = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(asteroids));

        System.out.println("Pass 3: ");

        asteroids = new int[] {10,2,-5};
        System.out.print("Asteroids before collision: ");
        System.out.println(Arrays.toString(asteroids));

        System.out.print("Asteroids after collision: ");
        asteroids = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(asteroids));

        System.out.println("Pass 4: ");

        asteroids = new int[] {-2,-1,1,2};
        System.out.print("Asteroids before collision: ");
        System.out.println(Arrays.toString(asteroids));

        System.out.print("Asteroids after collision: ");
        asteroids = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(asteroids));

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q3: 3 Sum
        System.out.println("Q3: Find unique triplets in the input array which add up to 0");

        System.out.println("Pass 1: ");

        int[] triplets = {-1,0,1,2,-1,-4};
        System.out.println("Input array is: " + Arrays.toString(triplets));
        threeSum(triplets);

        System.out.println("Pass 2: ");

        triplets = new int[] {};
        System.out.println("Input array is: " + Arrays.toString(triplets));
        threeSum(triplets);

        System.out.println("Pass 3: ");

        triplets = new int[] {0};
        System.out.println("Input array is: " + Arrays.toString(triplets));
        threeSum(triplets);

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q4: Generate well-formed parentheses
        System.out.println("Q4: Generate all combinations of well-formed parentheses for n");

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q5: Reverse nodes in k-group
        System.out.println("Q5: Reverse nodes in k-group");

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addTail(1);
        linkedList.addTail(2);
        linkedList.addTail(3);
        linkedList.addTail(4);
        linkedList.addTail(5);

        System.out.println("Pass 1: ");

        System.out.println("List before reverse: ");
        linkedList.printList();

        int k = 2;

        System.out.println("Reversing in groups of " + k);
        linkedList.head = linkedList.reverseListInGroups(k);

        System.out.println("List after reverse: ");
        linkedList.printList();

        linkedList = new LinkedList<>();
        linkedList.addTail(1);
        linkedList.addTail(2);
        linkedList.addTail(3);
        linkedList.addTail(4);
        linkedList.addTail(5);
        linkedList.addTail(6);
        linkedList.addTail(7);
        linkedList.addTail(8);
        linkedList.addTail(9);
        linkedList.addTail(10);
        linkedList.addTail(11);

        System.out.println("Pass 2: ");

        System.out.println("List before reverse: ");
        linkedList.printList();

        k = 4;

        System.out.println("Reversing in groups of " + k);
        linkedList.head = linkedList.reverseListInGroups(k);

        System.out.println("List after reverse: ");
        linkedList.printList();

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////
    }

    //Solution functions

    //Q2
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids) {
            collides: {
                while(!stack.empty() &&
                        asteroid < 0 &&
                        stack.peek() > 0) {

                    //popping only if current asteroid is in the opposite direction to the topmost

                    if(stack.peek() < -asteroid) {
                        stack.pop();
                        continue;
                    }
                    else if(stack.peek() == -asteroid) {
                        stack.pop();
                    }

                    break collides;
                }

                stack.push(asteroid);
            }
        }

        int[] finalResult = new int[stack.size()];
        for(int i = finalResult.length-1; i>=0; i--) {
            finalResult[i] = stack.pop();
        }

        return finalResult;
    }

    //Q3
    public static void threeSum(int[] array) {
        Arrays.sort(array);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<array.length && array[i]<=0; i++) {
            if(i==0 || array[i-1] != array[i]) {
                twoSum(array, i, result);
            }
        }

        System.out.print("Valid triplets are: ");
        System.out.println(result);
    }

    public static void twoSum(int[] array, int i, List<List<Integer>> result) {
        int low = i+1;
        int high = array.length-1;

        while(low < high) {
            int sum = array[i] + array[low] + array[high];

            if(sum < 0) //need higher values - move to right
                low++;
            else if(sum > 0) //need lower values - move to left
                high--;
            else {
                result.add(Arrays.asList(array[i], array[low++], array[high--]));

                while(low<high && array[low] == array[low-1]) //advance to the right to find next unique triplets
                    low++;
            }
        }
    }

    //Helper functions
    public static void printSeparator() {
        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();
    }

    //Dataset functions
    //Q1
    private static Node<Integer> generateTree1ForQ1() {
        Node<Integer> root = new Node<>(3);

        root.leftChild = new Node<>(4);
        root.rightChild = new Node<>(5);

        root.leftChild.leftChild = new Node<>(1);
        root.leftChild.rightChild = new Node<>(2);

        return root;
    }

    private static Node<Integer> generateSubtree1ForQ1() {
        Node<Integer> root = new Node<>(4);

        root.leftChild = new Node<>(1);
        root.rightChild = new Node<>(2);

        return root;
    }

    private static Node<Integer> generateTree2ForQ1() {
        Node<Integer> root = new Node<>(3);

        root.leftChild = new Node<>(4);
        root.rightChild = new Node<>(5);

        root.leftChild.leftChild = new Node<>(1);
        root.leftChild.rightChild = new Node<>(2);

        root.leftChild.rightChild.leftChild = new Node<>(0);

        return root;
    }

    private static Node<Integer> generateSubtree2ForQ1() {
        Node<Integer> root = new Node<>(4);

        root.leftChild = new Node<>(1);
        root.rightChild = new Node<>(2);

        return root;
    }
}
