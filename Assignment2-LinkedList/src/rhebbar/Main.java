package rhebbar;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */
        //Q1: Swap Nodes in pairs
        System.out.println();
        System.out.println("QUESTION 1");

        //create a list
        LinkedList<Integer> swapList = new LinkedList<>();
        swapList.addTail(1);
        swapList.addTail(2);
        swapList.addTail(3);
        swapList.addTail(4);
        swapList.addTail(5);
        swapList.addTail(6);

        System.out.println("Original list : ");
        swapList.printLinkedList();

        //swap in pairs
        swapList.swapPairs(swapList.head);

        System.out.println("Swapped list : ");
        swapList.printLinkedList();

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */
        //Q2: Delete a node in the linked list
        System.out.println();
        System.out.println("QUESTION 2");

        //create a list
        LinkedList<Integer> list = new LinkedList<>();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);

        System.out.println("List before deletion : ");
        list.printLinkedList();

        //delete
        list.deleteNode(list.getNodeWithData(3));

        System.out.println("List after deletion : ");
        list.printLinkedList();

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */
        //Q3: Even-odd linked list
        System.out.println();
        System.out.println("QUESTION 3");

        //create a list
        LinkedList<Integer> evenOddList = new LinkedList<>();
        evenOddList.addTail(1);
        evenOddList.addTail(2);
        evenOddList.addTail(3);
        evenOddList.addTail(4);
        evenOddList.addTail(5);

        System.out.println("List before rearranging : ");
        evenOddList.printLinkedList();

        evenOddList.arrangeInOddEvenFashion(evenOddList.head);

        System.out.println("List after rearranging : ");
        evenOddList.printLinkedList();

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */
        //Q4: Split linked list in parts
        System.out.println();
        System.out.println("QUESTION 4");

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */
        //Q5: Insert in circular linked list
        System.out.println();
        System.out.println("QUESTION 5");

    }
}
