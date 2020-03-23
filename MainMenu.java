package dietplangui;

//import static dietplangui.SignUp.genderGroup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

class MainMenu {

    static TextField weightField, heightField, ageField;
    static RadioButton maleBtn, femaleBtn;
    static ToggleGroup genderGroup;

    static void mainMenu(String username) {

        Stage mainMenuStage = new Stage();

        GridPane mainMenuPane = new GridPane();
        mainMenuPane.setAlignment(Pos.CENTER);
        mainMenuPane.setVgap(25);

        Label title = new Label();
        title.setText("Main Menu - Diet Plan Application");
        
        /*
        double bmi = Calculations.calculateBMI(username);

        Text displayBMI = new Text();
        displayBMI.setText("Your BMI is : " + bmi);

        String status = "";
        if (bmi < 18.5) {
            status = "underweight";
        } else if (bmi < 24.9) {
            status = "normal";
        } else if (bmi < 29.9) {
            status = "overweight";
        } else {
            status = "obese";
        }

        Text bodyStatus = new Text();
        bodyStatus.setText("Body status : " + status);

        double bmr = Calculations.calculateBMR(username);

        Text displayBMR = new Text();
        displayBMR.setText("Your BMR is : " + bmr);

        Button bmiBtn = new Button("BMI Calculator");
        bmiBtn.setFocusTraversable(false);
        bmiBtn.setMinWidth(300);
        bmiBtn.setOnAction(e -> {
            BMICalculator();
        });

        Button bmrBtn = new Button("BMR Calculator");
        bmrBtn.setFocusTraversable(false);
        bmrBtn.setMinWidth(300);
        bmrBtn.setOnAction(e -> {
            BMRCalculator();
        });

        Button bmBtn = new Button("Body-Mass Calculator");
        bmBtn.setFocusTraversable(false);
        bmBtn.setMinWidth(300);
        bmBtn.setOnAction(e -> {
        });
        */
        
        
        Button userBtn = new Button("Print User Info");
        userBtn.setFocusTraversable(false);
        userBtn.setMinWidth(300);
        userBtn.setOnAction(e -> {
           userInfo(username);
        });
        
        
        Button DietBtn = new Button("Print diet plan");
        DietBtn.setFocusTraversable(false);
        DietBtn.setMinWidth(300);
        DietBtn.setOnAction(e -> {
            Display.dietPlan(username);
        });
        
        Button ExBtn = new Button("Print exercise plan");
        ExBtn.setFocusTraversable(false);
        ExBtn.setMinWidth(300);
        ExBtn.setOnAction(e -> {
          Display.exercises("userExercises", username);
        });
        
        Button allExercisesBtn = new Button("Show all exercises");
        allExercisesBtn.setFocusTraversable(false);
        allExercisesBtn.setMinWidth(300);
        allExercisesBtn.setOnAction(e -> {
            Display.exercises("showAllExercises", username);
        });
        
        Button OpBtn = new Button("More options");
        OpBtn.setFocusTraversable(false);
        OpBtn.setMinWidth(300);
        OpBtn.setOnAction(e -> {
            Option();  
        });

        Button switchBtn = new Button("Log out and switch user");
        switchBtn.setFocusTraversable(false);
        switchBtn.setMinWidth(300);
        switchBtn.setOnAction(e -> {
            mainMenuStage.close();
        });

        Button exitBtn = new Button("Log out and exit");
        exitBtn.setFocusTraversable(false);
        exitBtn.setMinWidth(300);
        exitBtn.setOnAction(e -> {
            System.exit(0);
        });

        mainMenuPane.add(title, 0, 0);
        //mainMenuPane.add(displayBMI, 0, 2);
        //mainMenuPane.add(displayBMR, 0, 3);
       //mainMenuPane.add(bodyStatus, 0, 4);
        mainMenuPane.add(userBtn, 0, 2);
        mainMenuPane.add(DietBtn, 0, 3);
        mainMenuPane.add(ExBtn, 0, 4);
        mainMenuPane.add(allExercisesBtn, 0, 5);
        mainMenuPane.add(OpBtn, 0, 6);
        //mainMenuPane.add(bmiBtn, 0, 5);
        //mainMenuPane.add(bmrBtn, 0, 6);
        //mainMenuPane.add(bmBtn, 0, 7);
        mainMenuPane.add(switchBtn, 0, 8);
        mainMenuPane.add(exitBtn, 0, 9);

        Scene scene = new Scene(mainMenuPane);

        mainMenuStage.setTitle("Main Menu - Diet Plan Application");
        mainMenuStage.setMaximized(true);
        mainMenuStage.setScene(scene);
        mainMenuStage.show();

    }
    
