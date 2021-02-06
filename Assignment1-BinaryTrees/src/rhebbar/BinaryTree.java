package rhebbar;

public class BinaryTree<T> {
    public Node<T> root;

    public BinaryTree() {
        root = null;
    }

    //wrapper functions
    //Q1
    public boolean checkIfTreeIsBalanced(Node<T> root) {
        return isTreeBalanced(root);
    }

    //Q2
    public int findMinimumDepth(Node<T> root) {
        return getMinimumDepthOfTree(root);
    }
    //Q3
    public void printoutAllLeafNodes(Node<T> root) {
        printAllLeafNodes(root);
    }

    //Q4
    public int getSumOfLeftLeaves(Node<Integer> root) {
        return finalSumOfLeftLeaves(root);
    }

    //private functions

    private boolean isTreeBalanced(Node<T> root) {
        if(root == null)
            return true;

        int differenceInHeight = getTreeHeight(root.leftChild) - getTreeHeight(root.rightChild);

        if(Math.abs(differenceInHeight) > 1)
            return false;
        else
            return (isTreeBalanced(root.leftChild) && isTreeBalanced(root.rightChild));
    }

    private int getTreeHeight(Node<T> root) {
        if(root == null)
            return 0;

        int leftSide = getTreeHeight(root.leftChild);
        int rightSide = getTreeHeight(root.rightChild);

        return 1 + Math.max(leftSide, rightSide);
    }

    private int getMinimumDepthOfTree(Node<T> root) {
        if(root == null)
            return 0;

        //checking for a leaf
        if(root.leftChild == null && root.rightChild == null)
            return 1;

        //checking others
        if(root.leftChild == null) {
            return 1 + getMinimumDepthOfTree(root.rightChild);
        }
        else if(root.rightChild == null) {
            return 1 + getMinimumDepthOfTree(root.leftChild);
        }

        // adding 1 for root
        return 1 + Math.min(getMinimumDepthOfTree(root.rightChild), getMinimumDepthOfTree(root.leftChild));
    }

    private void printAllLeafNodes(Node<T> root) {
        if(root == null)
            return;

        if(root.leftChild == null && root.rightChild == null) {
            System.out.println(root.data);
            return;
        }

        if(root.leftChild != null)
            printAllLeafNodes(root.leftChild);

        if(root.rightChild != null)
            printAllLeafNodes(root.rightChild);
    }

    private int finalSumOfLeftLeaves(Node<Integer> root) {
        if(root == null)
            return 0;

        Integer finalSum = 0;

        if(root.leftChild != null) {
            //check for leaf node
            if(root.leftChild.leftChild == null && root.leftChild.rightChild == null) {
                finalSum += root.leftChild.data;
            }
            else {
                finalSum += finalSumOfLeftLeaves(root.leftChild);
            }
        }

        finalSum += finalSumOfLeftLeaves(root.rightChild);

        return finalSum;
    }
}
