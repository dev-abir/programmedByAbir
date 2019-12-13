package josephus;

/**
 *
 * @author Abir Ganguly
 */
public class Man {
    
    int thisIndex, nextIndex;
    boolean last, dead;
    
    Man(int thisIndex, boolean last){
        this.thisIndex = thisIndex;
        this.last = last;
        this.dead = false;
        if(last){
            nextIndex = 0;
        }
        else{
            nextIndex = thisIndex + 1;
        }
    }
}
