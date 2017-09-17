package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class TranslitManager extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            /* Reads fxml file
             * and draws interface.
             */
            Parent root = FXMLLoader.load(getClass().getResource("/application/translitWindow.fxml"));
 
            primaryStage.setTitle("Translit Your Text");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
         
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}