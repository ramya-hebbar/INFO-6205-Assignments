package rhebbar;

public class LinkedList<T> {
    public Node<T> head;

    //wrapper functions

    public void mergeInBetween(int startIndex, int endIndex, Node<T> list2) {
        mergeInBetweenLists( startIndex, endIndex, list2);
    }

    public void swapNodesAtIndex(int index) {
        swapNodesFromListAtIndex(index);
    }

    public void removeElementWithValue(T value) {
        removeFromListElementValued(value);
    }

    public void deleteNodes(int numberOfNodesToSkip, int numberOfNodesToDelete) {
        deleteNodesFromList(head, numberOfNodesToSkip, numberOfNodesToDelete);
    }

    //helper functions
    public void printList() {
        printLinkedList(head);
    }

    public void addTail(T data) {
        Node<T> node = new Node<>(data);

        //if list is empty, node becomes head
        if(head == null) {
            head = node;
            return;
        }

        //list not empty - traverse to the tail and add the new node
        Node<T> temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        //obtained tail node - add new node
        temp.next = node;
    }

    //private functions
    private void printLinkedList(Node<T> head) {
        Node<T> temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    private void mergeInBetweenLists(int a, int b, Node<T> list2) {

        //check for empty lists
        if(head == null || list2 == null)
            return;

        Node<T> startIndex = head;

        int index = 0;

        //traverse pointer to a-1 index
        while(startIndex.next != null && index++ != a-1) {
            startIndex = startIndex.next;
        }

        Node<T> endIndex = startIndex.next;

        //traverse pointer to b index
        while(endIndex.next != null && ++index < b+1) {
            endIndex = endIndex.next;
        }


        //point list1 to list2
        startIndex.next = list2;

        //get tail of list2
        while(list2.next != null) {
            list2 = list2.next;
        }

        //point tail of list2 to next index of list1
        list2.next = endIndex.next;
    }

    private void swapNodesFromListAtIndex(int k) {
        //check if list is empty
        if(head == null)
            return;

        Node<T> swapHead = head;
        int index = 1;

        //traversing pointer to desired index from head
        while(swapHead != null && index++ != k) {
            swapHead = swapHead.next;
        }

        Node<T> swapTail = head;
        Node<T> tail = swapHead;

        //traversing pointer to desired index from tail
        while(tail.next != null) {
            tail = tail.next;
            swapTail = swapTail.next;
        }

        T temp = swapHead.data;
        swapHead.data = swapTail.data;
        swapTail.data = temp;
    }

    private void removeFromListElementValued(T val) {
        //check for empty list
        if(head == null)
            return;

        //check and delete items in the list
        Node<T> lead = head;
        Node<T> trail = head;

        if(lead.next != null)
            lead = lead.next;

        while(lead != null) {
            if(lead.data == val) {
                lead = lead.next;
                trail.next = lead;
            }
            else {
                lead = lead.next;
                trail = trail.next;
            }
        }

        //check if head holds a value to be deleted and update head if needed
        if(head.data == val)
            head = head.next;
    }

    private void deleteNodesFromList(Node<T> head, int m, int n) {
        //check for empty list
        if(head == null)
            return;

        Node<T> temp = head;
        int startIndex = 1;

        while(temp.next != null && startIndex++ != m) {
            temp = temp.next;
        }

        //check if pointer is at end of list
        if(temp.next != null) {
            Node<T> removeNode = temp.next;
            int removeCount = 1;

            while(removeNode.next != null && removeCount++ != n) {
                removeNode = removeNode.next;
            }

            if(removeNode.next != null) {
                temp.next = removeNode.next;
                temp = removeNode.next;
                deleteNodesFromList(temp, m, n);
            }
            else {
                temp.next = null;
            }
        }
    }
}