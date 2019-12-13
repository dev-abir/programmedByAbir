package tic_tac_toe_gui;

public class computer_turn_calculator
{
	String ar[][];
	int computer_x;
	int computer_y;
	String player_symbol,computer_symbol;
	int mode;
	
	computer_turn_calculator(String the_board_array[][],String pl_symbol,String comp_symbol,int game_mode)
	{
		ar=the_board_array;
		player_symbol=pl_symbol;
		computer_symbol=comp_symbol;
		mode=game_mode;
		System.out.println("Mode = "+mode);
	}
	String[][] getResultantArray()
	{
		int i,j,l,c=0,position_of_first_turn_X=0,position_of_first_turn_Y=0;
		
		l=ar.length;
		
		//Finding whether the player has given only one turn or not...
		for(i=0;i<l;i++)
		{
			for(j=0;j<l;j++)
			{
				if(ar[i][j]==player_symbol)
				{
					c=c+1;
					position_of_first_turn_X=i;
					position_of_first_turn_Y=j;
				}
			}
		}
		if(c==1)
		{
			if(mode==1)
			{
				set_computer_choice_position_for_first_turn_for_easy_mode(position_of_first_turn_X,position_of_first_turn_Y);
			}
			else
			{
				set_computer_choice_position_for_first_turn_for_hard_mode(position_of_first_turn_X,position_of_first_turn_Y);
			}
		}
		//Finish finding whether the player has given only one turn or not...
		
		//For more than one turn...
		else
		{
			set_computer_choice_position();
		}
		
		ar[computer_x][computer_y]=computer_symbol;
		
		return ar;
	}
	
	void set_computer_choice_position()
	{
		int i,j,c_player=0,c_blank=0,blank_row_position=0,blank_column_position=0;
		boolean found=false;
		
		//Checking along every row...
		for(i=0;i<3;i++)
		{
			c_player=0;
			c_blank=0;
			for(j=0;j<3;j++)
			{
				if(ar[i][j].equals(player_symbol))
				{
					c_player=c_player+1;
				}
				else if(ar[i][j].equals(" "))
				{
					blank_row_position=i;
					blank_column_position=j;
					c_blank=c_blank+1;
				}
			}
			if((c_player==2)&&(c_blank==1))
			{
				computer_x=blank_row_position;
				computer_y=blank_column_position;
				found=true;
				break;
			}
		}
		//Finished checking along every row...
		
		if(found==false)
		{
			c_player=0;
			c_blank=0;
			//Checking along every column...
			for(i=0;i<3;i++)
			{
				c_player=0;
				for(j=0;j<3;j++)
				{
					if(ar[j][i].equals(player_symbol))
					{
						c_player=c_player+1;
					}
					else if(ar[j][i].equals(" "))
					{
						blank_row_position=j;
						blank_column_position=i;
						c_blank=c_blank+1;
					}
				}
				if((c_player==2)&&(c_blank==1))
				{
					computer_x=blank_row_position;
					computer_y=blank_column_position;
					found=true;
					break;
				}
			}
			//Finished checking along every column...
		}
		
		if(found==false)
		{
			c_player=0;
			c_blank=0;
			//Checking along diagonal (ar[0][0] to ar[2][2])...
			for(i=0;i<3;i++)
			{
				if(ar[i][i].equals(player_symbol))
				{
					c_player=c_player+1;
				}
				else if(ar[i][i].equals(" "))
				{
					
					blank_row_position	=	blank_column_position	=	i;
					
					c_blank=c_blank+1;
				}
			}
			if((c_player==2)&&(c_blank==1))
			{
				computer_x=blank_row_position;
				computer_y=blank_column_position;
				found=true;
			}
			//Finished checking along diagonal (ar[0][0] to ar[2][2])...
		}
		
		if(found==false)
		{
			c_player=0;
			c_blank=0;
			j=2;
			//Checking along diagonal (ar[0][2] to ar[2][0])...
			for(i=0;i<3;i++)
			{
				if(ar[i][i].equals(player_symbol))
				{
					c_player=c_player+1;
				}
				else if(ar[i][i].equals(" "))
				{
					blank_row_position=i;
					blank_column_position=j;
					c_blank=c_blank+1;
				}
				j=j-1;
			}
			if((c_player==2)&&(c_blank==1))
			{
				computer_x=blank_row_position;
				computer_y=blank_column_position;
				found=true;
			}
			//Finished checking along diagonal (ar[0][2] to ar[2][0])...
		}
		
		if(found==false)
		{
			while(true)
			{
				computer_x=getRandom(0,2);
				computer_y=getRandom(0,2);
				if(ar[computer_x][computer_y].equals(" "))
				{
					break;
				}
			}
		}
	}
	
