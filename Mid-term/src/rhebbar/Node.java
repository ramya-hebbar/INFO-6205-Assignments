package rhebbar;

public class Node<T> {
    public T data;
    public Node<T> leftChild;
    public Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }
}
