package com.example.travelmaniac;

import models.Trip;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditTripDetailsScreen {
    private Scene scene;

    public EditTripDetailsScreen(Stage stage, Trip trip) {
        // Input fields pre-filled with trip details
        TextField tripNameField = new TextField(trip.tripName);
        tripNameField.setStyle("-fx-padding: 16px; -fx-background-radius: 12px; -fx-border-color: #dce0e5; -fx-border-radius: 12px;");
        tripNameField.setPromptText("Trip name");

        TextField destinationField = new TextField(trip.destination);
        destinationField.setStyle("-fx-padding: 16px; -fx-background-radius: 12px; -fx-border-color: #dce0e5; -fx-border-radius: 12px;");
        destinationField.setPromptText("Destination");

        TextField startDateField = new TextField(trip.startDate);
        startDateField.setStyle("-fx-padding: 16px; -fx-background-radius: 12px; -fx-border-color: #dce0e5; -fx-border-radius: 12px;");
        startDateField.setPromptText("Start Date");

        TextField endDateField = new TextField(trip.endDate);
        endDateField.setStyle("-fx-padding: 16px; -fx-background-radius: 12px; -fx-border-color: #dce0e5; -fx-border-radius: 12px;");
        endDateField.setPromptText("End Date");

        // Save Button
        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #f0f2f4; -fx-border-radius: 12px; -fx-font-weight: bold; -fx-padding: 10 20;");
        saveButton.setOnAction(e -> {
            // Directly update the trip details
            trip.tripName = tripNameField.getText();
            trip.destination = destinationField.getText();
            trip.startDate = startDateField.getText();
            trip.endDate = endDateField.getText();
            System.out.println("Trip updated: " + trip.tripName);
        });

        // Back Button
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #13477b; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-padding: 10 20; -fx-border-radius: 12px;");
        backButton.setOnAction(e -> stage.close()); // Close the window or navigate back as needed

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
