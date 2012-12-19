package sample01;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	public TextField textField;
	public Label	label;
	public void writeText(ActionEvent e){
		this.label.setText(this.textField.getText());
	}
}
