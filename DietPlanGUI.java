package dietplangui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DietPlanGUI extends Application {

    static TextField firstNameField, lastNameField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane primaryPane = new GridPane();
        primaryPane.setAlignment(Pos.CENTER);
        primaryPane.setVgap(25);

        Label appTitle = new Label();
        appTitle.setText("Diet Plan Application");

        Button signInBtn = new Button("Sign In");
        signInBtn.setFocusTraversable(false);
        signInBtn.setMinWidth(300);
        signInBtn.setOnAction(e -> {
            SignIn.signIn();
        });

        Button signUpBtn = new Button("Sign Up");
        signUpBtn.setFocusTraversable(false);
        signUpBtn.setMinWidth(300);
        signUpBtn.setOnAction(e -> {
            SignUp.signUp();
        });

        Button searchUserBtn = new Button("Search for user");
        searchUserBtn.setFocusTraversable(false);
        searchUserBtn.setMinWidth(300);
        searchUserBtn.setOnAction(e -> {
            searchUser();
        });

        Button exitBtn = new Button("Exit");
        exitBtn.setFocusTraversable(false);
        exitBtn.setMinWidth(300);
        exitBtn.setOnAction(e -> {
            System.exit(0);
        });

        primaryPane.add(appTitle, 0, 0);
        primaryPane.add(signInBtn, 0, 2);
        primaryPane.add(signUpBtn, 0, 3);
        primaryPane.add(searchUserBtn, 0, 4);
        primaryPane.add(exitBtn, 0, 6);

        Scene scene = new Scene(primaryPane);

        primaryStage.setTitle("Diet Plan Application");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void searchUser() {
        Stage searchStage = new Stage();

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(25);

        Label title = new Label();
        title.setText("Search for user - Diet Plan Application");

        firstNameField = new TextField();
        firstNameField.setPromptText("First name here");
        firstNameField.setFocusTraversable(false);
        firstNameField.setMinWidth(300);

        lastNameField = new TextField();
        lastNameField.setPromptText("Last name here");
        lastNameField.setFocusTraversable(false);
        lastNameField.setMinWidth(300);

        Button searchBtn = new Button("Search");
        searchBtn.setFocusTraversable(false);
        searchBtn.setMinWidth(300);
        searchBtn.setOnAction(e -> {

            if (firstNameField.getText().matches("")) {
                MessageBox.messageBox("First name cannot be empty!");
            } else if (!firstNameField.getText().matches("^[a-zA-Z]+$")) {
                MessageBox.messageBox("First name can only contain alphabets!");
            } else if (lastNameField.getText().matches("")) {
                MessageBox.messageBox("Last name cannot be empty!");
            } else if (!lastNameField.getText().matches("^[a-zA-Z]+$")) {
                MessageBox.messageBox("Last name can only contain alphabets!");
            } else {
                Users[] users = ReadData.importUserData();
                int guide = -1;
                for (int i = 0; i < users.length; i++) {
                    if ((firstNameField.getText().equalsIgnoreCase(users[i].getFirstName())) && (lastNameField.getText().equalsIgnoreCase(users[i].getLastName()))) {
                        guide = i;
                    }
                }

                searchStage.close();

                if (guide == -1) {
                    MessageBox.messageBox("No account found for this name!");
                } else {
                    MessageBox.messageBox("Account found with username: " + users[guide].getUsername());
                }

            }

        });

        Button backBtn = new Button("Back");
        backBtn.setFocusTraversable(false);
        backBtn.setMinWidth(300);
        backBtn.setOnAction(e -> {
            searchStage.close();
        });

        pane.add(title, 0, 0);
        pane.add(firstNameField, 0, 2);
        pane.add(lastNameField, 0, 3);
        pane.add(searchBtn, 0, 5);
        pane.add(backBtn, 0, 6);

        Scene scene = new Scene(pane);

        searchStage.setTitle("Search for user - Diet Plan Application");
        searchStage.setMaximized(true);
        searchStage.setScene(scene);
        searchStage.show();
    }

}