    public static void userInfo(String username){
        
        int userIndex = -1;
        
        Users[] users = ReadData.importUserData();
        
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equalsIgnoreCase(username)) {
                userIndex = i;
            }
        }
        
        Stage userInfoStage = new Stage();

        GridPane userInfoPane = new GridPane();
        userInfoPane.setAlignment(Pos.CENTER);
        userInfoPane.setVgap(25);
        
        double bmi = Calculations.calculateBMI(username);

        Text displayFirstName = new Text();
        displayFirstName.setText("First Name: " + users[userIndex].getFirstName());
        
        Text displayLastName = new Text();
        displayLastName.setText("Last Name: " + users[userIndex].getLastName());
        
        Text displayage = new Text();
        displayage.setText("Age: " + users[userIndex].getAge());
        
        Text displayweight = new Text();
        displayweight.setText("Weight: " + users[userIndex].getWeight());
        
        Text displayheight = new Text();
        displayheight.setText("Height: " + users[userIndex].getHeight());
        
        Text displayBMI = new Text();
        displayBMI.setText("Your BMI is : " + bmi);

        String status = "";
        if (bmi < 18.5) {
            status = "underweight";
        } else if (bmi < 24.9) {
            status = "normal";
        } else if (bmi < 29.9) {
            status = "overweight";
        } else {
            status = "obese";
        }

        Text bodyStatus = new Text();
        bodyStatus.setText("Body status : " + status);

        double bmr = Calculations.calculateBMR(username);

        Text displayBMR = new Text();
        displayBMR.setText("Your BMR is : " + bmr);
            
        Button backBtn = new Button("Back");
        backBtn.setFocusTraversable(false);
        backBtn.setMinWidth(300);
        backBtn.setOnAction(e -> {
            userInfoStage.close();
        });
        
        userInfoPane.add(displayFirstName, 0, 0);
        userInfoPane.add(displayLastName, 0, 1);
        userInfoPane.add(displayage, 0, 2);
        userInfoPane.add(displayweight, 0, 3);
        userInfoPane.add(displayheight, 0, 4);
        userInfoPane.add(displayBMI, 0, 6);
        userInfoPane.add(displayBMR, 0, 7);
        userInfoPane.add(bodyStatus, 0, 8);
        userInfoPane.add(backBtn, 0, 10);
        
        Scene scene = new Scene(userInfoPane);
        
        userInfoStage.setTitle("User Info - Diet Plan Application");
        userInfoStage.setMaximized(true);
        userInfoStage.setScene(scene);
        userInfoStage.show();
        
    }
    
    public static void DietPlan() {
        Stage DietPlan = new Stage();
        
        GridPane DietPlanPane = new GridPane();
        DietPlanPane.setAlignment(Pos.CENTER);
        DietPlanPane.setVgap(25);
        
        Label title = new Label();
        title.setText("Diet plan");
        
               
    }
    
    public static void ExPlan() {
        Stage ExPlan = new Stage();
        
        GridPane ExPlanPane = new GridPane();
        ExPlanPane.setAlignment(Pos.CENTER);
        ExPlanPane.setVgap(25);
        
        Label title = new Label();
        title.setText("Exercise Plan");
        
               
    }
    
    public static void Option(){
        Stage Option = new Stage();
        
        GridPane OptionPane = new GridPane();
        OptionPane.setAlignment(Pos.CENTER);
        OptionPane.setVgap(25);
        
        Label title = new Label();
        title.setText("More Options [calculators]");
            
        Button bmiBtn = new Button("BMI Calculator");
        bmiBtn.setFocusTraversable(false);
        bmiBtn.setMinWidth(300);
        bmiBtn.setOnAction(e -> {
            BMICalculator();
        });
        
        Button bmrBtn = new Button("BMR Calculator");
        bmrBtn.setFocusTraversable(false);
        bmrBtn.setMinWidth(300);
        bmrBtn.setOnAction(e -> {
            BMRCalculator();
        });
        
        Button BackBtn = new Button("Back");
        BackBtn.setFocusTraversable(false);
        BackBtn.setMinWidth(300);
        BackBtn.setOnAction(e -> {
            Option.close();
        });

        
        OptionPane.add(bmiBtn, 0, 2);
        OptionPane.add(bmrBtn, 0, 3);
        OptionPane.add(BackBtn, 0, 5);
        Scene scene = new Scene(OptionPane);
        Option.setTitle("Main Menu - Diet Plan Application");
        Option.setMaximized(true);
        Option.setScene(scene);
        Option.show();
    
        
    }

    public static void BMICalculator() {

        Stage bmiCalculatorStage = new Stage();

        GridPane bmiCalculatorPane = new GridPane();
        bmiCalculatorPane.setAlignment(Pos.CENTER);
        bmiCalculatorPane.setVgap(25);

        Label title = new Label();
        title.setText("BMI Calculator");

        weightField = new TextField();
        weightField.setPromptText("Weight in KG here");
        weightField.setFocusTraversable(false);
        weightField.setMinWidth(300);

        heightField = new TextField();
        heightField.setPromptText("Height in m here");
        heightField.setFocusTraversable(false);
        heightField.setMinWidth(300);

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setFocusTraversable(false);
        calculateBtn.setMinWidth(300);
        calculateBtn.setOnAction(e -> {

            double bmi = 0;

            if (!weightField.getText().matches("^[0-9.]+$")) {
                MessageBox.messageBox("Weight can be numbers only!");
            } else if (!heightField.getText().matches("^[0-9.]+$")) {
                MessageBox.messageBox("Height can be numbers only!");
            } else {
                bmi = Double.parseDouble(weightField.getText()) / (Double.parseDouble(heightField.getText()) * Double.parseDouble(heightField.getText()));
            }
            bmiCalculatorStage.close();
            MessageBox.messageBox("Your BMI is " + bmi);
        });

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setFocusTraversable(false);
        cancelBtn.setMinWidth(300);
        cancelBtn.setOnAction(e -> {
            bmiCalculatorStage.close();
        });

        bmiCalculatorPane.add(title, 0, 0);
        bmiCalculatorPane.add(weightField, 0, 2);
        bmiCalculatorPane.add(heightField, 0, 3);
        bmiCalculatorPane.add(calculateBtn, 0, 5);
        bmiCalculatorPane.add(cancelBtn, 0, 6);

        Scene scene = new Scene(bmiCalculatorPane);

        bmiCalculatorStage.setTitle("BMI Calculator - Diet Plan Application");
        bmiCalculatorStage.setMaximized(true);
        bmiCalculatorStage.setScene(scene);
        bmiCalculatorStage.show();

    }

    public static void BMRCalculator() {

        Stage bmrCalculatorStage = new Stage();

        GridPane bmrCalculatorPane = new GridPane();
        bmrCalculatorPane.setAlignment(Pos.CENTER);
        bmrCalculatorPane.setVgap(25);

        Label title = new Label();
        title.setText("BMR Calculator");

        weightField = new TextField();
        weightField.setPromptText("Weight in KG here");
        weightField.setFocusTraversable(false);
        weightField.setMinWidth(300);

        heightField = new TextField();
        heightField.setPromptText("Height in m here");
        heightField.setFocusTraversable(false);
        heightField.setMinWidth(300);

        ageField = new TextField();
        ageField.setPromptText("Age");
        ageField.setFocusTraversable(false);
        ageField.setMinWidth(300);

        Text genderText = new Text();
        genderText.setText("Gender:");
        genderGroup = new ToggleGroup();
        RadioButton maleBtn = new RadioButton("Male");
        maleBtn.setFocusTraversable(false);
        maleBtn.setToggleGroup(genderGroup);
        RadioButton femaleBtn = new RadioButton("Female");
        femaleBtn.setFocusTraversable(false);
        femaleBtn.setToggleGroup(genderGroup);

        HBox radioBtns = new HBox(50);
        radioBtns.getChildren().addAll(genderText, maleBtn, femaleBtn);
        radioBtns.setAlignment(Pos.CENTER);

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setFocusTraversable(false);
        calculateBtn.setMinWidth(300);
        calculateBtn.setOnAction(e -> {

            double bmr = 0;

            if (weightField.getText().matches("")) {
                MessageBox.messageBox("Weight cannot be empty");
            } else if (!weightField.getText().matches("^[0-9.]+$")) {
                MessageBox.messageBox("Weight can only be numbers");
            } else if (heightField.getText().matches("")) {
                MessageBox.messageBox("Height cannot be empty!");
            } else if (!heightField.getText().matches("^[0-9.]+$")) {
                MessageBox.messageBox("Height can be numbers only!");
            } else if (ageField.getText().matches("")) {
                MessageBox.messageBox("Age cannot be empty");
            } else if (!ageField.getText().matches("^[0-9.]+$")) {
                MessageBox.messageBox("Age c an be numbers only!");
            } else if (!maleBtn.isSelected() && !femaleBtn.isSelected()) {
                MessageBox.messageBox("Please choose a gender!");
            } else {
                if (maleBtn.isSelected()) {
                    bmr = 10 * Double.parseDouble(weightField.getText()) + (625 * Double.parseDouble(heightField.getText())) - 5 * Integer.parseInt(ageField.getText()) + 5;
                } else if (femaleBtn.isSelected()) {
                    bmr = 10 * Double.parseDouble(weightField.getText()) + (625 * Double.parseDouble(heightField.getText())) - 5 * Integer.parseInt(ageField.getText()) - 161;
                }

                bmrCalculatorStage.close();
                MessageBox.messageBox("Your BMR is " + bmr);

            }

        });
        
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setFocusTraversable(false);
        cancelBtn.setMinWidth(300);
        cancelBtn.setOnAction(e -> {
            bmrCalculatorStage.close();
        });

        bmrCalculatorPane.add(title, 0, 0);
        bmrCalculatorPane.add(weightField, 0, 2);
        bmrCalculatorPane.add(heightField, 0, 3);
        bmrCalculatorPane.add(ageField, 0, 4);
        bmrCalculatorPane.add(radioBtns, 0, 5);
        bmrCalculatorPane.add(calculateBtn, 0, 6);
        bmrCalculatorPane.add(cancelBtn, 0, 7);

        Scene scene = new Scene(bmrCalculatorPane);

        bmrCalculatorStage.setTitle("BMR Calculator - Diet Plan Application");
        bmrCalculatorStage.setMaximized(true);
        bmrCalculatorStage.setScene(scene);
        bmrCalculatorStage.show();

    }

    
    
}