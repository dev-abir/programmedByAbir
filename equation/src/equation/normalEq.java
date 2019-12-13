package equation;

import java.util.*;

public class normalEq
{

    public static void normalEq()
    {
        String eq;
        Scanner sc = new Scanner(System.in);
        /**
         * Direction , how to use...
         */
        {
            System.out.println("Enter any equation:");
            System.out.println("The equation must be a correct one...");
            System.out.println("[At present in version '1.0' , power functions "
                    + "and bracket functions are unavailable , it may be available "
                    + "from the next version...]");
        }
        eq = sc.next();
        format ob = new format();
        eq = ob.format(eq);
        System.out.println("Equation is = " + eq);
        checkBracket ob3 = new checkBracket();
        eq = ob3.checkBracket(eq);
        System.out.println("(After bracket function) Equation is = " + eq);
        calculation ob1 = new calculation();
        eq = ob1.main(eq);
        System.out.println("Equation is = " + eq);
    }
}
