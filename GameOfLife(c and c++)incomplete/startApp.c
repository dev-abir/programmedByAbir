#include <stdio.h>
#include "startApp.h"
#include <stdlib.h>
#include <time.h>

#define FILENAME "output.txt"
#define ALIVE 1
#define DEAD 0

int nR, nC, LENGTH, BREADTH, nGenerations, nInitialLiveCells;

int getCellIndex(int x, int y)
{
    return ((nR * x) + y);
}

void input()
{
    printf("Enter the number of cells along row(Do not input a very small value) : ");
    scanf("%d", &nR);
    printf("Enter the number of cells along column(Do not input a very small value) : ");
    scanf("%d", &nC);

    printf("Enter the number of generations : ");
    scanf("%d", &nGenerations);

    printf("Enter the length of the animation display screen(Do not input a very small value) : ");
    scanf("%d", &LENGTH);
    printf("Enter the breadth of the animation display screen(Do not input a very small value) : ");
    scanf("%d", &BREADTH);

    printf("\nBy default, the length will be the larger value.\n");

    if(BREADTH > LENGTH)
    {
        int temp = BREADTH;
        BREADTH = LENGTH;
        LENGTH = temp;
    }

    printf("Enter initial number of live cells : ");
    scanf("%d", &nInitialLiveCells);
}

int getScreenLength()
{
    return LENGTH;
}

int getScreenBreadth()
{
    return BREADTH;
}

//int a = nR, b = nC;

//struct cell cells[a][b];

void updateFile()
{

}

void display(int* cells)
{
    int i, j;
    for(i=0;i<nR;i++)
    {
        for(j=0;j<nC;j++)
        {
            printf("%c", ((cells[getCellIndex(i, j)] == ALIVE) ? 'A' : ' '));
        }
    }
}

int getNoOfLiveCellsNearby(int* cells, int posX, int posY)
{
    int result = 0;

    //In SFML, (0, 0) is the top-left corner.

    if(posX == 0)
    {
        if(posY == 0)
        {
            if(cells[getCellIndex(posX + 1, posY)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX + 1, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
        }
        else if(posY == (nC - 1))
        {
            if(cells[getCellIndex(posX + 1, posY)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX + 1, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
        }
        else
        {
            if(cells[getCellIndex(posX + 1, posY)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX + 1, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX + 1, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
        }
    }



    else if(posY == 0)
    {
        //if(posX == 0){}  //no need to check that (posX == 0), I have checked it earlier, i.e., if
        //(posX == 0) and (posY == 0)
        if(posX == (nC - 1))
        {
            if(cells[getCellIndex(posX - 1, posY)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
        }
        else
        {
            if(cells[getCellIndex(posX + 1, posY)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
        }
    }


    else if(posX == (nR - 1))
    {
        //if(posY == 0){}  //no need to check that (posY == 0), I have checked it earlier, i.e., if
        //(posY == 0) and (posX == (NUMBER_OF_CELLS_ALONG_ROW - 1))
        if(posY == (nC - 1))
        {
            if(cells[getCellIndex(posX, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
        }
        else
        {
            if(cells[getCellIndex(posX - 1, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
        }
    }


    else if(posY == (nC - 1))
    {
        //if(posX == 0){}  //no need to check that (posX == 0), I have checked it earlier, i.e., if
        //(posX == 0) and (posY == (nC - 1))
        if(posX == (nR - 1))
        {
            if(cells[getCellIndex(posX, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX + 1, posY)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY + 1)] == ALIVE)
            {
                result = result + 1;
            }
        }
        else
        {
            if(cells[getCellIndex(posX + 1, posY)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX - 1, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
            if(cells[getCellIndex(posX + 1, posY - 1)] == ALIVE)
            {
                result = result + 1;
            }
        }
    }


    else
    {
        if(cells[getCellIndex(posX + 1, posY)] == ALIVE)
        {
            result = result + 1;
        }
        if(cells[getCellIndex(posX - 1, posY)] == ALIVE)
        {
            result = result + 1;
        }
        if(cells[getCellIndex(posX, posY + 1)] == ALIVE)
        {
            result = result + 1;
        }
        if(cells[getCellIndex(posX, posY - 1)] == ALIVE)
        {
            result = result + 1;
        }
        if(cells[getCellIndex(posX + 1, posY - 1)] == ALIVE)
        {
            result = result + 1;
        }
        if(cells[getCellIndex(posX - 1, posY - 1)] == ALIVE)
        {
            result = result + 1;
        }
        if(cells[getCellIndex(posX - 1, posY + 1)] == ALIVE)
        {
            result = result + 1;
        }
        if(cells[getCellIndex(posX + 1, posY + 1)] == ALIVE)
        {
            result = result + 1;
        }
    }
    return result;
}

void actualProcess(int* initLiveCellsX, int* initLiveCellsY)
{
    int cells[nR * nC];

    int i, j;
    for(i=0; i<nR; i++)
    {
        for(j=0; j<nC; j++)
        {
            cells[getCellIndex(i, j)] = DEAD;
        }
    }
    for(i=0; i<nInitialLiveCells; i++)
    {
        cells[getCellIndex(i, j)] = ALIVE;
    }
    for(i=1; i<=nGenerations; i++)
    {
        for(i=0; i<nR; i++)
        {
            for(j=0; j<nC; j++)
            {
                if(cells[getCellIndex(i, j)] == ALIVE)
                {
                    if((getNoOfLiveCellsNearby(&cells, i, j) < 2) || (getNoOfLiveCellsNearby(&cells,i, j) > 3))
                    {
                        cells[getCellIndex(i, j)] = DEAD;
                    }
                    else
                    {
                        cells[getCellIndex(i, j)] = ALIVE;
                    }
                }
                else    //  If the cell is dead
                {
                    if(getNoOfLiveCellsNearby(&cells, i, j) == 3)
                    {
                        cells[getCellIndex(i, j)] = ALIVE;
                    }
                }
            }
        }
        display(&cells);
        //updateFile();
    }
}

void start()
{
    input();

    int initialLiveCellsX[nInitialLiveCells];
    int initialLiveCellsY[nInitialLiveCells];
    int i;
    srand(time(0)); //  Very essential statement, it prepares a "seed" for the creation
    //  of random numbers. If you do not use this function, then on every execution,
    //  the value of "rand()" will be same.
    for(i=0; i<nInitialLiveCells; i++)
    {
        initialLiveCellsX[i] = 0 + (rand() % nR);
    }
    for(i=0; i<nInitialLiveCells; i++)
    {
        initialLiveCellsY[i] = 0 + (rand() % nC);
    }

    actualProcess(&initialLiveCellsX, &initialLiveCellsY);
}
