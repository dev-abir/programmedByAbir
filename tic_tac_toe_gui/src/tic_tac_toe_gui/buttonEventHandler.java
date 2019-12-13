package tic_tac_toe_gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class buttonEventHandler implements EventHandler<ActionEvent> {

	int buttonRowPosition;
	int buttonColumnPosition;
	String tic_tac_toe_board[][];
	int mode;
	
	buttonEventHandler(String board[][], int x, int y, int mode) {
		this.buttonRowPosition = x;
		this.buttonColumnPosition = y;
		this.tic_tac_toe_board = board;
		this.mode = mode;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alertEventHandler alertEventHandler_OBJECT = new alertEventHandler();
		new_tic_tac_toe new_tic_tac_toe_OBJECT = new new_tic_tac_toe(tic_tac_toe_board, "X", "O");
		
		if(tic_tac_toe_board[buttonRowPosition][buttonColumnPosition].equals(" "))
		{
			
			tic_tac_toe_board[buttonRowPosition][buttonColumnPosition]="O";
			
			if(new_tic_tac_toe_OBJECT.see_whether_it_is_a_draw_match_or_not())
			{
				System.out.println("MATCH DRAW");
				alert.setHeaderText("Information");
				alert.setContentText("Match draw.");
				alert.show();
				alert.setOnCloseRequest(alertEventHandler_OBJECT);
			}
			
			else
				
			{
				if(new_tic_tac_toe_OBJECT.see_whether_player_has_won_or_not())
				{
					System.out.println("PLAYER WON");
					alert.setHeaderText("Information");
					alert.setContentText("Player won!!!");
					alert.show();
					alert.setOnCloseRequest(alertEventHandler_OBJECT);
				}
				
				else
					
				{
					getComputerInput(buttonRowPosition, buttonColumnPosition);
					
					if(new_tic_tac_toe_OBJECT.see_whether_it_is_a_draw_match_or_not())
					{
						System.out.println("MATCH DRAW");
						alert.setHeaderText("Information");
						alert.setContentText("Match draw.");
						alert.show();
						alert.setOnCloseRequest(alertEventHandler_OBJECT);
					}
				
					else
					{
						if(new_tic_tac_toe_OBJECT.see_whether_computer_has_won_or_not())
						{
							System.out.println("COMPUTER WON");
							alert.setHeaderText("Information");
							alert.setContentText("Player lose!!!");
							alert.show();
							alert.setOnCloseRequest(alertEventHandler_OBJECT);
						}
					}
					updateButtons();
				}
			}
		}
		
		else
		
		{
			alert.setHeaderText("Information");
			alert.setContentText("Place already occupied");
			alert.show();
		}
	}
	
	void getComputerInput(int playerInputRow, int playerInputColumn){
		
		computer_turn_calculator computer_turn_calculator_OBJECT;
		computer_turn_calculator_OBJECT=new computer_turn_calculator(tic_tac_toe_board, "O", "X", mode);
		
		tic_tac_toe_board = computer_turn_calculator_OBJECT.getResultantArray();
	}
	
	void updateButtons() {
		Main.tic_tac_toe_board = tic_tac_toe_board;
		Main.updateButtons();
	}
}
