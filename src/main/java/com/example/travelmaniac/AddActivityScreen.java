package com.example.travelmaniac;

import models.Activity;
import models.Trip;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddActivityScreen {
    private Scene scene;

    // Updated constructor to accept Trip and include inline design
    public AddActivityScreen(Stage stage, App app, Trip trip) {
        TextField activityNameField = new TextField();
        activityNameField.setPromptText("Enter activity name");
        activityNameField.setStyle("-fx-background-color: #eff2f4; -fx-border-radius: 12px; -fx-padding: 8px; -fx-font-size: 16px;");

        TextField dateField = new TextField();
        dateField.setPromptText("Enter date");
        dateField.setStyle("-fx-background-color: #eff2f4; -fx-border-radius: 12px; -fx-padding: 8px; -fx-font-size: 16px;");

        Button saveButton = new Button("Save Activity");
        saveButton.setStyle("-fx-background-color: #13477b; -fx-text-fill: white; -fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 12px 20px; -fx-border-radius: 12px;");
        saveButton.setOnAction(e -> {
            // Add the new activity to the trip's activities list
            Activity activity = new Activity(activityNameField.getText(), dateField.getText());
            trip.activities.add(activity); // Add activity to the trip
            System.out.println("Activity saved: " + activity.activityName);

            // Navigate back to the Trip Details screen
            app.showTripDetails(trip);
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: #f0f2f4; -fx-text-fill: #111417; -fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 12px 20px; -fx-border-radius: 12px;");
        cancelButton.setOnAction(e -> app.showTripDetails(trip)); // Navigate back without saving

        VBox layout = new VBox(20, activityNameField, dateField, saveButton, cancelButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px; -fx-background-color: #ffffff; -fx-spacing: 16px;");

        scene = new Scene(layout, 400, 300);
    }

    public Scene getScene() {
     return scene ; 
    }
}