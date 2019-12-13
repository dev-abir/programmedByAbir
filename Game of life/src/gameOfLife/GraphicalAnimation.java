package gameoflife;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Abir Ganguly
 */
public class GraphicalAnimation extends BasicGame
{
    
    String TITLE;
    int WIDTH;
    int HEIGHT;
    boolean fullscreen = false;
    int FPS;
    int nR;
    int nC;
    String lines[];
    int lengthOfEachCell;
    int breadthOfEachCell;
    int generation = 0;
    int nGenerations;
    FileReader fr;
    BufferedReader br;
    public final String FILE_PATH = "E:\\NETBEANS PROJECTS\\Game of life\\GameOfLife\\build\\classes\\gameoflife\\";
    public final String FILE_NAME = "output.txt";
    
    GraphicalAnimation(int WIDTH, int HEIGHT, int nR, int nC, int nGenerations, int FPS, boolean fullscreen) throws FileNotFoundException
    {
        super("Created by Abir Ganguly.");
        TITLE = "Created by Abir Ganguly.";
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.FPS = FPS;
        this.nR = nR;
        this.nC = nC;
        this.nGenerations = nGenerations;
        lines = new String[nR];
    }
    
    void start() throws SlickException, IOException
    {
        AppGameContainer gameContainer = new AppGameContainer(this);
        gameContainer.setDisplayMode(WIDTH, HEIGHT, fullscreen);
        fr = new FileReader(FILE_PATH + FILE_NAME);
        br = new BufferedReader(fr);
        String line;
        try
        {
            boolean canExitFromLoop = false;
            while((line = br.readLine()) != null)            
            {
                StringTokenizer st = new StringTokenizer(line);
                while(st.hasMoreTokens())
                {
                    String temp = st.nextToken();
                    if(temp.equals("LengthOfEachCell"))
                    {
                        lengthOfEachCell = Integer.valueOf(st.nextToken());
                    }
                    else if(temp.equals("BreadthOfEachCell"))
                    {
                        breadthOfEachCell = Integer.valueOf(st.nextToken());
                        canExitFromLoop = true;
                    }
                }
                if(canExitFromLoop)
                {
                    break;
                }
            }
        } catch (IOException ex)
        {
            System.err.println(ex);
        }
        gameContainer.start();
        freeResources();
    }
    
    @Override
    public void init(GameContainer gc) throws SlickException
    {
        gc.setTargetFrameRate(FPS);
        //gc.setVSync(true);
        String line;
        try
        {
            int x = 0;
            while((line = br.readLine()) != null)            
            {
                if(line.contains("LoopCount"))
                {
                    generation = Integer.valueOf(line.substring(line.indexOf(" ") + 1));
                    if(generation != 1)
                    {
                        break;
                    }
                }
                else
                {
                    for(int i=0;i<line.length();i++)
                    {
                        lines[x] = line;
                    }
                    x = x + 1;
                }
            }
        } catch (IOException ex)
        {
            System.err.println(ex);
        }
    }

    @Override
    public void update(GameContainer gc, int pmt) throws SlickException
    {
        /**
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * The below statements (Keyboard.is....) is not working.
         * 
         * 
         */
        
        
        
        
        
        
        
        
        
        
//        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
//        {
//            try
//            {
//                destroy();
//            } catch (IOException ex)
//            {
//                Logger.getLogger(GraphicalAnimation.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        String line;
        try
        {
            int x = 0;
            while((line = br.readLine()) != null)            
            {
                if(line.contains("LoopCount"))
                {
                    generation = Integer.valueOf(line.substring(line.indexOf(" ") + 1));
                    break;
                }
                else
                {
                    for(int i=0;i<line.length();i++)
                    {
                        lines[x] = line;
                    }
                    x = x + 1;
                }
            }
        } catch (IOException ex)
        {
            System.err.println(ex);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException
    {
        int i, j;
        for(i=0;i<nR;i++)
        {
            for(j=0;j<nC;j++)
            {
                if(lines[i].charAt(j) == '1')
                {
                    grphcs.setColor(Color.red);
                    grphcs.fillRect((j * lengthOfEachCell), (i * breadthOfEachCell), lengthOfEachCell, breadthOfEachCell);
                    grphcs.setLineWidth(0.1f);
                    grphcs.setColor(Color.orange);
                    grphcs.drawRect((j * lengthOfEachCell), (i * breadthOfEachCell), lengthOfEachCell, breadthOfEachCell);
                }
            }
        }
        grphcs.setColor(Color.green);
        String generationMessage = "Generation : " + Integer.toString(generation);
        grphcs.drawString(generationMessage, WIDTH - grphcs.getFont().getWidth(generationMessage), HEIGHT - grphcs.getFont().getHeight(generationMessage));
        grphcs.setColor(Color.black);
        if(generation == nGenerations)
        {
            try
            {
                exit(gc);
            } catch (IOException ex){}
        }
    }
    
    public void exit(GameContainer gc) throws IOException
    {
        System.out.println("\n\n\n*******PROGRAM ENDS*********");
        System.out.println("Program will exit within 3 seconds...");
        System.out.println("-------Created by Abir Ganguly.");
        gc.sleep(3000);
        freeResources();
        gc.exit();
        System.exit(0);
    }
    
    public void freeResources() throws IOException
    {
        br.close();
        fr.close();
    }
}
