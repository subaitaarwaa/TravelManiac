package com.example.travelmaniac;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.stage.Stage;

/**
 * Represents the login screen for the TravelManiac application.
 * 
 */
public class LoginScreen {
    private Scene scene; // Represents the screen layout

    /**
     * Constructor for the LoginScreen.
     * @param stage The primary stage.
     * @param app The main application instance.
     */
    public LoginScreen(Stage stage, App app) {
        // Header with Welcome Text
        Label welcomeText = new Label("Welcome back to TravelManiac!");
        welcomeText.setFont(Font.font("Plus Jakarta Sans", 22));
        welcomeText.setStyle("-fx-text-fill: #111416; -fx-font-weight: bold;");

        // Input fields for username and password
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameField.setStyle(
            "-fx-background-color: #eff2f4; -fx-border-radius: 12px; -fx-padding: 8px; -fx-font-size: 16px;"
        );

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setStyle(
            "-fx-background-color: #eff2f4; -fx-border-radius: 12px; -fx-padding: 8px; -fx-font-size: 16px;"
        );

        // Login button
        Button loginButton = new Button("Log In");
        loginButton.setStyle(
            "-fx-background-color: #11477a; -fx-text-fill: white; -fx-font-size: 16px; " +
            "-fx-padding: 8px 20px; -fx-border-radius: 12px;"
        );
        loginButton.setOnAction(e -> {
            // Retrieve the entered username and password
            String username = usernameField.getText();
            String password = passwordField.getText();

            boolean validUser = false; // Flag to track if login is successful

            // Use a loop to check if the entered credentials match any user
            for (User user : App.users) {
                if (user.login(username, password)) {
                    validUser = true; // Match found
                    break; // Exit loop early
                }
            }

            if (validUser) {
                app.showDashboard(); // Navigate to the dashboard screen
            } else {
                System.out.println("Invalid username or password");
            }
        });

        // Register button as a hyperlink
        Hyperlink registerLink = new Hyperlink("Don’t have an account? Register here");
        registerLink.setStyle(
            "-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 16px; -fx-text-fill: #111416; -fx-underline: true;"
        );
        registerLink.setOnAction(e -> {
            app.showSignUpScreen(); // Navigate to the sign-up screen
        });

        // Layout
        VBox layout = new VBox(16, welcomeText, usernameField, passwordField, loginButton, registerLink);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 16px; -fx-spacing: 16px; -fx-background-color: #ffffff;");

        scene = new Scene(layout, 400, 500); // Create the scene with a specified width and height
    }

    /**
     * 
     * @return The scene for this screen.
     */
    public Scene getScene() {
        return scene;
    }
}
