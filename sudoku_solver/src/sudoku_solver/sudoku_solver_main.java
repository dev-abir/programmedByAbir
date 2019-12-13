package sudoku_solver;

import java.util.*;

public class sudoku_solver_main {

	static String sudoku_board[][] = new String[9][9];
	static int l=9;
	static blank blank_objects_array[];
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("///////SUDOKU SOLVER//////");
		System.out.println(".................................Created by - Abir Ganguly.");
		int i, j;
		/**
		 * 
		 * The below lines are commented to take input from 'String args[]' array
		 * 
		 * 
		System.out.println("Enter values in the sudoku board . Enter '-' - to describe a blank.");
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				System.out.println("Enter value in row " + (i + 1) + " column " + (j + 1) + " :");
				sudoku_board[i][j] = sc.next();
			}
		}
		*/
		
		//To use Scanner you must uncomment the commented part above and comment the part below
		
		//<Remove to use Scanner>
		int x=0;
		for(i=0;i<l;i++) {
			for(j=0;j<l;j++) {
				sudoku_board[i][j]=args[x];
				x=x+1;
			}
		}
		
		//</Remove to use Scanner>
		int total_number_of_blanks = countBlanks();
		
		displaySudokuBoard();
		
		while(total_number_of_blanks > 0) {
			
			total_number_of_blanks=countBlanks();
		
			blank_objects_array=new blank[total_number_of_blanks];
		
			intialize_blank_objects_array();
			
			fill_the_blank_with_least_value_of_number_of_most_possible_values();
		}
		
		System.out.println("All calculations have been finished!!!");
		
		displaySudokuBoard();
	}
	
	static void displaySudokuBoard() {
		System.out.println("*****Your board is*****");
		int i,j;
		for(i=0;i<l;i++) {
			for(j=0;j<l;j++) {
				System.out.print(sudoku_board[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	static void intialize_blank_objects_array() {
				
		int i,j;
		int x=0;
		
		blankManager ob=new blankManager(sudoku_board);
		
		for(i=0;i<l;i++) {
			for(j=0;j<l;j++) {
				if(sudoku_board[i][j].equals("-")) {
					blank_objects_array[x]=new blank();
					blank_objects_array[x].row_position=i;
					blank_objects_array[x].column_position=j;
					blank_objects_array[x].upArray=ob.getUpArray(i, j);
					blank_objects_array[x].downArray=ob.getDownArray(i, j);
					blank_objects_array[x].leftArray=ob.getLeftArray(i, j);
					blank_objects_array[x].rightArray=ob.getRightArray(i, j);
					blank_objects_array[x].ownBoxArray=ob.getOwnBoxArray(i, j);
					blank_objects_array[x].setMostPossibleValue();
					x=x+1;
				}
			}
		}
	}
	
	static int countBlanks(){
		int n=0;
		int i,j;
		for(i=0;i<l;i++) {
			for(j=0;j<l;j++) {
				if(sudoku_board[i][j].equals("-")) {
					n=n+1;
				}
			}
		}
		return n;
	}
	
	static void fill_the_blank_with_least_value_of_number_of_most_possible_values() {
		int i;
		int len=blank_objects_array.length;
		int least_number_of_most_possible_values=9;
		blank object_which_has_least_number_of_most_possible_values=null;
		for(i=0;i<len;i++) {
			if(least_number_of_most_possible_values < blank_objects_array[i].most_possible_values.length) {
				least_number_of_most_possible_values = blank_objects_array[i].most_possible_values.length;
				object_which_has_least_number_of_most_possible_values = blank_objects_array[i];
			}
		}
		object_which_has_least_number_of_most_possible_values.fillBlank();
	}
}