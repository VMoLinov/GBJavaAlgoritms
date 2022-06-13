import java.util.Random;

public class Main {
    private static final int SIZE = 200;

    public static void main(String[] args) {
        Random random = new Random();
        Tree[] trees = new Tree[SIZE];
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree();
        }
        int[] deeps = new int[SIZE];
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 100; j++) {
                trees[i].insert(random.nextInt(200) - 100);
            }
            deeps[i] = trees[i].deep();
        }
        int count = 0;
        for (int deep : deeps) {
            if (deep > 0) {
                ++count;
            }
        }
        System.out.println(count);
    }

    public static class Tree {
        public static class TreeNode {

            private final int value;
            public TreeNode leftChild;
            public TreeNode rightChild;

            public TreeNode(int value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return String.format("TN(%d)", value);
            }
        }

        private TreeNode root;

        public Tree() {
            root = null;
        }

        public int deep() {
            if (root == null) return 0;
            return Math.abs(calcDeep(root.leftChild, 1) - calcDeep(root.rightChild, 1));
        }

        private int calcDeep(TreeNode current, int count) {
            if (current != null) {
                count++;
                calcDeep(current.leftChild, count);
                calcDeep(current.rightChild, count);
            }
            return count;
        }

        public void insert(int value) {
            TreeNode node = new TreeNode(value);
            if (root == null) {
                root = node;
            } else {
                TreeNode current = root;
                TreeNode parent;
                while (true) {
                    parent = current;
                    if (value < current.value) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = node;
                            return;
                        }
                    } else if (value > current.value) {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = node;
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public Integer find(int value) {
            TreeNode current = root;
            while (current.value != value) {
                if (value < current.value)
                    current = current.leftChild;
                else
                    current = current.rightChild;

                if (current == null)
                    return null;
            }
            return current.value;
        }

        private void inOrderTravers(TreeNode current) {
            if (current != null) {
                System.out.println(current);
                inOrderTravers(current.leftChild);
                inOrderTravers(current.rightChild);
            }
        }

        public void displayTree() {
            inOrderTravers(root);
        }

        public boolean delete(int value) {
            TreeNode curr = root;
            TreeNode prev = root;
            boolean isLeftChild = true;
            while (curr.value != value) {
                prev = curr;
                if (value < curr.value) {
                    isLeftChild = true;
                    curr = curr.leftChild;
                } else {
                    isLeftChild = false;
                    curr = curr.rightChild;
                }
                if (curr == null)
                    return false;
            }
            if (curr.leftChild == null && curr.rightChild == null) {
                if (curr == root) {
                    root = null;
                } else if (isLeftChild) {
                    prev.leftChild = null;
                } else {
                    prev.rightChild = null;
                }
            } else if (curr.rightChild == null) {
                if (isLeftChild) {
                    prev.leftChild = curr.leftChild;
                } else {
                    prev.rightChild = curr.leftChild;
                }
            } else if (curr.leftChild == null) {
                if (isLeftChild) {
                    prev.leftChild = curr.rightChild;
                } else {
                    prev.rightChild = curr.rightChild;
                }
            } else {
                TreeNode successor = getSuccessor(curr);
                if (curr == root) {
                    root = successor;
                } else if (isLeftChild) {
                    prev.leftChild = successor;
                } else {
                    prev.rightChild = successor;
                }
                successor.leftChild = curr.leftChild;
            }
            return true;
        }

        private TreeNode getSuccessor(TreeNode deleted) {
            TreeNode successorParent = deleted;
            TreeNode successor = deleted;
            TreeNode flag = deleted.rightChild;
            while (flag != null) {
                successorParent = successor;
                successor = flag;
                flag = flag.leftChild;
            }
            if (successor != deleted.rightChild) {
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = deleted.rightChild;
            }
            return successor;
        }
    }
}
