package com.example.travelmaniac;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelpSupportScreen {
    private Scene scene;

    public HelpSupportScreen(Stage stage, App app) {
        // Title
        Label helpLabel = new Label("Help and Support");
        helpLabel.setStyle("-fx-font-family: 'Inter'; -fx-font-size: 23px; -fx-font-weight: 700; -fx-text-fill: #000000;");

        // Email information
        Label emailLabel = new Label("Send us an email: travelmaniacs@gmail.com");
        emailLabel.setStyle("-fx-font-family: 'Inter'; -fx-font-size: 15.8px; -fx-font-weight: 700; -fx-text-fill: #000000;");

        // Layout
        VBox layout = new VBox(30, helpLabel, emailLabel);
        layout.setPadding(new Insets(40, 20, 40, 20)); // Add padding around the content
        layout.setStyle("-fx-background-color: #ffffff; -fx-alignment: center-left; -fx-border-radius: 8px;");
        layout.setPrefSize(331, 458); // Match the container dimensions from the HTML

        scene = new Scene(layout, 331, 458);
    }

    public Scene getScene() {
        return scene;
    }
}
