package AirBnb;

public class User {
    String name;
    String phoneNumber;
    String password;
    String email;
    String nation;
    String id;
    int age;
    String gender;

    public User() {}

    public User(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
        this.nation = nation;
        this.id = id;
        this.age = age;
        this.gender = gender;
    }
}
