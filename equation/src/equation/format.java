package equation;

public class format
{

    public static String format(String eq)
    {
        String s = eq;
        while (true)
        {
            boolean flag = false;
            int l, i;
            l = s.length();
            for (i = 0; i < l; i++)
            {
                char ch = s.charAt(i);
                if (i != 0)
                {
                    if (ch == '+')
                    {
                        if (s.charAt(i - 1) == '+')
                        {
                            s = s.substring(0, (i - 1)) + "+" + s.substring(i + 1);
                            flag = true;
                            break;
                        }
                        else if (s.charAt(i - 1) == '-')
                        {
                            s = s.substring(0, (i - 1)) + "-" + s.substring(i + 1);
                            flag = true;
                            break;
                        }
                    }
                    else if (ch == '-')
                    {
                        if (s.charAt(i - 1) == '+')
                        {
                            s = s.substring(0, (i - 1)) + "-" + s.substring(i + 1);
                            flag = true;
                            break;
                        }
                        else if (s.charAt(i - 1) == '-')
                        {
                            s = s.substring(0, (i - 1)) + "+" + s.substring(i + 1);
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (flag == false)
            {
                break;
            }
        }
        return s;
    }
}
