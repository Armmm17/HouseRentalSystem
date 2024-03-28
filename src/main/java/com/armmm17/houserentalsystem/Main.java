package com.armmm17.houserentalsystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Stage stage;

    Scene main;
    Scene owner;
    Scene admin;
    Scene customers;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        //SCENA MAIN
        VBox root = new VBox(25);


        //Instazio Scene figlie
        Owner ow = new Owner(this,20);
        Admin ad = new Admin(this, 20);
        Customer cu = new Customer(this, 20);



        // Instanzio Scene utilizaabili
        this.main = new Scene(root, V.WIDTH, V.HEIGHT);
        this.owner = new Scene(ow, V.WIDTH, V.HEIGHT);
        this.admin = new Scene(ad, V.WIDTH, V.HEIGHT);
        this.customers = new Scene(cu, V.WIDTH, V.HEIGHT);



        //SCENA MAIN
        root.setBackground(new Background(new BackgroundFill(Paint.valueOf("grey"), CornerRadii.EMPTY, Insets.EMPTY)));
        root.setAlignment(Pos.CENTER);
        Button goToOwner = new Button("Go to Owner");
        goToOwner.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(owner);
            }
        });

        Button goToAdmin = new Button("Go to Admin");
        goToAdmin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(admin);
            }
        });

        Button goToCustomers = new Button("Go to Customers");
        goToCustomers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(customers);
            }
        });



        root.getChildren().add(goToOwner);
        root.getChildren().add(goToAdmin);
        root.getChildren().add(goToCustomers);



        stage.setResizable(false);
        stage.setTitle("House Rental System");
        stage.setScene(main);
        stage.show();
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getMain() {
        return main;
    }

    public static void main(String[] args) {
        launch();
    }
}