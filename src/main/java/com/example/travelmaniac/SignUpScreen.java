package com.example.travelmaniac;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.User;

public class SignUpScreen {
    private Scene scene;

    public SignUpScreen(Stage stage, App app) {
        // Header Text
        Label header = new Label("Create a New Account");
        header.setFont(Font.font("Plus Jakarta Sans", 22));
        header.setStyle("-fx-text-fill: #111416; -fx-font-weight: bold;");

        // Input fields
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setStyle("-fx-background-color: #eff2f4; -fx-border-radius: 12px; -fx-padding: 8px; -fx-font-size: 16px;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameField.setStyle("-fx-background-color: #eff2f4; -fx-border-radius: 12px; -fx-padding: 8px; -fx-font-size: 16px;");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setStyle("-fx-background-color: #eff2f4; -fx-border-radius: 12px; -fx-padding: 8px; -fx-font-size: 16px;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setStyle("-fx-background-color: #eff2f4; -fx-border-radius: 12px; -fx-padding: 8px; -fx-font-size: 16px;");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm your password");
        confirmPasswordField.setStyle("-fx-background-color: #eff2f4; -fx-border-radius: 12px; -fx-padding: 8px; -fx-font-size: 16px;");

        // Sign Up Button
        Button signUpButton = new Button("Sign Up");
        signUpButton.setStyle(
            "-fx-background-color: #11477a; -fx-text-fill: white; -fx-font-size: 16px; " +
            "-fx-padding: 8px 20px; -fx-border-radius: 12px;"
        );
        signUpButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();

                // Validation
                if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    throw new IllegalArgumentException("All fields are required!");
                }
                if (!password.equals(confirmPassword)) {
                    throw new IllegalArgumentException("Passwords do not match!");
                }

                // Create new user
                User newUser = new User(username, password);
                newUser.updateNameAndEmail(name, email);

                // Add user to global list
                App.users.add(newUser);
                System.out.println("User registered: " + username);

                // Navigate back to login screen
                app.showLoginScreen();
            } catch (IllegalArgumentException ex) {
                // Show error alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Sign Up Error");
                alert.setHeaderText("Registration Failed");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        });

        // Hyperlink to Login Screen
        Hyperlink loginLink = new Hyperlink("Already Registered? Login");
        loginLink.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 16px; -fx-text-fill: #111416; -fx-underline: true;");
        loginLink.setOnAction(e -> app.showLoginScreen());

        // Layout
        VBox layout = new VBox(16, header, nameField, usernameField, emailField, passwordField, confirmPasswordField, signUpButton, loginLink);
        layout.setStyle("-fx-background-color: #ffffff; -fx-padding: 16px; -fx-spacing: 16px;");
        layout.setPrefWidth(411);
        layout.setPrefHeight(828);

        scene = new Scene(layout, 411, 828);
    }

    public Scene getScene() {
        return scene;
    }
}
