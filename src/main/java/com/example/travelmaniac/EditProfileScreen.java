
package com.example.travelmaniac;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditProfileScreen {
    private Scene scene;
    private App app; 

    public EditProfileScreen(Stage stage, App app) {
        this.app = app; // Assign the app instance

        // Input fields for profile editing
        TextField nameField = new TextField("Default Name");
        nameField.setPromptText("Update name");
        nameField.setStyle("-fx-padding: 11px; -fx-background-color: #f7f7f7; -fx-border-color: #dddddd; -fx-border-radius: 4px; -fx-font-family: 'Inter';");

        TextField emailField = new TextField("Default Email");
        emailField.setPromptText("Update email");
        emailField.setStyle("-fx-padding: 11px; -fx-background-color: #f7f7f7; -fx-border-color: #dddddd; -fx-border-radius: 4px; -fx-font-family: 'Inter';");

        TextField bioField = new TextField();
        bioField.setPromptText("Enter description");
        bioField.setStyle("-fx-padding: 11px; -fx-background-color: #f7f7f7; -fx-border-color: #dddddd; -fx-border-radius: 4px; -fx-font-family: 'Inter';");
        bioField.setPrefHeight(80);

        // Save Button
        Button saveButton = new Button("Save Changes");
        saveButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: #ffffff; -fx-font-size: 15px; -fx-padding: 10px 20px; -fx-border-radius: 4px;");
        saveButton.setOnAction(e -> {
            System.out.println("Profile updated!");
            app.showProfileScreen(); // Navigate back to ProfileScreen
        });

        // Cancel Button
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: #dddddd; -fx-text-fill: #333333; -fx-font-size: 15px; -fx-padding: 10px 20px; -fx-border-radius: 4px;");
        cancelButton.setOnAction(e -> stage.close()); // Close the window or navigate back

        // Delete Button
        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-font-size: 15px; -fx-padding: 10px 20px; -fx-border-radius: 4px;");
        deleteButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Profile");
            alert.setHeaderText("Are you sure?");
            alert.setContentText("This action cannot be undone.");
            alert.showAndWait();
        });

        // Layout
        VBox inputFields = new VBox(20, nameField, emailField, bioField);
        inputFields.setStyle("-fx-padding: 20; -fx-background-color: #ffffff;");

        HBox actionButtons = new HBox(20, saveButton, cancelButton);
        actionButtons.setStyle("-fx-alignment: center; -fx-padding: 20;");

        VBox layout = new VBox(30, inputFields, actionButtons, deleteButton);
        layout.setStyle("-fx-padding: 20; -fx-background-color: #ffffff; -fx-alignment: center;");

        scene = new Scene(layout, 440, 562);
    }

    // Getter method to return the Scene object
    public Scene getScene() {
        return scene;
    }
}
