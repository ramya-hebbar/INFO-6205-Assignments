package rhebbar;

public class DoubleLinkList<T> {
    public Node_DLL<T> head;

    public void addToHead(T data) {
        Node_DLL node = new Node_DLL(data);

        if(head != null) {
            head.prev = node;
            node.next = head;
        }

        head = node;
    }

    public void addToTail(T data) {
        Node_DLL node = new Node_DLL(data);

        //check for empty list
        if(head == null) {
            head = node;
        }
        else {
            //traverse to the tail node
            Node_DLL temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
            node.prev = temp;
        }
    }

    public int sizeOfList() {
        if(head == null)
            return 0;

        Node_DLL temp = head;

        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        return size;
    }

    public void printList() {
        Node_DLL temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.print("NULL");
        System.out.println();
    }
}
