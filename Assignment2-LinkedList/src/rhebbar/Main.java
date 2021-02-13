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
        swapList.printList();

        //swap in pairs
        swapList.swapPairs();

        System.out.println("Swapped list : ");
        swapList.printList();

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
        list.printList();

        //delete
        list.deleteNode(list.getNodeWithData(3));

        System.out.println("List after deletion : ");
        list.printList();

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
        evenOddList.printList();

        evenOddList.oddEvenArrangement();

        System.out.println("List after rearranging : ");
        evenOddList.printList();

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */
        //Q4: Split linked list in parts
        System.out.println();
        System.out.println("QUESTION 4");

        //create a list
        LinkedList<Integer> splitList = new LinkedList<>();
        splitList.addTail(1);
        splitList.addTail(2);
        splitList.addTail(3);
        splitList.addTail(4);
        splitList.addTail(5);
        splitList.addTail(6);
        splitList.addTail(7);
        splitList.addTail(8);
        splitList.addTail(9);
        splitList.addTail(10);

        System.out.println("List before splitting: ");
        splitList.printList();

        System.out.println("List after splitting: ");

        //splitting and printing the list
        splitList.splitIntoParts(3);

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */
        //Q5: Insert in circular linked list
        System.out.println();
        System.out.println("QUESTION 5");

        //create list
        LinkedList<Integer> circularList = new LinkedList<>();
        circularList.addTail(3);
        circularList.addTail(4);
        circularList.addTail(1);

        //make circular
        circularList.makeListCircular();

        System.out.println("List before inserting new value: ");
        circularList.printCircularList();

        //getting a node from the list
        Node<Integer> pointerNode = circularList.getNodeWithData(3);

        //inserting a new value
        insertIntoSortedCircularList(circularList, pointerNode, 2);

        System.out.println("List after inserting new value: ");
        circularList.printCircularList();
    }

    public static void insertIntoSortedCircularList(LinkedList list, Node<Integer> node, Integer insertVal) {
        //check for empty list
        if(node == null) {
            //create list
            Node<Integer> insertNode = new Node<>(insertVal);
            list.head = insertNode;
            insertNode.next = list.head;

            return;
        }

        Node<Integer> temp = node;
        Node<Integer> front = node.next;

        while(temp.data > insertVal) {
            temp = temp.next;
            front = temp.next;
        }

        Node<Integer> insertNode = new Node<>(insertVal);
        temp.next = insertNode;
        insertNode.next = front;
    }
}
