package tic_tac_toe_gui;

import javafx.event.EventHandler;
import javafx.scene.control.DialogEvent;

public class alertEventHandler implements EventHandler<DialogEvent> {

	@Override
	public void handle(DialogEvent event) {
		System.exit(0);
	}
}
