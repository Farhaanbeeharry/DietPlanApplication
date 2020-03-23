package dietplangui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class SignUp {

    static TextField firstNameField, lastNameField, ageField, addressField, weightField, heightField, usernameField, passwordField;
    static RadioButton maleBtn, femaleBtn;
    static ToggleGroup genderGroup;
    
    public static void signUp() {

        Stage stage = new Stage();

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(25);

        Label title = new Label();
        title.setText("Sign Up - Diet Plan Application");

        firstNameField = new TextField();
        firstNameField.setPromptText("First name here");
        firstNameField.setFocusTraversable(false);
        firstNameField.setMinWidth(300);

        lastNameField = new TextField();
        lastNameField.setPromptText("Last name here");
        lastNameField.setFocusTraversable(false);
        lastNameField.setMinWidth(300);

        ageField = new TextField();
        ageField.setPromptText("Age here");
        ageField.setFocusTraversable(false);
        ageField.setMinWidth(300);
        
        Text genderText = new Text();
        genderText.setText("Gender:");
        genderGroup = new ToggleGroup();
        maleBtn = new RadioButton("Male");
        maleBtn.setFocusTraversable(false);
        maleBtn.setToggleGroup(genderGroup);
        femaleBtn = new RadioButton("Female");
        femaleBtn.setFocusTraversable(false);
        femaleBtn.setToggleGroup(genderGroup);
        
        HBox radioBtns = new HBox(50);
        radioBtns.getChildren().addAll(genderText, maleBtn, femaleBtn);
        radioBtns.setAlignment(Pos.CENTER);
        
        addressField = new TextField();
        addressField.setPromptText("Address here");
        addressField.setFocusTraversable(false);
        addressField.setMinWidth(300);

        weightField = new TextField();
        weightField.setPromptText("Weight here (in Kg)");
        weightField.setFocusTraversable(false);
        weightField.setMinWidth(300);

        heightField = new TextField();
        heightField.setPromptText("Height here (in m)");
        heightField.setFocusTraversable(false);
        heightField.setMinWidth(300);

        usernameField = new TextField();
        usernameField.setPromptText("Username here");
        usernameField.setFocusTraversable(false);
        usernameField.setMinWidth(300);

        passwordField = new TextField();
        passwordField.setPromptText("Password here");
        passwordField.setFocusTraversable(false);
        passwordField.setMinWidth(300);

        Button signUpBtn = new Button("Sign Up");
        signUpBtn.setFocusTraversable(false);
        signUpBtn.setMinWidth(300);
        signUpBtn.setOnAction(e -> {
            int response = checkData();
            if (response == 1) {
                String gender = "";
                if (maleBtn.isSelected()) {
                    gender = "Male";
                } else if (femaleBtn.isSelected()) {
                    gender = "Female";
                }
                WriteData.writeUserData(firstNameField.getText(),
                        lastNameField.getText(),
                        Integer.parseInt(ageField.getText()),
                        gender,
                        addressField.getText(),
                        Double.parseDouble(weightField.getText()),
                        Double.parseDouble(heightField.getText()),
                        usernameField.getText(),
                        passwordField.getText());
                stage.close();
                MessageBox.messageBox("New user " + usernameField.getText() + " successfully created!");
                SignIn.signIn();
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setFocusTraversable(false);
        backBtn.setMinWidth(300);
        backBtn.setOnAction(e -> {
            stage.close();
        });

        pane.add(title, 0, 0);
        pane.add(firstNameField, 0, 2);
        pane.add(lastNameField, 0, 3);
        pane.add(ageField, 0, 4);
        pane.add(radioBtns, 0, 5);
        pane.add(addressField, 0, 6);
        pane.add(weightField, 0, 7);
        pane.add(heightField, 0, 8);
        pane.add(usernameField, 0, 9);
        pane.add(passwordField, 0, 10);
        pane.add(signUpBtn, 0, 12);
        pane.add(backBtn, 0, 13);

        Scene scene = new Scene(pane);

        stage.setTitle("Sign Up - Diet Plan Application");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

    }

    public static int checkData() {

        if (firstNameField.getText().matches("")) {
            MessageBox.messageBox("First name cannot be empty!");
        } else if (!firstNameField.getText().matches("^[a-zA-Z]+$")) {
            MessageBox.messageBox("First name can only contain alphabets!");
        } else if (lastNameField.getText().matches("")) {
            MessageBox.messageBox("Last name cannot be empty!");
        } else if (!lastNameField.getText().matches("^[a-zA-Z]+$")) {
            MessageBox.messageBox("Last name can only contain alphabets!");
        } else if (ageField.getText().matches("")) {
            MessageBox.messageBox("Age cannot be empty!");
        } else if (!ageField.getText().matches("^[0-9]+$")) {
            MessageBox.messageBox("Age can only be numbers");
        } else if (Integer.parseInt(ageField.getText()) < 16) {
            MessageBox.messageBox("You should be at least 16 years old!");
        } else if (!maleBtn.isSelected() && !femaleBtn.isSelected()) {
            MessageBox.messageBox("Please choose a gender!");
        } else if (addressField.getText().matches("")) {
            MessageBox.messageBox("Address cannot be empty!");
        } else if (weightField.getText().matches("")) {
            MessageBox.messageBox("Weight cannot be empty!");
        } else if (!weightField.getText().matches("^[0-9.]+$")) {
            MessageBox.messageBox("Weight can only be numbers");
        } else if (Double.parseDouble(weightField.getText()) < 10) {
            MessageBox.messageBox("Invalid weight!");
        } else if (heightField.getText().matches("")) {
            MessageBox.messageBox("Height cannot be empty!");
        } else if (!heightField.getText().matches("^[0-9.]+$")) {
            MessageBox.messageBox("Height can only be numbers");
        } else if (Double.parseDouble(heightField.getText()) < 0.1) {
            MessageBox.messageBox("Invalid Height!");
        } else if (usernameField.getText().contains(" ")) {
            MessageBox.messageBox("Username cannot contain space!");
        } else if (usernameField.getText().length() < 6) {
            MessageBox.messageBox("Username should be minimum 6 characters long!");
        } else if (checkUsername() == 1) {
            MessageBox.messageBox("Username already exists!");
        } else if (passwordField.getText().contains(" ")) {
            MessageBox.messageBox("Password cannot contain space!");
        } else if (passwordField.getText().length() < 8) {
            MessageBox.messageBox("Password should be minimum 8 characters long!");
        } else {
            return 1;
        }
         
        return 0;
    }

    public static int checkUsername() {

        int response = 0;

        Users[] users = ReadData.importUserData();

        for (int i = 0; i < users.length; i++) {
            if (usernameField.getText().equalsIgnoreCase(users[i].getUsername())) {
                response = 1;
                return response;
            }
        }

        return response;
    }

}
