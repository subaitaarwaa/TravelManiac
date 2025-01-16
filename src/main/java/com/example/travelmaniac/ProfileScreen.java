package com.example.travelmaniac;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProfileScreen {
    private Scene scene;

    public ProfileScreen(Stage stage, App app) {
        javafx.scene.text.Text title = new javafx.scene.text.Text("Profile and Settings");
        Button editProfileButton = new Button("Edit Profile");
        Button helpSupportButton = new Button("Help & Support");
        Button deleteProfileButton = new Button("Delete Profile");
        Button backToDashboardButton = new Button("Back to Dashboard");
        
        title.setStyle("-fx-font-family: 'Inter'; -fx-font-size: 23px; -fx-font-weight: 700; -fx-fill: #333333;");
        editProfileButton.setStyle("-fx-background-color: #dddddd; -fx-font-family: 'Inter'; -fx-font-size: 11px; -fx-font-weight: 400; -fx-text-fill: #333333; -fx-border-radius: 4px; -fx-padding: 10px 20px;");
        helpSupportButton.setStyle("-fx-background-color: #007bff; -fx-font-family: 'Inter'; -fx-font-size: 11px; -fx-font-weight: 300; -fx-text-fill: #ffffff; -fx-border-radius: 4px; -fx-padding: 10px 20px;");
        deleteProfileButton.setStyle("-fx-background-color: #ff0000; -fx-font-family: 'Inter'; -fx-font-size: 15px; -fx-font-weight: 400; -fx-text-fill: #ffffff; -fx-border-radius: 4px; -fx-padding: 10px 20px;");
        backToDashboardButton.setStyle("-fx-background-color: #13477b; -fx-text-fill: white; -fx-font-family: 'Plus Jakarta Sans'; -fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 12px 20px; -fx-border-radius: 12px;");
        editProfileButton.setOnAction(e -> app.showEditProfileScreen());
        helpSupportButton.setOnAction(e -> app.showHelpSupportScreen());
        backToDashboardButton.setOnAction(e -> app.showDashboard());
        
        
        deleteProfileButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Profile");
            alert.setHeaderText("Are you sure?");
            alert.setContentText("This action cannot be undone.");
            alert.showAndWait();});
        

        
        VBox buttons = new VBox(20, editProfileButton, helpSupportButton, deleteProfileButton, backToDashboardButton);
        buttons.setPadding(new Insets(20));
        buttons.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 8px; -fx-background-radius: 8px; -fx-border-color: rgba(0, 0, 0, 0.1); -fx-border-width: 1;");
        buttons.setPrefWidth(440);

        VBox layout = new VBox(30, title, buttons);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #f7f7f7; -fx-alignment: center;");

        scene = new Scene(layout, 440, 562);
    }

    public Scene getScene() {
        return scene;
    }
}
