package rhebbar;

public class LinkedList <T>{
    public Node<T> head;

    //swap nodes in pairs
    public Node<T> swapPairs(Node<T> head) {
        //check for empty list
        if(head == null)
            return null;

        //check for 1 element
        if(head.next == null)
            return head;

        Node<T> temp = head.next;

        //taking head data into temp var
        T tempVal = head.data;

        //setting temp data to head
        head.data = temp.data;

        //setting head data to temp
        temp.data = tempVal;

        if(temp.next != null)
            swapPairs(temp.next);

        return head;
    }

    //delete a node
    public void deleteNode(Node<T> node) {
        if(node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }

    //odd even linked list
    public Node<T> arrangeInOddEvenFashion(Node<T> head) {
        //check for empty list
        if(head == null)
            return null;

        //check for 1 element
        if(head.next == null)
            return head;

        //assign temporary pointers
        Node<T> tempForOdd = head;
        Node<T> tempForEven = head.next;
        Node<T> evenHead = head.next;

        while(tempForEven != null && tempForEven.next != null) {
            //pointing odd to the next odd index
            tempForOdd.next = tempForEven.next;

            //moving the odd pointer
            tempForOdd = tempForOdd.next;

            //pointing even to the next even index
            tempForEven.next = tempForOdd.next;

            //moving the even pointer
            tempForEven = tempForEven.next;
        }

        //pointing the last odd node to the even head
        tempForOdd.next = evenHead;

        return head;
    }

    //split the array into parts
    public void splitListToParts(Node<T> root, int k) {
        int sizeOfList = size(root);

        int elementsPerPart = sizeOfList/k;

        int extraItemIndices = sizeOfList % k;

        Node<T>[] partsArray = new Node[k];

        for(int i=0; i<k; i++) {
            Node<T> headNode = root;

            int perPart = elementsPerPart;

            if(i < extraItemIndices) {
                perPart += 1;
            }

            for(int j=0; j<perPart - 1; j++) {
                if(root != null)
                    root = root.next;
            }

            if(root != null) {
                Node<T> prevNode = root;
                root = root.next;
                prevNode.next = null;
            }

            partsArray[i] = headNode;
        }

        //print the parts
        for (int i=0; i<k; i++) {
            Node<T> node = partsArray[i];

            if(node != null) {
                this.printLinkedList(node);
            }
            else {
                System.out.println("[]");
            }
        }
    }

    //helper functions

    public int size(Node<T> root) {
        int size = 0;
        Node<T> temp = root;

        while(temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public void printLinkedList(Node<T> head) {
        Node<T> temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public Node<T> getNodeWithData(T data) {
        Node<T> temp = head;

        while(temp != null) {
            if (data == temp.data) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
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


}
