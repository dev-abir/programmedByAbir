package tic_tac_toe_gui;

//import java.util.*;

public class new_tic_tac_toe
{
	
	//static Scanner sc_for_strings=new Scanner(System.in);
	//static Scanner sc=new Scanner(System.in);
	
	String player_symbol,computer_symbol;
	static boolean player_has_won=false,computer_has_won=false,it_is_a_draw_match=false;
	//static int r_no,c_no;
	static int mode;
	
	String ar[][]=new String[3][3];	//The tic-tac-toe array...
	
	new_tic_tac_toe(String board[][], String computer_symbol, String player_symbol) {
		this.ar = board;
		this.computer_symbol = computer_symbol;
		this.player_symbol = player_symbol;
	}
	
	/**
	public static void main(String args[])
	{
		
		new_tic_tac_toe ob=new new_tic_tac_toe();
		
		ob.init_array();
		
		ob.display_information();
		
		while(true)
		{
			System.out.println("This game has two modes : EASY and HARD.");
			System.out.println("Enter 1 for EASY and 2 for HARD.");
			mode=sc.nextInt();
			if((mode==1)||(mode==2))
			{
				break;
			}
			else
			{
				System.out.println("Please enter 1 or 2.");
				System.out.println("Enter 1 for EASY and 2 for HARD.");
			}
		}
		
		while(true)
		{
			System.out.println("Enter player symbol: ('_' - is not allowed , as it is used in describing a blank)");
			player_symbol=sc_for_strings.nextLine();
			
			System.out.println("Enter computer symbol: ('_' - is not allowed , as it is used in describing a blank)");
			computer_symbol=sc_for_strings.nextLine();
			
			if((player_symbol.equals("_")) || (computer_symbol.equals("_")))
			{
				System.out.println("'_' - is a not allowed as it describes a blank space...");
				System.out.println("Try again!!!");
			}
			else
			{
				break;
			}
		}
		
		while((player_has_won==false)&&(computer_has_won==false)&&(it_is_a_draw_match==false))
		{
			//Getting row number and column number...
			while(true)
			{
				while(true)
				{
					System.out.println("Enter the row number:");
					System.out.println("1 TO 3 is allowed.");
					r_no=sc.nextInt();
					if((r_no<1)||(r_no>3))
					{
						System.out.println("1 TO 3 is allowed.");
						System.out.println("Try again!!!");
					}
					else
					{
						break;
					}
				}
				while(true)
				{
					System.out.println("Enter the column number:");
					System.out.println("1 TO 3 is allowed.");
					c_no=sc.nextInt();
					if((c_no<1)||(c_no>3))
					{
						System.out.println("1 TO 3 is allowed.");
						System.out.println("Try again!!!");
					}
					else
					{
						break;
					}
				}
				if(!((ar[r_no-1][c_no-1]).equals("_")))
				{
					System.out.println("The place is already occupied...");
					System.out.println("Try anywhere else...");
				}
				else
				{
					break;
				}
			}
			//Getting row number and column number is finished...
			
			//Decreasing r_no and c_no as array index starts from 0 and ends at 2...
			r_no=r_no-1;
			c_no=c_no-1;
			////Decreasing r_no and c_no is finished...
			
			ar[r_no][c_no]=player_symbol;
			
			System.out.println("Here is the board:");
			System.out.println("'_' - means blank , no one has put anything in it...");
			ob.display_array();
			
			player_has_won=ob.see_whether_player_has_won_or_not();
			
			
			it_is_a_draw_match=ob.see_whether_it_is_a_draw_match_or_not();
			
			
			
			System.out.println("Now it's computer's turn...");
			//A special classs has been designed just for giving the computer's turn(chaal)...
			computer_turn_calculator ob1=new computer_turn_calculator(ar,player_symbol,computer_symbol,mode);
			ar=ob1.getResultantArray();
			
			computer_has_won=ob.see_whether_computer_has_won_or_not();
			
			System.out.println("Now the board is:");
			ob.display_array();
		}
		if(player_has_won==true)
		{
			System.out.println("Congratulations!!!");
			System.out.println("You won the game!!!");
		}
		else if(computer_has_won==true)
		{
			System.out.println("You lost the game!!!");
			System.out.println("Better luck next time...");
		}
		else
		{
			System.out.println("It's a draw match!!!");
		}
	}
	*/
	
