/**
 * @Author Abir Ganguly.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("-------TOWER OF HANOI PROGRAM-------");
        System.out.print("Enter the number of discs : ");
        n = sc.nextInt();
        Tower towerOfHanoi = new Tower(n);
        System.out.println("\nInitial setup : ");
        towerOfHanoi.displayTower();
        System.out.println("\n\n\n");
        int initialPositionOfLowestDisc = towerOfHanoi.getLowestDisc().getPeg().getPosition();
        int x = 1;
        while (initialPositionOfLowestDisc == towerOfHanoi.getLowestDisc().getPeg().getPosition()) {
            towerOfHanoi.changePeg(towerOfHanoi.getDiscOfWeight(x));
            //towerOfHanoi.displayTower();
            x++;
        }
    }
}
