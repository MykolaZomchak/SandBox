package patterns.behavioural.null_object;

import patterns.behavioural.null_object.nodes.Node;
import patterns.behavioural.null_object.nodes.NullNode;

public class NullObjectShowDown {

    public static void main(String[] agrs) {
        Node tree = new NullNode();
        System.out.println(tree.getSize());
        tree = new Node(new Node(new Node(new NullNode(), new NullNode()), new NullNode()), new Node(new NullNode(), new NullNode()));
        System.out.println(tree.getSize());
    }

}
