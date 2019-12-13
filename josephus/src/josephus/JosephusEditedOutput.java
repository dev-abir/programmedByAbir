package josephus;

import java.util.*;

/**
 *
 * @author Abir Ganguly
 */
public class JosephusEditedOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n0, n1;
        System.out.print("Enter start n : ");
        n0 = sc.nextInt();
        System.out.print("Enter end n : ");
        n1 = sc.nextInt();
        for(int j=n0;j<=n1;j++){
            System.out.print(j);
            Man[] manArray = new Man[j];
            for(int i=0;i<j;i++){
                manArray[i] = new Man(i, (i==(j - 1)));
            }
            int thisIndex = 0;
            int toEatIndex = thisIndex + 1;
            while(true){
                while(true){
                    if(manArray[thisIndex].dead){
                        thisIndex = ((j - 1)==thisIndex)?0:(thisIndex + 1);
                    }
                    else{break;}
                }
                //System.out.println(thisIndex);
                toEatIndex = thisIndex;
                do
                {
                    toEatIndex = ((j - 1)==toEatIndex)?0:(toEatIndex + 1);
    //                if(manArray[manArray[thisIndex].nextIndex].dead){
    //                    toEatIndex = manArray[manArray[thisIndex].nextIndex].nextIndex;
    //                }
    //                else{
    //                    toEatIndex = manArray[thisIndex].nextIndex;
    //                    break;}
                }
                while(manArray[toEatIndex].dead);
                if(thisIndex==toEatIndex){
                    break;
                }
                else{
                    manArray[toEatIndex].dead = true;
                    thisIndex = toEatIndex;
                    //toEatIndex = ((n - 1)==toEatIndex)?0:(toEatIndex + 1);
                }
            }
            System.out.println(" " + (thisIndex + 1));
        }
        sc.close();
    }
}
