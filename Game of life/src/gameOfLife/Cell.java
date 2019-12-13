package gameoflife;

/**
 *
 * @author Abir Ganguly
 */
public class Cell
{

    private boolean alive;
    private final int lengthOfCell;
    private final int breadthOfCell;
    private final int arrayPosX;
    private final int arrayPosY;
    private final int graphicalPosX;
    private final int graphicalPosY;

    Cell(boolean alive, int lengthOfCell, int breadthOfCell, int arrayPosX, int arrayPosY)
    {
        this.alive = alive;
        this.lengthOfCell = lengthOfCell;
        this.breadthOfCell = breadthOfCell;
        this.arrayPosX = arrayPosX;
        this.arrayPosY = arrayPosY;
        this.graphicalPosX = arrayPosX * lengthOfCell;
        this.graphicalPosY = arrayPosY * breadthOfCell;
    }

    public boolean isAlive()
    {
        return alive;
    }

    public int getWIDTH()
    {
        return lengthOfCell;
    }

    public int getHEIGHT()
    {
        return breadthOfCell;
    }

    public int getArrayPosX()
    {
        return arrayPosX;
    }

    public int getArrayPosY()
    {
        return arrayPosY;
    }

    public int getGraphicalPosX()
    {
        return graphicalPosX;
    }

    public int getGraphicalPosY()
    {
        return graphicalPosY;
    }

    public void setAlive(boolean flag)
    {
        this.alive = flag;
    }
}
