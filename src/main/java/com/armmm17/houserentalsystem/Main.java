package com.armmm17.houserentalsystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
        VBox root = new VBox(20);


        //Instazio Scene figlie
        Owner ow = new Owner(this);
        Admin ad = new Admin(this);
        Customer cu = new Customer(this);



        // Instanzio Scene utilizaabili
        this.main = new Scene(root, V.WIDTH, V.HEIGHT);
        this.owner = new Scene(ow, V.WIDTH, V.HEIGHT);
        this.admin = new Scene(ad, V.WIDTH, V.HEIGHT+300);
        this.customers = new Scene(cu, V.WIDTH, V.HEIGHT);



        //SCENA MAIN
        root.setBackground(new Background(new BackgroundFill(Paint.valueOf("grey"), CornerRadii.EMPTY, Insets.EMPTY)));
        root.setAlignment(Pos.CENTER);

        //Cambia scena / Naviga
        Button goToOwner = new Button("Go to Owner");
        goToOwner.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setTitle("Insert House - HouseRentalSystem");
                stage.setScene(owner);
            }
        });

        Button goToAdmin = new Button("Go to Admin");
        goToAdmin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setTitle("Admin Panel - HouseRentalSystem");
                stage.setScene(admin);
            }
        });

        Button goToCustomers = new Button("Go to Customers");
        goToCustomers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setTitle("Find House - HouseRentalSystem");
                stage.setScene(customers);
            }
        });



        root.getChildren().add(goToOwner);
        root.getChildren().add(goToAdmin);
        root.getChildren().add(goToCustomers);



        stage.setResizable(false);
        stage.setTitle("House Rental System");
        stage.getIcons().add(new Image(V.houseImg));
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