package dietplangui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ReadData {

    public static int countUsers() {

        int count = 0;

        try {
            FileReader inputFile = new FileReader("src/dietplangui/users.txt");

            try (BufferedReader inputBuffer = new BufferedReader(inputFile)) {
                String readItem = inputBuffer.readLine();

                while (readItem != null) {
                    count++;
                    readItem = inputBuffer.readLine();
                }
            }

        } catch (IOException e) {
            MessageBox.messageBox("File not found!");
        }

        return count;

    }
    
    public static int countExercises() {

        int count = 0;

        try {
            FileReader inputFile = new FileReader("src/dietplangui/exercises.txt");

            try (BufferedReader inputBuffer = new BufferedReader(inputFile)) {
                String readItem = inputBuffer.readLine();

                while (readItem != null) {
                    count++;
                    readItem = inputBuffer.readLine();
                }
            }

        } catch (IOException e) {
            MessageBox.messageBox("File not found!");
        }

        return count;

    }
    
    public static int countDiet() {

        int count = 0;

        try {
            FileReader inputFile = new FileReader("src/dietplangui/diet.txt");

            try (BufferedReader inputBuffer = new BufferedReader(inputFile)) {
                String readItem = inputBuffer.readLine();

                while (readItem != null) {
                    count++;
                    readItem = inputBuffer.readLine();
                }
            }

        } catch (IOException e) {
            MessageBox.messageBox("File not found!");
        }

        return count;

    }

    public static Users[] importUserData() {

        Users[] users = new Users[countUsers()];

        try {
            FileReader inputFile = new FileReader("src/dietplangui/users.txt");

            try (BufferedReader inputBuffer = new BufferedReader(inputFile)) {
                String data;
                data = inputBuffer.readLine();

                while (data != null) {

                    for (int i = 0; i < countUsers(); i++) {
                        String[] userData = data.split("@@");
                        users[i] = new Users();
                        users[i].setFirstName(userData[0]);
                        users[i].setLastName(userData[1]);
                        users[i].setAge(Integer.parseInt(userData[2]));
                        users[i].setGender(userData[3]);
                        users[i].setAddress(userData[4]);
                        users[i].setWeight(Double.parseDouble(userData[5]));
                        users[i].setHeight(Double.parseDouble(userData[6]));
                        users[i].setUsername(userData[7]);
                        users[i].setPassword(userData[8]);
                        data = inputBuffer.readLine();
                    }

                }
            }

        } catch (IOException e) {
            MessageBox.messageBox("File not found!");
        }

        return users;

    }
    
    public static Exercises[] importExerciseData() {

        Exercises[] exercises = new Exercises[countExercises()];

        try {
            FileReader inputFile = new FileReader("src/dietplangui/exercises.txt");

            try (BufferedReader inputBuffer = new BufferedReader(inputFile)) {
                String data;
                data = inputBuffer.readLine();

                while (data != null) {

                    for (int i = 0; i < countExercises(); i++) {
                        String[] userData = data.split("@@");
                        exercises[i] = new Exercises();
                        exercises[i].setName(userData[0]);
                        exercises[i].setBodyType(userData[1]);
                        exercises[i].setExerciseType(userData[2]);
                        exercises[i].setDuration(Double.parseDouble(userData[3]));
                        exercises[i].setRepetition(Integer.parseInt(userData[4]));
                        exercises[i].setSets(Integer.parseInt(userData[5]));
                        data = inputBuffer.readLine();
                    }

                }
            }

        } catch (IOException e) {
            MessageBox.messageBox("File not found!");
        }

        return exercises;

    }
    
    public static Diet[] importDietData() {

        Diet[] diet = new Diet[countDiet()];

        try {
            FileReader inputFile = new FileReader("src/dietplangui/diet.txt");

            try (BufferedReader inputBuffer = new BufferedReader(inputFile)) {
                String data;
                data = inputBuffer.readLine();

                while (data != null) {

                    for (int i = 0; i < countDiet(); i++) {
                        String[] userData = data.split("@@");
                        diet[i] = new Diet();
                        diet[i].setBodyType(userData[0]);
                        diet[i].setMeal(userData[1]);
                        diet[i].setToEat(userData[2]);
                        diet[i].setToDrink(userData[3]);
                        diet[i].setToAvoid(userData[4]);
                        diet[i].setDuration(Integer.parseInt(userData[5]));
                        data = inputBuffer.readLine();
                    }

                }
            }

        } catch (IOException e) {
            MessageBox.messageBox("File not found!");
        }

        return diet;

    }

    
}