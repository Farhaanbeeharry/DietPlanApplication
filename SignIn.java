package dietplangui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class SignIn {

    static TextField usernameField;
    static PasswordField passwordField;

    public static void signIn() {

        Stage stage = new Stage();

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(25);

        Label title = new Label();
        title.setText("Sign In - Diet Plan Application");

        usernameField = new TextField();
        usernameField.setPromptText("Username here");
        usernameField.setFocusTraversable(false);
        usernameField.setMinWidth(300);

        passwordField = new PasswordField();
        passwordField.setPromptText("Password here");
        passwordField.setFocusTraversable(false);
        passwordField.setMinWidth(300);

        Button signInBtn = new Button("Sign In");
        signInBtn.setFocusTraversable(false);
        signInBtn.setMinWidth(300);
        signInBtn.setOnAction(e -> {
            int response = checkUser();

            if (response == 1) {
                MessageBox.messageBox("Username field cannot be empty!");
            } else if (response == 2) {
                MessageBox.messageBox("Password field cannot be empty!");
            } else if (response == 0) {
                MessageBox.messageBox("Username not found!");
            } else if (response == 4) {
                stage.close();
                String username = getUsername();
                MainMenu.mainMenu(username);
            } else if (response == 5) {
                MessageBox.messageBox("Incorrect password!");
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setFocusTraversable(false);
        backBtn.setMinWidth(300);
        backBtn.setOnAction(e -> {
            stage.close();
        });

        pane.add(title, 0, 0);
        pane.add(usernameField, 0, 2);
        pane.add(passwordField, 0, 3);
        pane.add(signInBtn, 0, 5);
        pane.add(backBtn, 0, 6);

        Scene scene = new Scene(pane);

        stage.setTitle("Sign In - Diet Plan Application");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

    }

    public static int checkUser() {

        int response = 0;
        int guide = 0;
        String username = usernameField.getText();
        String password = passwordField.getText();

        Users[] users = ReadData.importUserData();

        if (username.matches("")) {
            response = 1;
            return response;
        } else if (password.matches("")) {
            response = 2;
            return response;
        }
        
        for (int i = 0; i < users.length; i++) {
            if (username.matches(users[i].getUsername())) {
                guide = i;
                response = 3;
            } 
        }
        
        if (response == 0) {
            return response;
        } else if (response == 3) {
            if (password.matches(users[guide].getPassword())) {
                response = 4;
                return response;
            } else {
                response = 5;
                return response;
            }
        }

        return response;

    }
    
    public static String getUsername() {
        
        String username = "";
        
        Users[] users = ReadData.importUserData();
        
        for (int i = 0; i < users.length; i++) {
            if (usernameField.getText().matches(users[i].getUsername())) {
                username = users[i].getUsername();
            }
        }
        
        return username;
    }

}
