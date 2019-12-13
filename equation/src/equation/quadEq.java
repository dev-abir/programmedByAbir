package equation;

import java.util.*;

public class quadEq
{

    public static void quadEq()
    {
        int flag = 0;
        String eq;
        Scanner sc = new Scanner(System.in);
        /**
         * Direction , how to use...
         */
        {
            System.out.println("Enter any equation:");
            System.out.println("The equation must contain 'x'...");
            System.out.println("The equation must be a correct one...");
            System.out.println("[At present in version '1.0' , power functions "
                    + "and bracket functions are unavailable , it may be available "
                    + "from the next version...]");
        }
        eq = sc.next();
        double val0, val1;
        System.out.println("Enter first value of x:");
        val0 = sc.nextDouble();
        System.out.println("Enter second value of x:");
        val1 = sc.nextDouble();
        String eq_copy = eq;
        while (true)
        {
            changeX ob1 = new changeX();
            eq = eq_copy;
            eq = ob1.changeX(eq, val0);
            format ob = new format();
            eq = ob.format(eq);
            System.out.println("Equation is = " + eq);
            checkBracket ob999 = new checkBracket();
            eq = ob999.checkBracket(eq);
            System.out.println("(After bracket function) Equation is = " + eq);
            calculation ob3 = new calculation();
            eq = ob3.main(eq);
            System.out.println("Equation is = " + eq);
            if (eq.equals("0.0"))
            {
                flag = flag + 1;
                System.out.println("If value of x will be " + val0 + " , then the "
                        + "equation will result in 0 (zero)");
                break;
            }
            else if (val0 == val1)
            {
                break;
            }
            val0 = val0 + 1.0;
        }
        if (flag == 0)
        {
            System.out.println("No relevant value of x found for which the "
                    + "equation will result in 0 (zero)");
        }
    }
}
