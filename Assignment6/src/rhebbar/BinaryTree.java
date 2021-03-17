package rhebbar;

public class BinaryTree<T> {
    public Node<T> root;

    public BinaryTree() {
        root = null;
    }

    //wrapper functions
    public void printTree(){

        if(this.root == null)
            return;

        printInPreOrder(this.root);
        System.out.println();
    }

    public boolean checkForSubtree(Node<T> mainTree, Node<T> subTree) {
        return isSubtree(mainTree, subTree);
    }

    //Solution functions
    //Q1

    private boolean isSubtree(Node<T> mainTree, Node<T> subTree) {
        return mainTree!=null &&
                ( isSameTree(mainTree, subTree) ||
                isSubtree(mainTree.leftChild, subTree) ||
                isSubtree(mainTree.rightChild, subTree) );
    }

    public boolean isSameTree(Node<T> node1, Node<T> node2) {
        if(node1 == null && node2 == null) {
            return true;
        }

        if(node1 == null || node2 == null) {
            return false;
        }

        return node1.data == node2.data &&
                isSameTree(node1.leftChild, node2.leftChild) &&
                isSameTree(node1.rightChild, node2.rightChild);
    }

    //helper functions

    private void printInPreOrder(Node<T> node){
        if(node != null){
            System.out.print(node.data + ", ");
            printInPreOrder(node.leftChild);
            printInPreOrder(node.rightChild);
        }
    }
}
