package rhebbar;

import java.util.*;

public class LinkedList<T> {
    public ListNode<T> head;

    private ListNode<T> tail;

    //Solution functions

    public boolean areConverging(ListNode n1, ListNode n2) {
        Set<ListNode> secondListNodes = new HashSet<ListNode>();

        while (n2 != null) {
            secondListNodes.add(n2);
            n2 = n2.next;
        }

        while (n1 != null) {

            if (secondListNodes.contains(n1)) {
                return true;
            }

            n1 = n1.next;
        }

        return false;
    }

    //Helper functions

    public void addToTail(T data) {
        ListNode<T> node = new ListNode<>(data);

        //if list is empty, node becomes head
        if(head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        tail = node;
    }
}
