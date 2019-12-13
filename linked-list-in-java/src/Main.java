/*

Singly Linked List in java, created by Abir Ganguly.

*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, nNodes;
        while(true) {
        	System.out.print("Enter number of nodes : ");
        	nNodes = sc.nextInt();
        	if(nNodes < 2) {
        		System.out.println("Enter at least two elements.");
        	} else {
        		break;
        	}
        }
        int[] dataArray = new int[nNodes];
        System.out.println("Enter the data of linked list one by one:");
        for(i = 0; i < dataArray.length; i++) {
        	System.out.print("Enter data " + (i + 1) + " : ");
        	dataArray[i] = sc.nextInt();
        }
        LinkedList list = new LinkedList(dataArray);
        System.out.println("Linked list has been created successfully.");
        operations(list, sc);
    	sc.close();
    }

    private static void operations(LinkedList list, Scanner sc) {
    	int index;
    	showHelp();
    	while(true) {
	    	System.out.print("Enter your choice : ");
	    	int choice  = sc.nextInt();
	    	if(choice == 5) {
	    		break;
	    	}
	    	switch(choice) {

	    		case 1:
	    			list.display();
	    			break;

	    		case 2:
	    			System.out.print("Enter data to insert : ");
	    			int number = sc.nextInt();
	    			System.out.print("Enter index of the node at which to insert the number(index starts at 1, and insertion will be done after the index of the node to be entered) : ");
	    			index = sc.nextInt();
	    			list.insert(number, index);
	    			break;

	    		case 3:
	    			System.out.print("Enter index of the node to be deleted(index starts at 1) : ");
	    			index = sc.nextInt();
	    			list.delete(index);
	    			break;

	    		case 4:
	    			showHelp();
	    			break;

	    		default:
	    			System.out.println("Wrong choice! Try again.");
	    			break;
	    	}
	    }
    }

    private static void showHelp() {
    	System.out.println("Enter 1 to display linked list.");
    	System.out.println("Enter 2 to insert data into linked list.");
    	System.out.println("Enter 3 to delete data from linked list.");
    	System.out.println("Enter 4 to display this information(display help).");
    	System.out.println("Enter 5 to exit.");
    }
}