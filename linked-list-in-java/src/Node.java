/*

Singly Linked List in java, created by Abir Ganguly.

*/

public class Node {
    private int data;
    private Node nextNode;
    public Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }
    public void setData(int data) {this.data = data;}
    public int getData() {return data;}
    public void setNextNode(Node nextNode) {this.nextNode = nextNode;}
    public Node getNextNode() {return nextNode;}
}
