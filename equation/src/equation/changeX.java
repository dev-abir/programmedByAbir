package equation;

public class changeX
{
    public static String changeX(String eq,double val0)
    {
        System.out.println("changeX");
        String s=eq;
        int l=s.length();
        int i;
        for(i=0;i<l;i++)
        {
            char ch=s.charAt(i);
            if(ch=='x')
            {
                s=s.substring(0,i)+Double.toString(val0)+s.substring((i+1));
            }
        }
        return s;
    }
}
