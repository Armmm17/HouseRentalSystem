package com.armmm17.houserentalsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Admin extends VBox {

    private Main main;

    private Label title;

    private GridPane grid;
   // HouseCard generate sul momento
    private HouseCard h1, h2, h3, h4, h5, h6, h7, h8;

    private Button back;

    public Admin(Main main) {
        this.main = main;


        setBackground(new Background(new BackgroundFill(Paint.valueOf("#e3e3e3"), CornerRadii.EMPTY, Insets.EMPTY)));
        setAlignment(Pos.CENTER);
        setPadding(new Insets(15));
        setSpacing(11);


        HBox hbox = new HBox();
        hbox.setAlignment(Pos.TOP_CENTER);
        this.title = new Label("Manage Rentals");
        this.title.setFont(Font.font("", FontWeight.BOLD, 20));
        this.title.setAlignment(Pos.TOP_CENTER);
        hbox.getChildren().add(this.title);





        this.grid = new GridPane(4,2); //impostare row in base al numero di case/app momentaneo
        this.grid.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;"+
                "-fx-border-color: black;");
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setMinWidth(600);
        this.grid.setMaxWidth(600);
        this.grid.setMinHeight(300);
        this.grid.setMaxHeight(300);
        this.grid.setAlignment(Pos.CENTER);

        this.h1 = new HouseCard(this);
        this.h2 = new HouseCard(this);
        this.h3 = new HouseCard(this);
        this.h4 = new HouseCard(this);
        this.h5 = new HouseCard(this);
        this.h6 = new HouseCard(this);
        this.h7 = new HouseCard(this);
        this.h8 = new HouseCard(this);


        this.grid.add(this.h1, 0, 1);
        this.grid.add(this.h2, 1, 1);
        this.grid.add(this.h3, 2, 1);
        this.grid.add(this.h4, 3, 1);
        this.grid.add(this.h5, 0, 2);
        this.grid.add(this.h6, 1, 2);
        this.grid.add(this.h7, 2, 2);
        this.grid.add(this.h8, 3, 2);








        this.back = new Button("Go to Main Scene");

        this.back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                main.getStage().setTitle("House Rental System");
                main.getStage().setScene(main.getMain());
            }
        });


        getChildren().add(hbox);
        getChildren().add(this.grid);
        getChildren().add(this.back);
    }
}
