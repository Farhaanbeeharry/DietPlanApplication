package dietplangui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MessageBox {
    
    public static void messageBox(String message) {
        
         Stage messageWindow = new Stage();
        messageWindow.setTitle("Message");
        messageWindow.setResizable(false);

        GridPane messagePane = new GridPane();
        messagePane.setAlignment(Pos.CENTER);
        messagePane.setVgap(30);

        Label displayMessage = new Label();
        displayMessage.setText(message);
        displayMessage.setAlignment(Pos.CENTER);

        Button btnOK = new Button("OK");
        btnOK.setMinWidth(250);
        btnOK.setFocusTraversable(false);
        btnOK.setOnAction(e -> messageWindow.close());

        messagePane.add(displayMessage, 0, 0);
        messagePane.add(btnOK, 0, 1);

        Scene scene = new Scene(messagePane, 600, 150);

        messageWindow.setScene(scene);
        messageWindow.showAndWait();

    }
    
}
