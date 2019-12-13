package equation;

import java.util.*;

public class main
{

    public static void main(String args[])
    {
        int ch;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for normal equation:");
        System.out.println("Enter 2 for Quadriatic equation:");
        System.out.println("Enter your choice:");
        ch = sc.nextInt();
        if (ch == 1)
        {
            normalEq ob = new normalEq();
            ob.normalEq();
        }
        if (ch == 2)
        {
            quadEq ob = new quadEq();
            ob.quadEq();
        }
    }
}
