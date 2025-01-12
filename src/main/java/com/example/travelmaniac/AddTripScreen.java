
package com.example.travelmaniac;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Trip;

public class AddTripScreen {
    private Scene scene;

    public AddTripScreen(Stage stage, App app) {
        // Input fields
        TextField tripNameField = new TextField();
        tripNameField.setPromptText("Trip name");
        tripNameField.setStyle("-fx-padding: 16px; -fx-background-radius: 12px; -fx-border-color: #dce0e5; -fx-border-radius: 12px;");

        TextField destinationField = new TextField();
        destinationField.setPromptText("Destination");
        destinationField.setStyle("-fx-padding: 16px; -fx-background-radius: 12px; -fx-border-color: #dce0e5; -fx-border-radius: 12px;");

        TextField startDateField = new TextField();
        startDateField.setPromptText("Start Date");
        startDateField.setStyle("-fx-padding: 16px; -fx-background-radius: 12px; -fx-border-color: #dce0e5; -fx-border-radius: 12px;");

        TextField endDateField = new TextField();
        endDateField.setPromptText("End Date");
        endDateField.setStyle("-fx-padding: 16px; -fx-background-radius: 12px; -fx-border-color: #dce0e5; -fx-border-radius: 12px;");

        // Save Button
        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #f0f2f4; -fx-border-radius: 12px; -fx-font-weight: bold; -fx-padding: 10 20;");
        saveButton.setOnAction(e -> {
            try {
                String tripName = tripNameField.getText();
                String destination = destinationField.getText();
                String startDate = startDateField.getText();
                String endDate = endDateField.getText();

                // Validate inputs
                if (tripName.isEmpty() || destination.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
                    throw new IllegalArgumentException("All fields must be filled out.");
                }

                // Save the trip
                Trip newTrip = new Trip(tripName, destination, startDate, endDate);
                App.trips.add(newTrip);
                System.out.println("Trip saved: " + tripName);

                // Go back to dashboard after saving
                app.showDashboard();
            } catch (IllegalArgumentException ex) {
                // Show alert if any exception occurs
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText("Invalid Input");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        });

        // Back to Dashboard Button
        Button backButton = new Button("Back to Dashboard");
        backButton.setStyle("-fx-background-color: #13477b; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-padding: 10 20; -fx-border-radius: 12px;");
        backButton.setOnAction(e -> {
            try {
                app.showDashboard(); // Navigate back to dashboard
            } catch (Exception ex) {
                // Exception handling for navigation
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Navigation Error");
                alert.setHeaderText("Unable to navigate");
                alert.setContentText("An error occurred while navigating to the dashboard.");
                alert.showAndWait();
            }
        });

        // Layout
        VBox inputFields = new VBox(20, tripNameField, destinationField, startDateField, endDateField);
        inputFields.setStyle("-fx-padding: 20; -fx-background-color: #ffffff;");
        
        HBox buttons = new HBox(20, backButton, saveButton);
        buttons.setStyle("-fx-padding: 20; -fx-alignment: center;");
        
        VBox layout = new VBox(30, inputFields, buttons);
        layout.setStyle("-fx-padding: 20; -fx-background-color: #ffffff; -fx-alignment: center;");
        
        scene = new Scene(layout, 500, 700);
    }

    public Scene getScene() {
        return scene;
    }
}
