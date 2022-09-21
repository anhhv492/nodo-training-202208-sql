package collection2;

public class TestNode {
    public void test(Node<?>node){
        while (node !=null){
            System.out.println("value is "+node.getValue()+"");
            node=node.next;
        }
    }

    public static void main(String[] args) {
        Node<String> root = new Node<>("Step 1");
        Node<String> root1 = new Node<>("Step 2");
        Node<String> root2 = new Node<>("Step 3");
        root.next=root1;
        root1.next=root2;
        TestNode testNode = new TestNode();
        testNode.test(root);
    }
}
