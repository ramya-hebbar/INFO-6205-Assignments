package rhebbar;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */

        //Question 1: Find out if a Tree is Balanced.

        System.out.println("Q1: Find out if a tree is balanced");
        BinaryTree<Integer> tree1 = new BinaryTree<>();
        tree1.root = generateTree1();

        System.out.print("Tree 1 -> ");
        if(tree1.checkIfTreeIsBalanced(tree1.root)) {
            System.out.println("Tree is balanced");
        }
        else {
            System.out.println("Tree is not balanced");
        }

        System.out.print("Tree 2 -> ");
        BinaryTree<Integer> tree2 = new BinaryTree<>();
        tree2.root = generateTree2();

        if(tree2.checkIfTreeIsBalanced(tree2.root)) {
            System.out.println("Tree is balanced");
        }
        else {
            System.out.println("Tree is not balanced");
        }

        System.out.print("Tree 3 -> ");
        BinaryTree<Integer> tree3 = new BinaryTree<>();

        if(tree3.checkIfTreeIsBalanced(tree3.root)) {
            System.out.println("Tree is balanced");
        }
        else {
            System.out.println("Tree is not balanced");
        }

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */

        //Question 2: Find Minimum depth of all the leaves in a tree.
        System.out.println("Q2: Find minimum depth of all the leaves in a tree");

        BinaryTree<Integer> minTree = new BinaryTree<>();
        minTree.root = createTree();
        System.out.println("Depth of the tree is : "+ minTree.findMinimumDepth(minTree.root));

        minTree.root = generateTree1();
        System.out.println("Depth of the tree is : "+ minTree.findMinimumDepth(minTree.root));

        minTree.root = generateTree2();
        System.out.println("Depth of the tree is : "+ minTree.findMinimumDepth(minTree.root));

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */

        //Question 3: Print all the leaves of a tree.
        System.out.println("Q3: Print all the leaves of a tree");

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();

        tree.printoutAllLeafNodes(tree.root);

        /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */

        //Question 4: Print sum of all the left leaves.
        System.out.println("Q4: Print sum of all the left leaves");

        BinaryTree<Integer> leafyTree = new BinaryTree<>();
        leafyTree.root = getTreeWithLeftLeaves();

        System.out.println("The sum of left leaves of this tree is : " + leafyTree.getSumOfLeftLeaves(leafyTree.root));
    }

    /*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */

    //Dataset for Question 1

    private static Node<Integer> generateTree1() {
        Node<Integer> root = new Node<>(3);

        root.leftChild = new Node<>(9);
        root.rightChild = new Node<>(20);

        root.rightChild.leftChild = new Node<>(15);
        root.rightChild.rightChild = new Node<>(7);

        return root;
    }

    private static Node<Integer> generateTree2() {
        Node<Integer> root = new Node<>(1);

        root.leftChild = new Node<>(2);
        root.rightChild = new Node<>(2);

        root.leftChild.leftChild = new Node<>(3);
        root.leftChild.rightChild = new Node<>(3);

        root.leftChild.leftChild.leftChild = new Node<>(4);
        root.leftChild.leftChild.rightChild = new Node<>(4);

        return root;
    }

    //Dataset for Question 2

    //Dataset for Question 3
    private static Node<Integer> createTree() {
        Node<Integer> root = new Node<>(1);

        root.leftChild = new Node<>(2);
        root.rightChild = new Node<>(3);

        root.leftChild.leftChild = new Node<>(4);
        root.leftChild.rightChild = new Node<>(5);
        root.rightChild.leftChild = new Node<>(6);
        root.rightChild.rightChild = new Node<>(7);

        root.leftChild.leftChild.leftChild = new Node<>(8);
        root.leftChild.rightChild.leftChild = new Node<>(9);
        root.rightChild.leftChild.rightChild = new Node<>(10);
        root.rightChild.rightChild.rightChild = new Node<>(11);

        return  root;
    }

    //Dataset for Question 4
    private static Node<Integer> getTreeWithLeftLeaves() {
        Node<Integer> root = new Node<>(1);

        root.leftChild = new Node<>(2);
        root.rightChild = new Node<>(3);

        root.rightChild.leftChild = new Node<>(4);
        root.rightChild.rightChild = new Node<>(5);

        return root;
    }
}
