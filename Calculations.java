package dietplangui;

public class Calculations {
    
    public static double calculateBMI(String username) {
        
        int userIndex = -1;
        double bmi;
        Users[] users = ReadData.importUserData();
        
        for (int i = 0; i < users.length; i++) {
            if (username.matches(users[i].getUsername())) {
                userIndex = i;
            }
        }
        
        bmi = users[userIndex].getWeight()/(users[userIndex].getHeight() * users[userIndex].getHeight());

        return bmi;
        
    }

    public static double calculateBMR(String username) {
    
        double bmr = 0;
        int userIndex = -1;
        Users[] users = ReadData.importUserData();
        
        for (int i = 0; i < users.length; i++) {
            if (username.matches(users[i].getUsername())) {
                userIndex = i;
            }
        }
        
        if (users[userIndex].getGender().equals("Male")) {
            bmr = (10*users[userIndex].getWeight()) + (625*users[userIndex].getHeight()) - (5*users[userIndex].getAge()) + 5 ;
        } else if (users[userIndex].getGender().equals("Female")) {
            bmr = (10*users[userIndex].getWeight()) + (625*users[userIndex].getHeight()) - (5*users[userIndex].getAge()) - 161 ;
        }
        
        return bmr;
        
    }
    
    public static void BodyMassCalculator(){
        
      double BodyMass = 0;
      int userIndex = -1;
    }
    
}
