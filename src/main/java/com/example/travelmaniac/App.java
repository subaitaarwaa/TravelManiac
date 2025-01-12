package com.example.travelmaniac;

import models.Trip;
import models.User;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;

public class App extends Application {
    public static ArrayList<Trip> trips = new ArrayList<>(); // Global trip list
    public static ArrayList<User> users = new ArrayList<>(); // Global user list
    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        // Sample users for testing
        users.add(new User("admin", "password"));
        users.add(new User("testuser", "1234"));

        // Sample trips for testing
        trips.add(new Trip("New York, NY", "NY", "2025-01-07", "2025-01-12"));
        trips.add(new Trip("San Francisco, CA", "CA", "2025-02-02", "2025-02-06"));

        showLoginScreen(); // Start the application with the LoginScreen
    }

    // Show Login Screen
    public void showLoginScreen() {
        LoginScreen loginScreen = new LoginScreen(primaryStage, this);
        primaryStage.setScene(loginScreen.getScene());
        primaryStage.setTitle("TravelManiac - Login");
        primaryStage.show();
    }

    // Show Sign-Up Screen
    public void showSignUpScreen() {
        SignUpScreen signUpScreen = new SignUpScreen(primaryStage, this);
        primaryStage.setScene(signUpScreen.getScene());
        primaryStage.setTitle("Sign Up");
    }

    // Show Dashboard
    public void showDashboard() {
        DashboardScreen dashboardScreen = new DashboardScreen(primaryStage, this);
        primaryStage.setScene(dashboardScreen.getScene());
        primaryStage.setTitle("TravelManiac - Dashboard");
    }

    // Show Add Trip Screen
    public void showAddTripScreen() {
        AddTripScreen addTripScreen = new AddTripScreen(primaryStage, this);
        primaryStage.setScene(addTripScreen.getScene());
        primaryStage.setTitle("Add New Trip");
    }

    // Show Trip Details Screen
    public void showTripDetails(Trip trip) {
        TripDetailsScreen tripDetailsScreen = new TripDetailsScreen(primaryStage, this, trip);
        primaryStage.setScene(tripDetailsScreen.getScene());
        primaryStage.setTitle("Trip Details");
    }

    // Show Edit Trip Details Screen
    public void showEditTripScreen(Trip trip) {
        EditTripDetailsScreen editTripDetailsScreen = new EditTripDetailsScreen(primaryStage, trip);
        primaryStage.setScene(editTripDetailsScreen.getScene());
        primaryStage.setTitle("Edit Trip Details");
    }

    // Show Add Activity Screen
    public void showAddActivityScreen(Trip trip) {
        AddActivityScreen addActivityScreen = new AddActivityScreen(primaryStage, this, trip);
        primaryStage.setScene(addActivityScreen.getScene());
        primaryStage.setTitle("Add New Activity");
    }

    // Show Profile Screen
    public void showProfileScreen() {
        ProfileScreen profileScreen = new ProfileScreen(primaryStage, this);
        primaryStage.setScene(profileScreen.getScene());
        primaryStage.setTitle("Profile & Settings");
    }

    // Show Edit Profile Screen
    public void showEditProfileScreen() {
        EditProfileScreen editProfileScreen = new EditProfileScreen(primaryStage, this);
        primaryStage.setScene(editProfileScreen.getScene());
        primaryStage.setTitle("Edit Profile");
    }

    // Show Help & Support Screen
    public void showHelpSupportScreen() {
        HelpSupportScreen helpSupportScreen = new HelpSupportScreen(primaryStage, this);
        primaryStage.setScene(helpSupportScreen.getScene());
        primaryStage.setTitle("Help & Support");
    }

    public static void main(String[] args) {
        launch(args); 
    }
}