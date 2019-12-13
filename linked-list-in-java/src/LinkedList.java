/*

Singly Linked List in java, created by Abir Ganguly.

*/

public class LinkedList {

    private Node firstNode;
    private int nNodes;

    public LinkedList(int[] dataArray) {
        Node preNode = new Node(dataArray[0], null);
        firstNode = preNode;
        nNodes = dataArray.length;
        for(int i = 1; i < nNodes; i++) {
            Node node = new Node(dataArray[i], null);
            preNode.setNextNode(node);
            preNode = node;
        }
    }

    public void display() {
        Node currentNode = firstNode;
        while(true) {
            if(currentNode == null) {
                break;
            }
            System.out.print(currentNode.getData() + ", ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    public void insert(int data, int index) {
        if((index >= 1) && (index <= nNodes)) {
            int i;
            Node currentNode = firstNode;
            for(i = 1; i <= nNodes; i++) {
                if(i == index) {
                    currentNode.setNextNode(new Node(data, currentNode.getNextNode()));
                    setNnodes(nNodes + 1);
                } else {
                    currentNode = currentNode.getNextNode();
                }
            }
        } else {
            System.err.println("Index should not exceed the number of nodes in the linked list.");
        }
    }

    private void setNnodes(int newNnodes) {
        this.nNodes = newNnodes;
    }

    private void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public void delete(int index) {
        if((index >= 1) && (index <= nNodes)) {
            int i;
            Node currentNode = firstNode;
            Node preNode = currentNode;
            if(index == 1) {
                setFirstNode(firstNode.getNextNode());
                setNnodes(nNodes - 1);
            }
            else {
                for(i = 1; i <= nNodes; i++) {
                    if(i == index) {
                        preNode.setNextNode(currentNode.getNextNode());
                        setNnodes(nNodes - 1);
                    } else {
                        preNode = currentNode;
                        currentNode = currentNode.getNextNode();
                    }
                }
            }
        } else {
            System.err.println("Index should not exceed the number of nodes in the linked list.");
        }
    }
}