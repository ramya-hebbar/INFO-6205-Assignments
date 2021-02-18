package rhebbar;

public class Node_DLL<T> {
    public T data;
    public Node_DLL<T> prev;
    public Node_DLL<T> next;

    public Node_DLL(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
