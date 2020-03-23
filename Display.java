/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dietplangui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author shankara19
 */
public class Display {

    static Stage stage, dietStage;
    static TableView table, dietTable;

    public static void exercises(String criteria, String username) {

        stage = new Stage();
        stage.setMaximized(true);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(25);

        Label title = new Label();
        title.setText("Exercises");

        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double columnWidth = (screenWidth - 6) / 6;

        try {
            TableColumn<Exercises, String> nameColumns = new TableColumn<>("Exercise Name");
            nameColumns.setCellValueFactory(new PropertyValueFactory<>("name"));
            nameColumns.setMinWidth(columnWidth);
            nameColumns.setResizable(false);
            nameColumns.setSortable(false);

            TableColumn<Exercises, String> bodyTypeColumns = new TableColumn<>("Body Type");
            bodyTypeColumns.setCellValueFactory(new PropertyValueFactory<>("bodyType"));
            bodyTypeColumns.setMinWidth(columnWidth);
            bodyTypeColumns.setResizable(false);
            bodyTypeColumns.setSortable(false);

            TableColumn<Exercises, String> exerciseTypeColumns = new TableColumn<>("Exercise Type");
            exerciseTypeColumns.setCellValueFactory(new PropertyValueFactory<>("exerciseType"));
            exerciseTypeColumns.setMinWidth(columnWidth);
            exerciseTypeColumns.setResizable(false);
            exerciseTypeColumns.setSortable(false);

            TableColumn<Exercises, Double> durationColumns = new TableColumn<>("Duration");
            durationColumns.setCellValueFactory(new PropertyValueFactory<>("duration"));
            durationColumns.setMinWidth(columnWidth);
            durationColumns.setResizable(false);
            durationColumns.setSortable(false);

            TableColumn<Exercises, Integer> repetitionColumns = new TableColumn<>("Repetition");
            repetitionColumns.setCellValueFactory(new PropertyValueFactory<>("repetition"));
            repetitionColumns.setMinWidth(columnWidth);
            repetitionColumns.setResizable(false);
            repetitionColumns.setSortable(false);

            TableColumn<Exercises, Integer> setsColumns = new TableColumn<>("Sets");
            setsColumns.setCellValueFactory(new PropertyValueFactory<>("sets"));
            setsColumns.setMinWidth(columnWidth);
            setsColumns.setResizable(false);
            setsColumns.setSortable(false);

            table = new TableView<>();
            table.setFocusTraversable(false);
            table.setEditable(false);
            table.prefHeightProperty().bind(stage.heightProperty());
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            setToTable(criteria, username);

            table.getColumns().addAll(nameColumns, bodyTypeColumns, exerciseTypeColumns, durationColumns, repetitionColumns, setsColumns);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button backBtn = new Button("Back");
        backBtn.setMinWidth(500);
        backBtn.setMaxWidth(500);
        backBtn.setPadding(new Insets(20, 0, 20, 0));
        backBtn.setFocusTraversable(false);
        backBtn.setOnAction(e -> {
            stage.close();
        });

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(title, table, backBtn);

        pane.add(vbox, 0, 0);

        Scene scene = new Scene(pane);

        stage.setTitle("Exercises");
        stage.setScene(scene);
        stage.show();

    }

    public static void setToTable(String criteria, String username) {

        String bodyType = findBodyType(username);

        Exercises[] exercises = ReadData.importExerciseData();
        Users[] users = ReadData.importUserData();

        if (criteria.equalsIgnoreCase("showAllExercises")) {

            for (int i = 0; i < exercises.length; i++) {
                table.getItems().add(new Exercises(exercises[i].getName(),
                        exercises[i].getBodyType(),
                        exercises[i].getExerciseType(),
                        exercises[i].getDuration(),
                        exercises[i].getRepetition(),
                        exercises[i].getSets()));
            }
        } else if (criteria.equalsIgnoreCase("userExercises")) {
            for (int i = 0; i < exercises.length; i++) {
                if (bodyType.equalsIgnoreCase(exercises[i].getBodyType())) {
                    table.getItems().add(new Exercises(exercises[i].getName(),
                            exercises[i].getBodyType(),
                            exercises[i].getExerciseType(),
                            exercises[i].getDuration(),
                            exercises[i].getRepetition(),
                            exercises[i].getSets()));
                }
            }
        }
    }

    public static String findBodyType(String username) {

        String bodyType = "";
        double bmi = Calculations.calculateBMI(username);

        if (bmi < 18.5) {
            bodyType = "underweight";
        } else if (bmi < 24.9) {
            bodyType = "normal";
        } else if (bmi < 29.9) {
            bodyType = "overweight";
        } else {
            bodyType = "obese";
        }

        return bodyType;
    }

    public static void dietPlan(String username) {

        dietStage = new Stage();
        dietStage.setMaximized(true);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(25);

        Label title = new Label();
        title.setText("Diet Plan");

        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double columnWidth = (screenWidth - 6) / 6;

        try {
            TableColumn<Diet, String> bodyTypeColumns = new TableColumn<>("Body Type");
            bodyTypeColumns.setCellValueFactory(new PropertyValueFactory<>("bodyType"));
            bodyTypeColumns.setMinWidth(columnWidth);
            bodyTypeColumns.setResizable(false);
            bodyTypeColumns.setSortable(false);

            TableColumn<Diet, String> mealColumns = new TableColumn<>("Meal");
            mealColumns.setCellValueFactory(new PropertyValueFactory<>("meal"));
            mealColumns.setMinWidth(columnWidth);
            mealColumns.setResizable(false);
            mealColumns.setSortable(false);

            TableColumn<Diet, String> toEatColumns = new TableColumn<>("To Eat");
            toEatColumns.setCellValueFactory(new PropertyValueFactory<>("toEat"));
            toEatColumns.setMinWidth(columnWidth);
            toEatColumns.setResizable(false);
            toEatColumns.setSortable(false);

            TableColumn<Diet, String> toDrinkColumns = new TableColumn<>("To Drink");
            toDrinkColumns.setCellValueFactory(new PropertyValueFactory<>("toDrink"));
            toDrinkColumns.setMinWidth(columnWidth);
            toDrinkColumns.setResizable(false);
            toDrinkColumns.setSortable(false);

            TableColumn<Diet, String> toAvoidColumns = new TableColumn<>("To Avoid");
            toAvoidColumns.setCellValueFactory(new PropertyValueFactory<>("toAvoid"));
            toAvoidColumns.setMinWidth(columnWidth);
            toAvoidColumns.setResizable(false);
            toAvoidColumns.setSortable(false);

            TableColumn<Diet, Integer> durationColumns = new TableColumn<>("Duration(days)");
            durationColumns.setCellValueFactory(new PropertyValueFactory<>("duration"));
            durationColumns.setMinWidth(columnWidth);
            durationColumns.setResizable(false);
            durationColumns.setSortable(false);

            dietTable = new TableView<>();
            dietTable.setFocusTraversable(false);
            dietTable.setEditable(false);
            dietTable.prefHeightProperty().bind(dietStage.heightProperty());
            dietTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            Diet[] diet = ReadData.importDietData();

            for (int i = 0; i < diet.length; i++) {
                if (findBodyType(username).equalsIgnoreCase(diet[i].getBodyType())) {
                    dietTable.getItems().add(new Diet(diet[i].getBodyType(),
                            diet[i].getMeal(),
                            diet[i].getToEat(),
                            diet[i].getToDrink(),
                            diet[i].getToAvoid(),
                            diet[i].getDuration()));
                }
            }

            dietTable.getColumns().addAll(bodyTypeColumns, mealColumns, toEatColumns, toDrinkColumns, toAvoidColumns, durationColumns);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button backBtn = new Button("Back");
        backBtn.setMinWidth(300);
        backBtn.setMaxWidth(300);
        backBtn.setFocusTraversable(false);
        backBtn.setOnAction(e -> {
            dietStage.close();
        });

        Button breakFastBtn = new Button("My Breakfast Only");
        breakFastBtn.setMinWidth(300);
        breakFastBtn.setMaxWidth(300);
        breakFastBtn.setFocusTraversable(false);
        breakFastBtn.setOnAction(e -> {
            setToDietTable("breakfast", username);
        });

        Button lunchBtn = new Button("My Lunch Only");
        lunchBtn.setMinWidth(300);
        lunchBtn.setMaxWidth(300);
        lunchBtn.setFocusTraversable(false);
        lunchBtn.setOnAction(e -> {
            setToDietTable("lunch", username);
        });

        Button dinnerBtn = new Button("My Dinner Only");
        dinnerBtn.setMinWidth(300);
        dinnerBtn.setMaxWidth(300);
        dinnerBtn.setFocusTraversable(false);
        dinnerBtn.setOnAction(e -> {
            setToDietTable("dinner", username);
        });

        Button thisTypeBtn = new Button("Show All For My Body Types");
        thisTypeBtn.setMinWidth(300);
        thisTypeBtn.setMaxWidth(300);
        thisTypeBtn.setFocusTraversable(false);
        thisTypeBtn.setOnAction(e -> {
            setToDietTable("showMy", username);
        });

        Button showAllBtn = new Button("Show All For All Body Type");
        showAllBtn.setMinWidth(300);
        showAllBtn.setMaxWidth(300);
        showAllBtn.setFocusTraversable(false);
        showAllBtn.setOnAction(e -> {
            setToDietTable("showAll", username);
        });

        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(backBtn, breakFastBtn, lunchBtn, dinnerBtn, thisTypeBtn, showAllBtn);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(title, dietTable, hbox);

        pane.add(vbox, 0, 0);

        Scene scene = new Scene(pane);

        dietStage.setTitle("Diet Plan");
        dietStage.setScene(scene);
        dietStage.show();

    }

    public static void setToDietTable(String criteria, String username) {

        Diet[] diet = ReadData.importDietData();
        
        dietTable.getItems().clear();
        
        if (criteria.equalsIgnoreCase("breakfast") || criteria.equalsIgnoreCase("lunch") || criteria.equalsIgnoreCase("dinner")) {
            for (int i = 0; i < diet.length; i++) {
                if ((findBodyType(username).equalsIgnoreCase(diet[i].getBodyType())) && (diet[i].getMeal().equalsIgnoreCase(criteria))) {

                    dietTable.getItems().add(new Diet(diet[i].getBodyType(),
                            diet[i].getMeal(),
                            diet[i].getToEat(),
                            diet[i].getToDrink(),
                            diet[i].getToAvoid(),
                            diet[i].getDuration()));
                }
            }
        } else if (criteria.equalsIgnoreCase("showMy")) {
            for (int i = 0; i < diet.length; i++) {
                if (findBodyType(username).equalsIgnoreCase(diet[i].getBodyType())) {

                    dietTable.getItems().add(new Diet(diet[i].getBodyType(),
                            diet[i].getMeal(),
                            diet[i].getToEat(),
                            diet[i].getToDrink(),
                            diet[i].getToAvoid(),
                            diet[i].getDuration()));
                }
            }
        } else if (criteria.equalsIgnoreCase("showAll")) {
            for (int i = 0; i < diet.length; i++) {
                dietTable.getItems().add(new Diet(diet[i].getBodyType(),
                        diet[i].getMeal(),
                        diet[i].getToEat(),
                        diet[i].getToDrink(),
                        diet[i].getToAvoid(),
                        diet[i].getDuration()));

            }
        }

    }

}
