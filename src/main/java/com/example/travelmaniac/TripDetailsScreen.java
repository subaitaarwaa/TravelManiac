package com.example.travelmaniac;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Activity;
import models.Trip;

public class TripDetailsScreen {
    private Scene scene;

    public TripDetailsScreen(Stage stage, App app, Trip trip) {
        // Header: Trip Details
        Label header = new Label("Trip Details");
        header.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #111417;");

        HBox headerBox = new HBox(header);
        headerBox.setStyle("-fx-padding: 16px; -fx-background-color: #ffffff;");
        headerBox.setAlignment(Pos.CENTER);

        // Trip Info: Name, Destination, Dates
        Label tripNameLabel = new Label("Trip Name: " + trip.tripName);
        tripNameLabel.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #111417;");

        Label destinationLabel = new Label("Destination: " + trip.destination);
        destinationLabel.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 14px; -fx-font-weight: 400; -fx-text-fill: #647587;");

        Label dateRangeLabel = new Label("Dates: " + trip.startDate + " - " + trip.endDate);
        dateRangeLabel.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 14px; -fx-font-weight: 400; -fx-text-fill: #647587;");

        VBox tripInfoBox = new VBox(5, tripNameLabel, destinationLabel, dateRangeLabel);
        tripInfoBox.setStyle("-fx-padding: 16px;");

        // Activities Section
        Label activitiesLabel = new Label("Activities:");
        activitiesLabel.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #111417;");
        
        VBox activitiesList = new VBox(10);
        activitiesList.setStyle("-fx-padding: 16px; -fx-background-color: #f9f9f9; -fx-border-radius: 12px; -fx-border-color: #eff2f4;");

        for (Activity activity : trip.activities) {
            VBox activityBox = createActivityBox(activity);
            activitiesList.getChildren().add(activityBox);
        }

        // Buttons: Add Activity, Back
        Button addActivityButton = new Button("Add Activity");
        addActivityButton.setStyle("-fx-background-color: #13477b; -fx-text-fill: white; -fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 12px 20px; -fx-border-radius: 12px;");
        addActivityButton.setOnAction(e -> app.showAddActivityScreen(trip)); // Pass the current trip

        Button backButton = new Button("Back to Dashboard");
        backButton.setStyle("-fx-background-color: #f0f2f4; -fx-text-fill: #111417; -fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 12px 20px; -fx-border-radius: 12px;");
        backButton.setOnAction(e -> app.showDashboard());

        HBox buttonBox = new HBox(20, addActivityButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setStyle("-fx-padding: 16px;");

        // Main Layout
        VBox mainLayout = new VBox(headerBox, tripInfoBox, activitiesLabel, activitiesList, buttonBox);
        mainLayout.setStyle("-fx-background-color: #ffffff;");
        scene = new Scene(mainLayout, 400, 600);
    }

    private VBox createActivityBox(Activity activity) {
        Label activityNameLabel = new Label(activity.activityName);
        activityNameLabel.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #111417;");
        
        Label activityDateLabel = new Label("Date: " + activity.dateTime);
        activityDateLabel.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 12px; -fx-font-weight: 400; -fx-text-fill: #647587;");
        
        VBox activityBox = new VBox(5, activityNameLabel, activityDateLabel);
        activityBox.setStyle("-fx-padding: 12px; -fx-background-color: #ffffff; -fx-border-color: #eff2f4; -fx-border-width: 1px; -fx-border-radius: 12px; -fx-background-radius: 12px;");
        return activityBox;
    }

    public Scene getScene() {
     return scene ;
   }
}
    