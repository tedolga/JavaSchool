package three.collections;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class AVLTree {
    private AVLTree leftTree;
    private AVLTree rightTree;
    private Integer rootValue;

    public AVLTree(AVLTree leftTree, AVLTree rightTree, Integer rootValue) {
        this.leftTree = leftTree;
        this.rightTree = rightTree;
        this.rootValue = rootValue;
    }

    public void put(Integer element) {
        if (rootValue == null) {
            rootValue = element;
        } else if (element < rootValue) {
            if (leftTree != null) {
                leftTree.put(element);
            } else {
                leftTree = new AVLTree(null, null, element);
            }
        } else if (element > rootValue) {
            if (rightTree != null) {
                rightTree.put(element);
            } else {
                rightTree = new AVLTree(null, null, element);
            }
        }
        if (getBalance() > 1) {
            balance();
        }
    }


    public AVLTree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(AVLTree leftTree) {
        this.leftTree = leftTree;
    }

    public AVLTree getRightTree() {
        return rightTree;
    }

    public void setRightTree(AVLTree rightTree) {
        this.rightTree = rightTree;
    }

    public Integer getRootValue() {
        return rootValue;
    }

    public int getBalance() {
        return Math.abs(getTreeDepth(rightTree) - getTreeDepth(leftTree));
    }

    private static int getTreeDepth(AVLTree tree) {
        return (tree != null) ? tree.getDepth() : 0;
    }

    private int getDepth() {
        if (rootValue != null) {
            return 1 + Math.max(getTreeDepth(leftTree), getTreeDepth(rightTree));
        } else {
            return 0;
        }
    }

    private void balance() {
        if (getTreeDepth(rightTree) > getTreeDepth(leftTree)) {
            leftRotation();
        } else {
            rightRotation();
        }
    }

    private void leftRotation() {
        AVLTree rightSubTree = rightTree.getRightTree();
        AVLTree leftSubTree = rightTree.getLeftTree();
        if (getTreeDepth(rightSubTree) >= getTreeDepth(leftSubTree)) {
            AVLTree newLeftTree = new AVLTree(leftTree, leftSubTree, rootValue);
            rootValue = rightTree.rootValue;
            setLeftTree(newLeftTree);
            setRightTree(rightSubTree);
        } else {
            AVLTree newLeftTree = new AVLTree(leftTree, leftSubTree.getLeftTree(), rootValue);
            AVLTree newRightTree = new AVLTree(leftSubTree.getRightTree(), rightSubTree, rightTree.getRootValue());
            rootValue = leftSubTree.getRootValue();
            setLeftTree(newLeftTree);
            setRightTree(newRightTree);
        }

    }

    private void rightRotation() {
        AVLTree rightSubTree = leftTree.getRightTree();
        AVLTree leftSubTree = leftTree.getLeftTree();
        if (getTreeDepth(rightSubTree) <= getTreeDepth(leftSubTree)) {
            AVLTree newRightTree = new AVLTree(rightSubTree, rightTree, rootValue);
            rootValue = leftTree.getRootValue();
            setLeftTree(leftSubTree);
            setRightTree(newRightTree);
        } else {
            AVLTree newLeftTree = new AVLTree(leftSubTree, rightSubTree.getLeftTree(), leftTree.getRootValue());
            AVLTree newRightTree = new AVLTree(rightSubTree.getRightTree(), rightTree, rootValue);
            rootValue = rightSubTree.getRootValue();
            setLeftTree(newLeftTree);
            setRightTree(newRightTree);
        }
    }

}
