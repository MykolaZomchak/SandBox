package patterns.behavioural.null_object.nodes;

public class Node {

    private Node right;
    private Node left;

    protected Node() {}

    public Node(Node right, Node left) {
            this.right = right;
            this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getSize(){
        return right.getSize() + left.getSize() + 1;
    }
}
