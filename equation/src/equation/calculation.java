package equation;

public class calculation
{

    static String s;
    static boolean flag = false;

    public static String main(String eq)
    {
        format ob1 = new format();
        flag = false;
        s = eq;
        while (true)
        {
            System.out.println(s);
            int l, i;
            l = s.length();
            for (i = 0; i < l; i++)
            {
                char ch = s.charAt(i);
                if (ch == '^')
                {
                    toThePower(i);
                    break;
                }
            }
            l = s.length();
            for (i = 0; i < l; i++)
            {
                char ch = s.charAt(i);
                if (ch == '/')
                {
                    divide(i);
                    break;
                }
            }
            l = s.length();
            for (i = 0; i < l; i++)
            {
                char ch = s.charAt(i);
                if (ch == '*')
                {
                    multiply(i);
                    break;
                }
            }
            l = s.length();
            for (i = 0; i < l; i++)
            {
                char ch = s.charAt(i);
                if (ch == '+')
                {
                    add(i);
                    break;
                }
            }
            l = s.length();
            for (i = 0; i < l; i++)
            {
                char ch = s.charAt(i);
                if (ch == '-')
                {
                    substract(i);
                    break;
                }
            }
            System.out.println(flag);
            if (flag == false)
            {
                break;
            }
            flag = false;
            ob1.format(s);
        }
        return s;
    }

    public static String add_extension(String s0, String s1)
    {
        String str;
        double a = Math.abs(Double.valueOf(s0));
        double b = Math.abs(Double.valueOf(s1));
        double answer = a + b;
        str = Double.toString(answer);
        return str;
    }

    public static String substract_extension(String s0, String s1)
    {
        String str;
        double a = Math.abs(Double.valueOf(s0));
        double b = Math.abs(Double.valueOf(s1));
        double answer = a - b;
        str = Double.toString(answer);
        return str;
    }

    public static String multiply_extension(String s0, String s1)
    {
        String str;
        double a = Math.abs(Double.valueOf(s0));
        double b = Math.abs(Double.valueOf(s1));
        double answer = a * b;
        str = Double.toString(answer);
        return str;
    }

    public static String divide_extension(String s0, String s1)
    {
        String str;
        double a = Math.abs(Double.valueOf(s0));
        double b = Math.abs(Double.valueOf(s1));
        double answer = a / b;
        str = Double.toString(answer);
        return str;
    }

    public static String toThePower_extension(String s0, String s1)
    {
        String str;
        double a = Math.abs(Double.valueOf(s0));
        double b = Math.abs(Double.valueOf(s1));
        double answer = Math.pow(a, b);
        str = Double.toString(answer);
        return str;
    }

    public static String extractS1(String s, int i)
    {
        boolean flag = false;
        String new_s = s;
        int j;
        int l = s.length();
        for (j = (i + 1); j < l; j++)
        {
            char ch = s.charAt(j);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                new_s = s.substring((i + 1), j);
                flag = true;
                break;
            }
        }
        if (flag != true)
        {
            new_s = s.substring(i + 1);
        }
        return new_s;
    }

    public static String extractS0(String s, int i)
    {
        boolean flag = false;
        String new_s = s;
        int j;
        int l = s.length();
        for (j = (i - 1); j >= 0; j--)
        {
            char ch = s.charAt(j);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                if (j != 0)
                {
                    new_s = s.substring((j + 1), i);
                    flag = true;
                    break;
                }
                else
                {
                    new_s = s.substring(0, i);
                    flag = true;
                    break;
                }
            }
        }
        if (flag != true)
        {
            new_s = s.substring(0, i);
        }
        return new_s;
    }

    public static int nextSymbolIndex(int preSymbolIndex, String s)
    {
        int a = preSymbolIndex + 1;
        int b = 0;
        int l, i;
        l = s.length();
        for (i = a; i < l; i++)
        {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                b = i;
                break;
            }
            else
            {
                b = l;//I am confused b=l or b=(l-1) ???
            }
        }
        return b;
    }

    public static void add(int i)
    {
        if (i != 0)
        {
            String s0 = extractS0(s, i);
            System.out.println("S0=" + s0);
            String s1 = extractS1(s, i);
            System.out.println("S1=" + s1);
            if (preSymbolIndex(i, s) == 0)
            {
                s = add_extension(s0, s1) + s.substring(nextSymbolIndex(i, s));
            }
            else
            {
                s = s.substring(0, (preSymbolIndex(i, s) + 1)) + add_extension(s0, s1) + s.substring(nextSymbolIndex(i, s));
            }
            System.out.println("S=" + s);
            flag = true;
        }
    }

    public static void substract(int i)
    {
        if (i != 0)
        {
            String s0 = extractS0(s, i);
            System.out.println("S0=" + s0);
            String s1 = extractS1(s, i);
            System.out.println("S1=" + s1);
            if (preSymbolIndex(i, s) == 0)
            {
                s = substract_extension(s0, s1) + s.substring(nextSymbolIndex(i, s));
            }
            else
            {
                s = s.substring(0, (preSymbolIndex(i, s) + 1)) + substract_extension(s0, s1) + s.substring(nextSymbolIndex(i, s));
            }
            System.out.println("S=" + s);
            flag = true;
        }
    }

    public static void multiply(int i)
    {
        String s0 = extractS0(s, i);
        System.out.println("S0=" + s0);
        String s1 = extractS1(s, i);
        System.out.println("S1=" + s1);
        if (preSymbolIndex(i, s) == 0)
        {
            s = multiply_extension(s0, s1) + s.substring(nextSymbolIndex(i, s));
        }
        else
        {
            s = s.substring(0, (preSymbolIndex(i, s) + 1)) + multiply_extension(s0, s1) + s.substring(nextSymbolIndex(i, s));
        }
        System.out.println("S=" + s);
        flag = true;
    }

    public static void divide(int i)
    {
        String s0 = extractS0(s, i);
        System.out.println("S0=" + s0);
        String s1 = extractS1(s, i);
        System.out.println("S1=" + s1);
        if (preSymbolIndex(i, s) == 0)
        {
            s = divide_extension(s0, s1) + s.substring(nextSymbolIndex(i, s));
        }
        else
        {
            s = s.substring(0, (preSymbolIndex(i, s) + 1)) + divide_extension(s0, s1) + s.substring(nextSymbolIndex(i, s));
        }
        System.out.println("S=" + s);
        flag = true;
    }

    public static void toThePower(int i)
    {
        String s0 = extractS0(s, i);
        System.out.println("S0=" + s0);
        String s1 = extractS1(s, i);
        System.out.println("S1=" + s1);
        if (preSymbolIndex(i, s) == 0)
        {
            s = toThePower_extension(s0, s1) + s.substring(nextSymbolIndex(i, s));
        }
        else
        {
            s = s.substring(0, (preSymbolIndex(i, s) + 1)) + toThePower_extension(s0, s1) + s.substring(nextSymbolIndex(i, s));
        }
        System.out.println("S=" + s);
        flag = true;
    }

    public static int preSymbolIndex(int i, String s)
    {
        int result = 0;
        int j;
        for (j = (i - 1); j > 0; j--)
        {
            char ch = s.charAt(j);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                result = j;
                break;
            }
            else
            {
                result = 0;
            }
        }
        return result;
    }
}
