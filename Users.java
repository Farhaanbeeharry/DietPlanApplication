package dietplangui;

public class Users {

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String address;
    private double weight;
    private String usernameight;
    private double height;
    private String username;
    private String password;

    public Users() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.gender = "";
        this.address = "";
        this.weight = 0.0;
        this.height = 0.0;
        this.username = "";
        this.password = "";
    }

    public Users(String firstName, String lastName, int age, String gender, String address, double weight, double height, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
