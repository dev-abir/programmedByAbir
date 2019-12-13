package josephus;

import java.util.ArrayList;

/**
 *
 * @author Abir Ganguly
 */
public class Number {
    int indexOfTheManLeft;
    ArrayList<Integer> forHowManyMansArrayList;

    public Number(int index) {
        indexOfTheManLeft = index;
        this.forHowManyMansArrayList = new ArrayList<Integer>();
    }
    
    public void addToList(int numberOfMans){
        forHowManyMansArrayList.add(numberOfMans);
    }
    
    public void display(){
        if(!forHowManyMansArrayList.isEmpty()){
            System.out.println("\nIndex of man left = " + indexOfTheManLeft);
            System.out.println("For number of mans = " + forHowManyMansArrayList);
        }
        else{
            System.out.println("\nIndex of man left = " + indexOfTheManLeft + "List is empty.");
        }
    }
}
