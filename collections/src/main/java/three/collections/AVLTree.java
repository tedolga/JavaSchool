//package three.collections;
//
///**
// * Self-balancing Binary search Tree which uses “Adelson-Velsky and Landis” algorithm.
// *
// * @author Tedikova O.
// * @version 1.0
// */
//public class AVLTree<T> {
//
//    /**
//     * Left subtree of main tree
//     */
//    private AVLTree leftTree;
//
//    /**
//     * Right subtree of main tree
//     */
//    private AVLTree rightTree;
//
//    /**
//     * Value of the tree root
//     */
//    private T rootValue;
//
//    /**
//     * Size of the tree
//     */
//    private int size;
//
//    public AVLTree(AVLTree leftTree, AVLTree rightTree, T rootValue) {
//        this.leftTree = leftTree;
//        this.rightTree = rightTree;
//        this.rootValue = rootValue;
//    }
//
//    /**
//     * Adds new element with given value to the tree if there is no other element with the same value in that tree.
//     * If the depth of one of the subtrees differs from another more than on 2 elements, tree will be restructured and
//     * balanced.
//     *
//     * @param element value of the new element.
//     */
//    public void put(T element) {
//        if (put0(element)) {
//            size++;
//        }
//    }
//
//    /**
//     * Adds new element with given value to the tree if there is no other element with the same value in that tree.
//     * If the depth of one of the subtrees differs from another more than on 2 elements, tree will be restructured and
//     * balanced.
//     *
//     * @param element value of the new element.
//     * @return true, if element was added, false - otherwise.
//     */
//    private boolean put0(T element) {
//        Comparable<T> elementValue = (Comparable<T>) element;
//        boolean isAdded = false;
//        if (rootValue == null) {
//            rootValue = element;
//            isAdded = true;
//        } else if (elementValue.compareTo(rootValue) < 0) {
//            if (leftTree == null) {
//                leftTree = new AVLTree(null, null, null);
//            }
//            isAdded = leftTree.put0(element);
//        } else if (elementValue.compareTo(rootValue) > 0) {
//            if (rightTree == null) {
//                rightTree = new AVLTree(null, null, null);
//            }
//            isAdded = rightTree.put0(element);
//        }
//        if (getBalance() > 1) {
//            balance();
//        }
//        return isAdded;
//    }
//
//    /**
//     * Returns {@link three.collections.Vector} instance, containing all the elements of the tree according to their
//     * search order (INFIX_TRAVERSE).
//     *
//     * @return {@link three.collections.Vector} instance, containing all the elements of the tree according to their
//     *         search order
//     */
//    public Vector toVector() {
//        Vector vector = new Vector(size);
//        writeElement(vector, leftTree, rightTree, rootValue);
//        return vector;
//    }
//
//    public AVLTree getLeftTree() {
//        return leftTree;
//    }
//
//    public void setLeftTree(AVLTree leftTree) {
//        this.leftTree = leftTree;
//    }
//
//    public AVLTree getRightTree() {
//        return rightTree;
//    }
//
//    public void setRightTree(AVLTree rightTree) {
//        this.rightTree = rightTree;
//    }
//
//    public T getRootValue() {
//        return rootValue;
//    }
//
//    /**
//     * Returns the difference between left subtree depth and right subtree depth.
//     *
//     * @return difference between left subtree depth and right subtree depth.
//     */
//    public int getBalance() {
//        return Math.abs(getTreeDepth(rightTree) - getTreeDepth(leftTree));
//    }
//
//    /**
//     * Returns depth of given tree.
//     *
//     * @param tree tree
//     * @return depth of given tree, if given tree not equals to null, or zero - otherwise.
//     */
//    private static int getTreeDepth(AVLTree tree) {
//        return (tree != null) ? tree.getDepth() : 0;
//    }
//
//    /**
//     * Returns depth of the tree.
//     *
//     * @return max depth of the tree subtrees.
//     */
//    private int getDepth() {
//        return rootValue != null ? 1 + Math.max(getTreeDepth(leftTree), getTreeDepth(rightTree)) : 0;
//    }
//
//    /**
//     * Balances tree with usage of different rotations.
//     */
//    private void balance() {
//        if (getTreeDepth(rightTree) > getTreeDepth(leftTree)) {
//            leftRotation();
//        } else {
//            rightRotation();
//        }
//    }
//
//    /**
//     * Implements left rotation.
//     */
//    private void leftRotation() {
//        AVLTree rightSubTree = rightTree.getRightTree();
//        AVLTree leftSubTree = rightTree.getLeftTree();
//        if (getTreeDepth(rightSubTree) >= getTreeDepth(leftSubTree)) {
//            AVLTree newLeftTree = new AVLTree(leftTree, leftSubTree, rootValue);
//            rootValue = rightTree.rootValue;
//            setLeftTree(newLeftTree);
//            setRightTree(rightSubTree);
//        } else {
//            AVLTree newLeftTree = new AVLTree(leftTree, leftSubTree.getLeftTree(), rootValue);
//            AVLTree newRightTree = new AVLTree(leftSubTree.getRightTree(), rightSubTree, rightTree.rootValue);
//            rootValue = leftSubTree.rootValue;
//            setLeftTree(newLeftTree);
//            setRightTree(newRightTree);
//        }
//    }
//
//    /**
//     * Implements right rotation
//     */
//    private void rightRotation() {
//        AVLTree rightSubTree = leftTree.getRightTree();
//        AVLTree leftSubTree = leftTree.getLeftTree();
//        if (getTreeDepth(rightSubTree) <= getTreeDepth(leftSubTree)) {
//            AVLTree newRightTree = new AVLTree(rightSubTree, rightTree, rootValue);
//            rootValue = leftTree.getRootValue();
//            setLeftTree(leftSubTree);
//            setRightTree(newRightTree);
//        } else {
//            AVLTree newLeftTree = new AVLTree(leftSubTree, rightSubTree.getLeftTree(), leftTree.getRootValue());
//            AVLTree newRightTree = new AVLTree(rightSubTree.getRightTree(), rightTree, rootValue);
//            rootValue = rightSubTree.getRootValue();
//            setLeftTree(newLeftTree);
//            setRightTree(newRightTree);
//        }
//    }
//
//    /**
//     * Recursively writes to the vector left subtree elements, root value and then right subtree elements.
//     *
//     * @param vector    in which elements will be written.
//     * @param leftTree  left subtree
//     * @param rightTree right subtree
//     * @param rootValue root element value
//     */
//    private void writeElement(Vector vector, AVLTree leftTree, AVLTree rightTree, T rootValue) {
//        if (leftTree != null) {
//            writeElement(vector, leftTree.getLeftTree(), leftTree.getRightTree(), leftTree.getRootValue());
//        }
//        vector.addElement(rootValue);
//        if (rightTree != null) {
//            writeElement(vector, rightTree.getLeftTree(), rightTree.getRightTree(), rightTree.getRootValue());
//        }
//    }
//
//    /**
//     * Returns size of the tree
//     *
//     * @return size of the tree
//     */
//    public int getSize() {
//        return size;
//    }
//}
