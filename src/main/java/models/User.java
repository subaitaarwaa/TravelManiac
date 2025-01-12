package models;

public class User {
    private String username;
    private String password;
    private String name;  // New field for name
    private String email; // New field for email

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to update user details
    public void updateDetails(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
    }

    // Method to update name and email
    public void updateNameAndEmail(String newName, String newEmail) {
    this.name = newName;
    this.email = newEmail;
    }

    // Method to log in
    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    // Method to check if a username matches the current user's username
    public boolean isUsername(String inputUsername) {
        return username.equals(inputUsername); 
    }
}
    