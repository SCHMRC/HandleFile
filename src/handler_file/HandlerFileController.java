/**
 * Sample Skeleton for 'Sample.fxml' Controller Class
 */

package handler_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HandlerFileController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnFile"
    private Button btnFile; // Value injected by FXMLLoader

    @FXML // fx:id="display"
    private TextArea display; // Value injected by FXMLLoader

    @FXML // fx:id="path"
    private TextField path; // Value injected by FXMLLoader

    @FXML
    void onclick(ActionEvent event) throws IOException {
    	this.selectFile(null);
    }
    
    @FXML
    void onkeypressed(KeyEvent event) throws IOException {
    	if(event.getCode().equals(KeyCode.ENTER)) {
    		this.selectFile(path.getText());
    		}
    }
    
    void selectFile(String mainStage) throws IOException {
    	display.clear();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("*.txt", "*.txt"));
    	if(mainStage != null) {
    	System.out.print(mainStage);
    		File temp = new File(mainStage);
    		fileChooser.setInitialDirectory(temp);
    	}
    	File file = fileChooser.showOpenDialog(null);
    	path.setText(file.getPath());
    	FileReader read = new FileReader(file);
    	BufferedReader br = new BufferedReader(read);
    	String x;
    	while((x = br.readLine()) != null) {
    		display.appendText(x + "\n");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnFile != null : "fx:id=\"btnFile\" was not injected: check your FXML file 'Sample.fxml'.";
        assert display != null : "fx:id=\"display\" was not injected: check your FXML file 'Sample.fxml'.";
        assert path != null : "fx:id=\"path\" was not injected: check your FXML file 'Sample.fxml'.";

    }

}