	void display_information()
	{
		System.out.println("------THE TIC TAC TOE GAME---------");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Programmed by Abir Ganguly");
		System.out.println("[This is a JAVA tic tac toe game Version 1.0 , (CUI only , intermideate or MEDIUM mode is not supported.)]");
		System.out.println("You are free to do anything with this game... but please include my name as the original author of this game.\n\n\n");
	}
	
	boolean see_whether_it_is_a_draw_match_or_not()
	{
		boolean flag=false;
		int i,j,c=0;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				if(ar[i][j].equals(" "))
				{
					c=c+1;
				}
			}
		}
		if(c==0)
		{
			flag=true;
		}
		return flag;
	}
	boolean see_whether_player_has_won_or_not()
	{
		boolean flag=false;
		
		int i,j,c=0;
		
		//Checking along every row...
		for(i=0;i<3;i++)
		{
			c=0;
			for(j=0;j<3;j++)
			{
				if(ar[i][j].equals(player_symbol))
				{
					c=c+1;
				}
			}
			if(c==3)
			{
				break;
			}
		}
		//Finished checking along every row...
		
		if(c==3)
		{
			flag=true;
		}
		
		//Checking along every column...
		for(i=0;i<3;i++)
		{
			c=0;
			for(j=0;j<3;j++)
			{
				if(ar[j][i].equals(player_symbol))
				{
					c=c+1;
				}
			}
			if(c==3)
			{
				break;
			}
		}
		//Finished checking along every column...
		
		if(c==3)
		{
			flag=true;
		}
		
		c=0;
		
		//Checking along diagonal (ar[0][0] to ar[2][2])...
		for(i=0;i<3;i++)
		{
			if(ar[i][i].equals(player_symbol))
			{
				c=c+1;
			}
		}
		//Finished checking along diagonal (ar[0][0] to ar[2][2])...
		
		if(c==3)
		{
			flag=true;
		}
		
		c=0;
		
		//Checking along diagonal (ar[0][2] to ar[2][0])...
		j=2;
		for(i=0;i<3;i++)
		{
			if(ar[i][j].equals(player_symbol))
			{
				c=c+1;
			}
			j=j-1;
		}
		//Finished checking along diagonal (ar[0][2] to ar[2][0])...
		
		if(c==3)
		{
			flag=true;
		}
		
		return flag;
	}
	boolean see_whether_computer_has_won_or_not()
	{
		boolean flag=false;
		
		int i,j,c=0;
		
		//Checking along every row...
		for(i=0;i<3;i++)
		{
			c=0;
			for(j=0;j<3;j++)
			{
				if(ar[i][j].equals(computer_symbol))
				{
					c=c+1;
				}
			}
			if(c==3)
			{
				break;
			}
		}
		//Finished checking along every row...
		
		if(c==3)
		{
			flag=true;
		}
		
		//Checking along every column...
		for(i=0;i<3;i++)
		{
			c=0;
			for(j=0;j<3;j++)
			{
				if(ar[j][i].equals(computer_symbol))
				{
					c=c+1;
				}
			}
			if(c==3)
			{
				break;
			}
		}
		//Finished checking along every column...
		
		if(c==3)
		{
			flag=true;
		}
		
		c=0;
		
		//Checking along diagonal (ar[0][0] to ar[2][2])...
		for(i=0;i<3;i++)
		{
			if(ar[i][i].equals(computer_symbol))
			{
				c=c+1;
			}
		}
		//Finished checking along diagonal (ar[0][0] to ar[2][2])...
		
		if(c==3)
		{
			flag=true;
		}
		
		c=0;
		
		//Checking along diagonal (ar[0][2] to ar[2][0])...
		j=2;
		for(i=0;i<3;i++)
		{
			if(ar[i][j].equals(computer_symbol))
			{
				c=c+1;
			}
			j=j-1;
		}
		//Finished checking along diagonal (ar[0][2] to ar[2][0])...
		
		if(c==3)
		{
			flag=true;
		}
		
		return flag;
	}
	
	/**
	void init_array()
	{
		int i,j;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				ar[i][j]="_";
			}
		}
	}
	*/
	
	void display_array()
	{
		int i,j;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				System.out.print(ar[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
