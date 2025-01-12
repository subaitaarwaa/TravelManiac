package com.example.travelmaniac;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Trip;

public class DashboardScreen {
    private Scene scene;

    public DashboardScreen(Stage stage, App app) {
        // Header
        Label header = new Label("Trips");
        header.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #111416;");

        HBox headerBox = new HBox(header);
        headerBox.setStyle("-fx-padding: 16px;");
        headerBox.setAlignment(Pos.CENTER_LEFT);

        // Layout for displaying trips
        VBox tripList = new VBox(16);
        tripList.setStyle("-fx-padding: 16px;");

        // Loop through the list of trips and dynamically create UI for each trip
        for (Trip trip : App.trips) {
            VBox tripBox = createTripEntry(trip, app, tripList);
            tripList.getChildren().add(tripBox);
        }

        // Add New Trip button
        Button addNewTripButton = new Button("Add New Trip");
        addNewTripButton.setStyle("-fx-background-color: #eff2f4; -fx-border-radius: 12px; -fx-padding: 12px 20px; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #111416;");
        addNewTripButton.setOnAction(e -> app.showAddTripScreen());

        HBox addTripBox = new HBox(addNewTripButton);
        addTripBox.setAlignment(Pos.CENTER);
        addTripBox.setStyle("-fx-padding: 12px;");

        // Profile Button
        Button profileButton = new Button("Profile");
        profileButton.setStyle("-fx-background-color: #11477a; -fx-text-fill: white; -fx-border-radius: 12px; -fx-padding: 12px 20px; -fx-font-size: 14px; -fx-font-weight: bold;");
        profileButton.setOnAction(e -> app.showProfileScreen());

        HBox profileBox = new HBox(profileButton);
        profileBox.setAlignment(Pos.CENTER);
        profileBox.setStyle("-fx-padding: 12px;");

        // Main layout
        VBox mainLayout = new VBox(16, headerBox, tripList, addTripBox, profileBox);
        mainLayout.setStyle("-fx-background-color: #ffffff; -fx-padding: 16px;");
        scene = new Scene(mainLayout, 400, 600);
    }

    private VBox createTripEntry(Trip trip, App app, VBox tripList) {
        // Trip Name
        Label tripNameLabel = new Label(trip.tripName);
        tripNameLabel.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #111416;");

        // Trip Dates
        Label tripDatesLabel = new Label(trip.startDate + " - " + trip.endDate);
        tripDatesLabel.setStyle("-fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 14px; -fx-font-weight: 400; -fx-text-fill: #637587;");

        VBox tripDetails = new VBox(4, tripNameLabel, tripDatesLabel);

        // "View Trip" Button
        Button viewTripButton = new Button("View Trip");
        viewTripButton.setStyle("-fx-background-color: #11477a; -fx-text-fill: white; -fx-border-radius: 12px; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-font-weight: bold;");
        viewTripButton.setOnAction(e -> app.showTripDetails(trip));

        // "Edit Trip" Button
        Button editTripButton = new Button("Edit Trip");
        editTripButton.setStyle("-fx-background-color: #eff2f4; -fx-text-fill: #111416; -fx-border-radius: 12px; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-font-weight: bold;");
        editTripButton.setOnAction(e -> app.showEditTripScreen(trip));

        // "Delete Trip" Button
        Button deleteTripButton = new Button("Delete Trip");
        deleteTripButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #ff4d4d; -fx-border-radius: 12px; -fx-padding: 8px 16px; -fx-font-size: 14px; -fx-font-weight: bold;");
        deleteTripButton.setOnAction(e -> {
            // Confirmation and delete logic
            boolean confirm = showDeleteConfirmation(trip.tripName);
            if (confirm) {
                App.trips.remove(trip); // Remove from global list
                tripList.getChildren().remove(tripList.getChildren().indexOf(tripDetails.getParent())); // Remove UI
                System.out.println("Trip deleted: " + trip.tripName);
            }
        });

        // Layout for buttons
        HBox buttonBox = new HBox(10, viewTripButton, editTripButton, deleteTripButton);
        buttonBox.setAlignment(Pos.CENTER_LEFT);

        VBox tripBox = new VBox(10, tripDetails, buttonBox);
        tripBox.setStyle("-fx-padding: 16px; -fx-background-color: #f9f9f9; -fx-border-radius: 12px; -fx-border-color: #eff2f4; -fx-border-width: 1px;");
        return tripBox;
    }

    private boolean showDeleteConfirmation(String tripName) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Confirmation");
        alert.setHeaderText("Are you sure you want to delete this trip?");
        alert.setContentText("Trip: " + tripName);
        alert.showAndWait();
        return alert.getResult() != null && alert.getResult().getText().equals("OK");
    }

    public Scene getScene() {
        return scene;
    }
}
