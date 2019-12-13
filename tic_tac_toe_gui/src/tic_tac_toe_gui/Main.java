package tic_tac_toe_gui;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Button buttons[][];
	RadioButton radioButton_EASY;
	RadioButton radioButton_HARD;
	ToggleGroup toggleGroup;
	Button modeSelected;
	int WIDTH=340;
	int HEIGHT=340;
	int mode = 1;
	
	static String tic_tac_toe_board[][]=new String[3][3];//The tic-tac-toe array...
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		initTicTacToeBoard();
		buttons=new Button[3][3];
		
		radioButton_EASY = new RadioButton("Easy mode");
		radioButton_HARD = new RadioButton("Hard mode");
		modeSelected = new Button("OK");
		toggleGroup = new ToggleGroup();
		
		radioButton_EASY.setToggleGroup(toggleGroup);
		radioButton_HARD.setToggleGroup(toggleGroup);
		
		modeSelected.setLayoutX((WIDTH / 2) + 80);
		modeSelected.setLayoutY((HEIGHT / 2) + 100);
		
		radioButton_EASY.setLayoutX(WIDTH / 2);
		radioButton_EASY.setLayoutY(HEIGHT / 2);
		
		radioButton_HARD.setLayoutX(WIDTH / 2);
		radioButton_HARD.setLayoutY((HEIGHT / 2) + 50);
		
		Pane pane = new Pane();
		
		modeSelected.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				if(toggleGroup.getSelectedToggle().equals(radioButton_EASY)) {
					mode = 1;
				}
				else {
					mode = 2;
				}
				initAllButtons();
				pane.getChildren().removeAll(radioButton_EASY, radioButton_HARD, modeSelected);
				pane.getChildren().clear();
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						pane.getChildren().add(buttons[i][j]);
					}
				}
			}
		});
		
		pane.getChildren().add(radioButton_EASY);
		pane.getChildren().add(radioButton_HARD);
		pane.getChildren().add(modeSelected);
		/**
		StackPane root=new StackPane();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				root.getChildren().add(buttons[i][j]);
			}
		}
		*/
		
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setTitle("Tic Tac Toe (Beta 3) Created by Abir Ganguly");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	void initAllButtons() {
		int i;
		int j;
		double x=10;
		double y=10;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				buttons[i][j]=new Button();
				buttons[i][j].setPrefSize(100, 100);
				buttons[i][j].setLayoutX(x);
				buttons[i][j].setLayoutY(y);
				/**
				buttons[i][j].setTranslateX(x);
				buttons[i][j].setTranslateY(y);
				*/
				x=x+(buttons[i][j].getPrefWidth()+10);
				buttons[i][j].setText(tic_tac_toe_board[i][j]);
				buttonEventHandler buttonEventHandler_OBJECT = new buttonEventHandler(tic_tac_toe_board, i, j, mode);
				buttons[i][j].setOnAction(buttonEventHandler_OBJECT);
				/**
				 * 
				 * button0.setOnAction can be done in many ways:
				 * 
				 * (1)	You may implement "EventHandler<ActionEvent>" in this class, then
				 * use the eclipse option to "add unimplemented methods", then you will get
				 * "public void handle(ActionEvent event)" function write what you want to
				 * do after the button is clicked, inside that function. Then you need to change
				 * the "buttons[i].setOnAction(this);" command to:
				 * "buttonEventHandler buttonEventHandler_object=new buttonEventHandler(this);
				 * 
				 * (2)	You may create a class "buttonEventHandler", which implements "EventHandler<ActionEvent>"
				 * , then use the eclipse option to "add unimplemented methods", then you will get
				 * "public void handle(ActionEvent event)" function write what you want to
				 * do after the button is clicked, inside that function. Then you need to change
				 * the "buttons[i].setOnAction(this);" command to:
				 * "buttonEventHandler buttonEventHandler_object=new buttonEventHandler(this);
				 * button0.setOnAction(buttonEventHandler_object);"
				 *In the above method, we need to pass this to the constructor of "buttonEventHandler"
				 *class, because if we want to change the text of a button or textField, which is
				 *declared in this class, we cant't do that in "buttonEventHandler" class, so we may
				 *declare our textFields and buttons as class variables, or instance variables,
				 *and then in the "buttonEventHandler" class, we can simply call:
				 *this.buttons[i].setText("NEW Text");, to change the text.
				 * 
				 * 
				 * (3)	You can also replace the "buttons[i].setOnAction(this);"
				 * command to:
				 * buttons[i].setOnAction(new EventHandler<ActionEvent>() {
				 * 		@Override
				 * 		public void handle(ActionEvent event) {
				 * 			System.out.println("Hello World!");
				 * 		}
				 * });
				 * 
				 * 
				 */
			}
			y=y+(buttons[0][0].getPrefHeight()+10);
			x=10;
		}
	}
	
	static void updateButtons() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				buttons[i][j].setText(tic_tac_toe_board[i][j]);
			}
		}
	}
	
	void initTicTacToeBoard() {
		int i,j;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				tic_tac_toe_board[i][j]=" ";
			}
		}
	}
}