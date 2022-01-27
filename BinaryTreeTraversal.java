package lab9.BinaryTreeAssignment.TreeAssignment;

public class BinaryTreeTraversal<E>{

    public static class Node<E>{
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data, Node<E> l, Node<E> r){
            this.data = data;
            this.left = l;
            this.right = r;
        }

        public Node(E data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node<E> root = null;
    private boolean addReturn = false;
    private int counterReturn = 0;

    public boolean add(E item){
        root = add(root, item);
        return addReturn;
    }

    public Node<E> add(Node<E> localRoot, E item){
        if (localRoot == null){
            addReturn = true;
            return new Node<>(item);
        }else{
            int comp = ((Integer)item).compareTo((Integer) localRoot.data);
            if (comp == 0) {
                addReturn = false;
                return localRoot;
            }else if (comp < 0){
                localRoot.left = add(localRoot.left, item);
                return localRoot;
            }else {
                localRoot.right = add(localRoot.right, item);
                return localRoot;
            }
        }
    }

    public void printInOrder(Node<E> node){
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    public void printPostOrder(Node<E> node){
        if (node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void printInOrder(){
        printInOrder(root);
    }

    public void printPreOrder(Node<E> node){
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printPostOrder(){
        printPostOrder(root);
    }

    public void printPreOrder(){
        printPreOrder(root);
    }

    public int leafCount(){
        return leafCount(root);
    }

    public int leafCount(Node<E> localRoot){
        if (localRoot == null)
            return 0;
        else if (localRoot.right == null && localRoot.left== null)
            return 1 + leafCount(localRoot.left) + leafCount(localRoot.right);
        else
            return 0 + leafCount(localRoot.left) + leafCount(localRoot.right);
    }

    public static void main(String[] args){
        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        tree.add(47);
        tree.add(43);
        tree.add(54);
        tree.add(58);
        tree.add(76);
        tree.add(71);
        tree.add(55);
        tree.add(45);

        tree.printInOrder();
        System.out.println();
        tree.printPreOrder();
        System.out.println();
        tree.printPostOrder();
        System.out.println(tree.leafCount());
    }
}
