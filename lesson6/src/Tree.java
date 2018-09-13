public class Tree {
    private class TreeNode {
        private Cat c;
        private int n;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(Cat c) {
            this.c = c;
        }
        public TreeNode(int n) {
            this.n = n;
        }
        @Override
        public String toString() {
            return String.format("(I:%d, N:%s, A:%d)", c.id, c.name, c.age);
        }
    }

    TreeNode root;

    public Cat find(int age) {
        TreeNode current = root;
        while (current.c.age != age) {
            if (age < current.c.age)
                current = current.left;
            else
                current = current.right;

            if (current == null)
                return null;
        }
        return current.c;
    }

    public void insert(Cat c) {
        TreeNode node = new TreeNode(c);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode previous;
            while (true) {
                previous = current;
                if (c.age < current.c.age) {
                    current = current.left;
                    if (current == null) {
                        previous.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        previous.right = node;
                        return;
                    }
                }
            }
        }
    }
    
    public boolean isBalanced() {
        return isBalancedHelper(root);
    }
    
    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        if (node.right == null)
            return getHeight(node.left) + 1;
        if (node.left == null)
            return getHeight(node.right) + 1;
        
        return Math.max(getHeight(node.left),  getHeight(node.right)) + 1;
    }
    
    private boolean isBalancedHelper(TreeNode current) {
        if (current == null)
            return true;
        if (current.left == null && current.right == null)
            return true;
        
        int diff = Math.abs(getHeight(current.left) - getHeight(current.right));
    
        return isBalancedHelper(current.left) && isBalancedHelper(current.right) && diff <= 1;
    
    }
    
    public static Tree generateRandomTree() {
        Tree tree = new Tree();
        for (int i = 0; i < 10; i++) {
            tree.insert((int) (Math.round(Math.random()*200.00 - 100.00)));
        }
        return tree;
    }
    
    public void insert(int n) {
        TreeNode node = new TreeNode(n);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode previous;
            while (true) {
                previous = current;
                if (n < current.n) {
                    current = current.left;
                    if (current == null) {
                        previous.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        previous.right = node;
                        return;
                    }
                }
            }
        }
    }

    public void displayTree() {
        inOrderTravers(root);
    }

    private void inOrderTravers(TreeNode current) {
        if (current != null) {
            inOrderTravers(current.left);
            System.out.println(current);
            inOrderTravers(current.right);
        }
    }

    public boolean delete(int age) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.c.age != age) {
            parent = current;
            if (age < current.c.age) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null)
                return false;
        }

        //if node is a leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // if one successor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        }
        else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // if both successors exist
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;

            successor.left = current.left;
            successor.right = current.right;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode current = node.right;
        TreeNode s = node;
        TreeNode parent = node;
        while (current != null) {
            parent = s;
            s = current;
            current = current.left;
        }
        if (s != node.right) {
            parent.left = s.right;
        }
        return s;
    }
}
