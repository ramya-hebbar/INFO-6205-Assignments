package rhebbar;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */
        //Assignment Questions

        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();

        //Q1 - Merge in between links
        System.out.println("QUESTION 1 - Merge in between linked lists");

        LinkedList<Integer> mainList = new LinkedList<>();
        mainList.addTail(1);
        mainList.addTail(2);
        mainList.addTail(3);
        mainList.addTail(4);
        mainList.addTail(5);

        System.out.print("Main list : ");
        mainList.printList();

        LinkedList<Integer> mergeList = new LinkedList<>();
        mergeList.addTail(100);
        mergeList.addTail(101);
        mergeList.addTail(102);

        System.out.print("List to merge : ");
        mergeList.printList();

        mainList.mergeInBetween(2, 3, mergeList.head);

        System.out.print("Merged list : ");
        mainList.printList();

        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();

        //Q2 - Swap Nodes in link list
        System.out.println("QUESTION 2 - Swapping nodes in a linked list");

        LinkedList<Integer> swapList = new LinkedList<>();
        swapList.addTail(1);
        swapList.addTail(2);
        swapList.addTail(3);
        swapList.addTail(4);
        swapList.addTail(5);

        System.out.print("List before swapping elements : ");
        swapList.printList();

        int swapIndex = 2;

        System.out.println("Removing elements of value : " + swapIndex);
        swapList.swapNodesAtIndex(swapIndex);

        System.out.print("List after swapping elements : ");
        swapList.printList();

        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();

        //Q3 - Remove link list element
        System.out.println("QUESTION 3 - Remove linked list elements");

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addTail(1);
        linkedList.addTail(2);
        linkedList.addTail(6);
        linkedList.addTail(3);
        linkedList.addTail(6);
        linkedList.addTail(4);
        linkedList.addTail(5);
        linkedList.addTail(6);

        System.out.print("List before removing elements : ");
        linkedList.printList();

        int valueToRemove = 6;

        System.out.println("Removing elements of value : " + valueToRemove);
        linkedList.removeElementWithValue(valueToRemove);

        System.out.print("List after removing elements : ");
        linkedList.printList();

        System.out.println("Re-initializing list...");

        linkedList = new LinkedList<>();
        linkedList.addTail(1);
        linkedList.addTail(1);
        linkedList.addTail(1);

        System.out.print("List before removing elements : ");
        linkedList.printList();

        valueToRemove = 1;

        System.out.println("Removing elements of value : " + valueToRemove);
        linkedList.removeElementWithValue(valueToRemove);

        System.out.print("List after removing elements : ");
        linkedList.printList();

        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();

        //Q4 - Delete n nodes after m nodes
        System.out.println("QUESTION 4 - Delete N nodes after M nodes of a linked list");

        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();

        // Q5 - Design and implement a Double Link list
        System.out.println("QUESTION 5 - Design and implement a Double Linked List");

        DoubleLinkList<Integer> dll = new DoubleLinkList<>();

        System.out.println("Initialised a double linked list");
        System.out.print("Double linked list : ");
        dll.printList();

        //implementing functions addHead, addTail, size and printList
        System.out.println("Current size is : " + dll.sizeOfList());

        System.out.println("Adding to head...");
        dll.addToHead(1);
        System.out.print("Double linked list : ");
        dll.printList();

        System.out.println("Adding to head...");
        dll.addToHead(2);
        System.out.print("Double linked list : ");
        dll.printList();

        System.out.println("Adding to head...");
        dll.addToHead(3);
        System.out.print("Double linked list : ");
        dll.printList();

        System.out.println("Current size is : " + dll.sizeOfList());

        System.out.println("Adding to tail...");
        dll.addToTail(4);
        System.out.print("Double linked list : ");
        dll.printList();

        System.out.println("Adding to tail...");
        dll.addToTail(5);
        System.out.print("Double linked list : ");
        dll.printList();

        System.out.println("Adding to tail...");
        dll.addToTail(6);
        System.out.print("Double linked list : ");
        dll.printList();

        System.out.println("Current size is : " + dll.sizeOfList());
    }
}
