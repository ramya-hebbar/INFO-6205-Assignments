package rhebbar;

public class LinkedList<T> {
    public ListNode<T> head;

    //wrapper functions
    public ListNode<T> reverseListInGroups(int k) {
        return reverseListInKGroup(head, k);
    }

    public void addTail(T data) {
        addToTail(data);
    }

    public void printList() {
        printLinkedList(head);
    }

    private ListNode<T> reverseListInKGroup(ListNode<T> head, int k) {
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        int counter = 0;
        ListNode<T> temp = head;

        //partitioning the list for k-groups
        while(counter < k && temp!=null) {
            temp = temp.next;
            counter++;
        }

        //check if counter within list
        if(counter == k) {
            //reverse partition
            ListNode<T> partialReverse = this.reverseList(head, k);

            //recursion call to act on second partition
            head.next = this.reverseListInKGroup(temp, k);

            //updated head
            return partialReverse;
        }

        return head;
    }

    //Helper functions

    private ListNode<T> reverseList(ListNode<T> head, int k) {

        ListNode<T> back = null;
        ListNode<T> mid = head;

        while(k > 0) {
            ListNode<T> front = mid.next;

            mid.next = back;
            back = mid;
            mid = front;

            k--;
        }

        return back;
    }

    private void addToTail(T data) {
        ListNode<T> node = new ListNode<>(data);

        //if list is empty, node becomes head
        if(head == null) {
            head = node;
            return;
        }

        //list not empty - traverse to the tail and add the new node
        ListNode<T> temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        //obtained tail node - add new node
        temp.next = node;
    }

    private void printLinkedList(ListNode<T> head) {
        ListNode<T> temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}
