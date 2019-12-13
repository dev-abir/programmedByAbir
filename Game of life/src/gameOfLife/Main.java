package gameoflife;

import java.io.*;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Abir Ganguly
 */
public class Main
{

    public static int nR;
    public static int nC;
    public static int nInitAlive;
    public static int aliveX[];
    public static int aliveY[];
    public static int LENGTH;
    public static int BREADTH;
    public static int nLoops;
    public static int lengthOfEachCell;
    public static int breadthOfEachCell;
    public static Cell[][] cells;
    public static int loopCount = 0;
    public static final String FILE_PATH = "E:\\NETBEANS PROJECTS\\Game of life\\GameOfLife\\build\\classes\\gameoflife\\";
    public static final String FILE_NAME = "output.txt";
    public static FileWriter fw;
    public static BufferedWriter fbw;   //  fbw = File Buffered Writer.
    public static PrintWriter pw;

    public static void main(String[] args) throws IOException, SlickException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of cells along row (Do not make this value too much small): ");
        nR = Integer.valueOf(br.readLine());
        System.out.print("Enter the number of cells along column (Do not make this value too much small): ");
        nC = Integer.valueOf(br.readLine());

        System.out.print("Enter the number of cells to make alive : ");
        nInitAlive = Integer.valueOf(br.readLine());

        System.out.println("\nDo you want to enter the coordinates of the alive cells, or make it random?");
        System.out.println("Enter 1 to enter the coordinates of the alive cells manually.");
        System.out.println("Enter 2 to make the coordinates of the alive cells random.");
        System.out.print("Enter your choice : ");
        int choice = Integer.valueOf(br.readLine());

        aliveX = new int[nInitAlive];
        aliveY = new int[nInitAlive];

        switch (choice)
        {
            case 1:
                for (int i = 0; i < nInitAlive; i++)
                {
                    while (true)
                    {
                        System.out.print("\nEnter the alive cell " + (i + 1) + "'s X coordinate : ");
                        aliveX[i] = Integer.valueOf(br.readLine());
                        System.out.print("Enter the alive cell " + (i + 1) + "'s Y coordinate : ");
                        aliveY[i] = Integer.valueOf(br.readLine());
                        if (((aliveX[i] < nR) && (aliveX[i] >= 0)) && ((aliveY[i] < nC) && (aliveY[i] >= 0)))
                            break;
                        else
                            System.out.println("-------Coordinate must be within : " + nR + " X " + nC + ".-------");
                    }
                }
                break;
            case 2:
                System.out.println("\nThe system may generate same random numbers.");
                System.out.println("So, you may not get " + nInitAlive + " live cells.");
                for (int i = 0; i < nInitAlive; i++)
                {
                    aliveX[i] = getRandom(0, (nR - 1));
                    aliveY[i] = getRandom(0, (nC - 1));
                }
                break;
            default:
                System.out.println("Wrong choice.");
                br.close();
                System.exit(0);
        }
        System.out.println("\n\nDo you want fullscreen?");
        System.out.println("Enter 1 for Yes, and 2 for No");
        System.out.print("Enter your choice : ");
        choice = Integer.valueOf(br.readLine());
        boolean fullscreen = false;
        switch(choice)
        {
            case 1:
                fullscreen = true;
                break;
            case 2:
                fullscreen = false;
                System.out.print("\n\nEnter screen length (Do not make this value too much small): ");
                LENGTH = Integer.valueOf(br.readLine());
                System.out.print("Enter screen breadth (Do not make this value too much small): ");
                BREADTH = Integer.valueOf(br.readLine());
                System.out.println("\n\nBy default.... the length will be larger.\n");
                break;
            default:
                System.out.println("Wrong choice.");
                br.close();
                System.exit(0);
        }
        
        System.out.print("Enter FPS : ");
        int fps = Integer.valueOf(br.readLine());

        System.out.print("Enter number of generations : ");
        nLoops = Integer.valueOf(br.readLine());

        if (BREADTH > LENGTH)
        {
            int temp = LENGTH;
            LENGTH = BREADTH;
            BREADTH = temp;
        }

        lengthOfEachCell = LENGTH / nC;
        breadthOfEachCell = BREADTH / nR;

        cells = new Cell[nR][nC];

        initCells();

        initFile();
        
        for (int i = 1; i <= nLoops; i++)
        {

            loopCount = loopCount + 1;
            
            //displayDebug();   //  For debugging, or development purposes

            updateFile();

            CellManipulator cellManipulator = new CellManipulator(cells, nR, nC);

            cells = cellManipulator.updateCells();

        }
        br.close();
        pw.close();
        fbw.close();
        fw.close();
        new GraphicalAnimation(LENGTH, BREADTH, nR, nC, nLoops, fps, fullscreen).start();
    }

    static void initCells()
    {
        for (int i = 0; i < nR; i++)
        {
            for (int j = 0; j < nC; j++)
            {
                cells[i][j] = new Cell(false, lengthOfEachCell, breadthOfEachCell, i, j);
            }
        }
        //  Some cells will be alive at first:
        for (int i = 0; i < nInitAlive; i++)
        {
            cells[aliveX[i]][aliveY[i]].setAlive(true);
        }
    }
    
    static void displayDebug()
    {
        int i, j;

        System.out.println("\n\n-------------------------------------LOOP = " + loopCount + "---------------------------------------------");

        if (loopCount == 1)
            System.out.println("Initial generation\n\n");

        for (i = 0; i < nR; i++)
        {
            for (j = 0; j < nC; j++)
            {
                System.out.print((cells[i][j].isAlive()) ? "A" : " ");
            }
            System.out.println();
        }
    }

    static void initFile() throws IOException
    {
        /**
         *
         *
         * TODO : Need to do it, using binary file(Two files : output.bin and
         * output.txt)
         *
         *
         *
         */
        System.out.println("\n\n\n------------------------------------------Please wait... creating output.txt file...------------------------------------------");
        fw = new FileWriter(FILE_PATH + FILE_NAME);
        fbw = new BufferedWriter(fw);    //  fbw = File Buffered Writer
        pw = new PrintWriter(fbw);

        pw.println("LengthOfEachCell " + lengthOfEachCell);
        pw.println("BreadthOfEachCell " + breadthOfEachCell);
    }

    static void updateFile() throws IOException
    {
        System.out.println("Currently writing generation = " + loopCount + ".......");
        pw.println("LoopCount " + loopCount);
        int i, j;
        for (i = 0; i < nR; i++)
        {
            for (j = 0; j < nC; j++)
            {
                pw.print((cells[i][j].isAlive()) ? "1" : "0");
            }
            pw.println();
        }
    }

    static int getRandom(int min, int max)
    {
        return ((int) ((Math.random() * ((max - min) + 1)) + min));
    }
}
