import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class browser extends Application {  
    @Override
    public void start(Stage stage) {
        stage.setTitle("Lemonade");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        stage.setWidth(screenSize.getWidth());
        stage.setHeight(screenSize.getHeight());
        Scene scene = new Scene(new Group());
        VBox root = new VBox();    
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.setJavaScriptEnabled(true);
        TextField l = new TextField ();
        TextField textField = l;
		l.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent e) {
              webEngine.load("http://" + textField.getText());
          }
      });
        root.getChildren().addAll(l,browser);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
} 
