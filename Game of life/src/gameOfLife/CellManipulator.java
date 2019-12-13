package gameoflife;

/**
 *
 * @author Abir Ganguly
 */
public class CellManipulator
{

    Cell[][] cells;
    int nR, nC;

    CellManipulator(Cell[][] cells, int numberOfRows, int numberOfColumns)
    {
        this.cells = cells;
        this.nR = numberOfRows;
        this.nC = numberOfColumns;
    }

    Cell[][] updateCells()
    {
        int i, j;
        for (i = 0; i < nR; i++)
        {
            for (j = 0; j < nC; j++)
            {
                if (cells[i][j].isAlive())
                    if ((getNoOfAliveCellsNearby(i, j) < 2) || (getNoOfAliveCellsNearby(i, j) > 3))
                        cells[i][j].setAlive(false);
                    else
                        cells[i][j].setAlive(true);
                else if (getNoOfAliveCellsNearby(i, j) == 3)
                    cells[i][j].setAlive(true);
            }
        }
        return cells;
    }

    private int getNoOfAliveCellsNearby(int arrayPosX, int arrayPosY)
    {
        int result = 0;

        //In Slick library, (0, 0) is the top-left corner.
        if (arrayPosX == 0)
            if (arrayPosY == 0)
            {
                if (cells[arrayPosX + 1][arrayPosY].isAlive())
                    result = result + 1;
                if (cells[arrayPosX][arrayPosY + 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX + 1][arrayPosY + 1].isAlive())
                    result = result + 1;
            } else if (arrayPosY == (nC - 1))
            {
                if (cells[arrayPosX + 1][arrayPosY].isAlive())
                    result = result + 1;
                if (cells[arrayPosX][arrayPosY - 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX + 1][arrayPosY - 1].isAlive())
                    result = result + 1;
            } else
            {
                if (cells[arrayPosX + 1][arrayPosY].isAlive())
                    result = result + 1;
                if (cells[arrayPosX][arrayPosY - 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX][arrayPosY + 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX + 1][arrayPosY + 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX + 1][arrayPosY - 1].isAlive())
                    result = result + 1;
            }

        else if (arrayPosY == 0)
            //if(arrayPosX == 0){}  //no need to check that (arrayPosX == 0), I have checked it earlier, i.e., if
            //(arrayPosX == 0) and (arrayPosY == 0)
            if (arrayPosX == (nR - 1))
            {
                if (cells[arrayPosX - 1][arrayPosY].isAlive())
                    result = result + 1;
                if (cells[arrayPosX][arrayPosY + 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY + 1].isAlive())
                    result = result + 1;
            } else
            {
                if (cells[arrayPosX + 1][arrayPosY].isAlive())
                    result = result + 1;
                if (cells[arrayPosX][arrayPosY + 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY + 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY + 1].isAlive())
                    result = result + 1;
            }

        else if (arrayPosX == (nR - 1))
            //if(arrayPosY == 0){}  //no need to check that (posY == 0), I have checked it earlier, i.e., if
            //(arrayPosY == 0) and (arrayPosX == (nR - 1))
            if (arrayPosY == (nC - 1))
            {
                if (cells[arrayPosX][arrayPosY - 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY - 1].isAlive())
                    result = result + 1;
            } else
            {
                if (cells[arrayPosX - 1][arrayPosY - 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX][arrayPosY + 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX][arrayPosY - 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY - 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY + 1].isAlive())
                    result = result + 1;
            }

        else if (arrayPosY == (nC - 1))
            //if(arrayPosX == 0){}  //no need to check that (posX == 0), I have checked it earlier, i.e., if
            //(arrayPosX == 0) and (arrayPosY == (nC - 1))
            if (arrayPosX == (nR - 1))
            {
                if (cells[arrayPosX][arrayPosY - 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX + 1][arrayPosY].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY + 1].isAlive())
                    result = result + 1;
            } else
            {
                if (cells[arrayPosX + 1][arrayPosY].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY].isAlive())
                    result = result + 1;
                if (cells[arrayPosX][arrayPosY - 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX - 1][arrayPosY - 1].isAlive())
                    result = result + 1;
                if (cells[arrayPosX + 1][arrayPosY - 1].isAlive())
                    result = result + 1;
            }

        else
        {
            if (cells[arrayPosX + 1][arrayPosY].isAlive())
                result = result + 1;
            if (cells[arrayPosX - 1][arrayPosY].isAlive())
                result = result + 1;
            if (cells[arrayPosX][arrayPosY + 1].isAlive())
                result = result + 1;
            if (cells[arrayPosX][arrayPosY - 1].isAlive())
                result = result + 1;
            if (cells[arrayPosX + 1][arrayPosY - 1].isAlive())
                result = result + 1;
            if (cells[arrayPosX - 1][arrayPosY - 1].isAlive())
                result = result + 1;
            if (cells[arrayPosX - 1][arrayPosY + 1].isAlive())
                result = result + 1;
            if (cells[arrayPosX + 1][arrayPosY + 1].isAlive())
                result = result + 1;
        }
        return result;
    }
}