	void set_computer_choice_position_for_first_turn_for_hard_mode(int i,int j)
	{
		if(ar[1][1].equals("_"))
		{
			computer_x=1;
			computer_y=1;
		}
		else
		{
			set_computer_choice_position_for_first_turn_for_easy_mode(i,j);
		}
	}
	
	void set_computer_choice_position_for_first_turn_for_easy_mode(int i,int j)
	{
		if((i==0)&&(j==0))
		{
			int temp_x[]= {0,1,1};
			int temp_y[]= {1,1,0};
			while(true)
			{
				int temp=getRandom(0,2);
				computer_x=temp_x[temp];
				computer_y=temp_y[temp];
				if(ar[computer_x][computer_y].equals(" "))
				{
					break;
				}
			}
		}
		if((i==0)&&(j==1))
		{
			int temp_x[]= {0,0,1};
			int temp_y[]= {0,2,1};
			while(true)
			{
				int temp=getRandom(0,2);
				computer_x=temp_x[temp];
				computer_y=temp_y[temp];
				if(ar[computer_x][computer_y].equals(" "))
				{
					break;
				}
			}
		}
		if((i==0)&&(j==2))
		{
			int temp_x[]= {0,1,1};
			int temp_y[]= {1,1,2};
			while(true)
			{
				int temp=getRandom(0,2);
				computer_x=temp_x[temp];
				computer_y=temp_y[temp];
				if(ar[computer_x][computer_y].equals(" "))
				{
					break;
				}
			}
		}
		if((i==1)&&(j==0))
		{
			int temp_x[]= {0,1,2};
			int temp_y[]= {0,1,0};
			while(true)
			{
				int temp=getRandom(0,2);
				computer_x=temp_x[temp];
				computer_y=temp_y[temp];
				if(ar[computer_x][computer_y].equals(" "))
				{
					break;
				}
			}
		}
		if((i==1)&&(j==1))
		{
			int temp_x[]= {0,0,0,1,1,2,2,2};
			int temp_y[]= {0,1,2,0,2,0,1,2};
			while(true)
			{
				int temp=getRandom(0,7);
				computer_x=temp_x[temp];
				computer_y=temp_y[temp];
				if(ar[computer_x][computer_y].equals(" "))
				{
					break;
				}
			}
		}
		if((i==1)&&(j==2))
		{
			int temp_x[]= {0,1,2};
			int temp_y[]= {2,1,2};
			while(true)
			{
				int temp=getRandom(0,2);
				computer_x=temp_x[temp];
				computer_y=temp_y[temp];
				if(ar[computer_x][computer_y].equals(" "))
				{
					break;
				}
			}
		}
		if((i==2)&&(j==0))
		{
			int temp_x[]= {1,1,2};
			int temp_y[]= {0,1,1};
			while(true)
			{
				int temp=getRandom(0,2);
				computer_x=temp_x[temp];
				computer_y=temp_y[temp];
				if(ar[computer_x][computer_y].equals(" "))
				{
					break;
				}
			}
		}
		if((i==2)&&(j==1))
		{
			int temp_x[]= {2,1,2};
			int temp_y[]= {0,1,2};
			while(true)
			{
				int temp=getRandom(0,2);
				computer_x=temp_x[temp];
				computer_y=temp_y[temp];
				if(ar[computer_x][computer_y].equals(" "))
				{
					break;
				}
			}
		}
		if((i==2)&&(j==2))
		{
			int temp_x[]= {1,1,2};
			int temp_y[]= {1,2,1};
			while(true)
			{
				int temp=getRandom(0,2);
				computer_x=temp_x[temp];
				computer_y=temp_y[temp];
				if(ar[computer_x][computer_y].equals(" "))
				{
					break;
				}
			}
		}
	}
	
	int getRandom(int min,int max)
	{
		int number;
        int range=(max-min)+1;
        number=((int)(Math.random()*range))+min;
        return number;
	}
}