package dietplangui;

import java.io.*;

public class WriteData {
    
    public static void writeUserData(String firstName, String lastName, int age, String gender, String address, double weight, double height, String username, String password) {
        
        try {
            File outputFile = new File("src/dietplangui/users.txt");
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
                writer.newLine();
                writer.write(firstName + "@@" + lastName + "@@" + age + "@@" + gender + "@@" + address + "@@" + weight + "@@" + height + "@@" + username + "@@" + password);
            }
        } catch (IOException e) {
            MessageBox.messageBox("File not found!");
        }
    }
}
