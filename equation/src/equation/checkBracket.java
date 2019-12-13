package equation;

public class checkBracket
{

    public static String checkBracket(String eq)
    {
        boolean first_bracket_is_there = false;
        boolean second_bracket_is_there = false;
        String s = eq, new_s, equ = "";
        int i, l = s.length(), j;
        int indexOfFirstBrac=0;
        int indexOfSecondBrac=0;
        for (i = 0; i < l; i++)
        {
            char ch = s.charAt(i);
            if (ch == '(')
            {
                first_bracket_is_there = true;
                indexOfFirstBrac=i;
                for (j = i; j < l; j++)
                {
                    char c = s.charAt(j);
                    if (c == ')')
                    {
                        second_bracket_is_there = true;
                        indexOfSecondBrac=j;
                        break;
                    }
                }
                equ = s.substring((i + 1), j);
            }
        }
        if ((first_bracket_is_there == true) && (second_bracket_is_there == true))
        {
            calculation ob = new calculation();
            System.out.println(indexOfFirstBrac);
            System.out.println(indexOfSecondBrac);  
            new_s = eq.substring(0,indexOfFirstBrac)+ob.main(equ)+eq.substring(indexOfSecondBrac+1);
        }
        else
        {
            new_s = eq;
        }
        return new_s;
    }
}
