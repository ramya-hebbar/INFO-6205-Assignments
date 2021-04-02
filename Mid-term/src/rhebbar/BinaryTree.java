package rhebbar;

import java.util.Stack;

public class BinaryTree<T> {
    public Node<T> root;

    public void perimeterOfTree() {
        Stack<Integer> stack = new Stack<>();

        printPerimeter(root, 0, 0, stack);

        while(stack.size() > 0) {
            System.out.println(stack.pop() + ", ");
        }
    }
    
    private void printPerimeter(Node<T> node, int left, int right, Stack<Integer> resultStack) {
        if(node != null) {

            //check for leaf
            if(node.leftChild == null && node.rightChild == null) {
                System.out.print(node.data + ", ");
            }
            else {
                if(left == 0) {
                    System.out.print(node.data + ", ");
                }
                if(right == 0) {
                    resultStack.push((Integer) node.data);
                }
            }
            printPerimeter(node.leftChild, left+1, right, resultStack);
            printPerimeter(node.rightChild, left, right+1, resultStack);
        }
    }
}
