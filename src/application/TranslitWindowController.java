package application;
 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class TranslitWindowController implements Initializable {
 
   @FXML
   private Button translitButton;
  
   @FXML
   private TextArea beforeTranslitText;
   
   @FXML
   private TextArea afterTranslitText;
  
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   // Click on Button
   public void translitAction(ActionEvent event) throws IOException {
	   //System.out.println("Button Clicked!");

	   TextProcessor tp = new TextProcessor();

	   String text = beforeTranslitText.getText();
	   
	   afterTranslitText.setText(tp.doProcess(text));

   }
  
}
