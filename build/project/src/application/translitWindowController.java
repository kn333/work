package application;
 
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
 
public class translitWindowController implements Initializable {
 
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
   public void translitAction(ActionEvent event) {
       System.out.println("Button Clicked!");
      
//       Date now= new Date();
//      
//       DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
            
        // Model Data
        String text = beforeTranslitText.getText();
        
        text = text + "bla";
        
        // Show in VIEW
        afterTranslitText.setText(text);
      
   }
  
}
