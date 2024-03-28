package com.armmm17.houserentalsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class Customer extends VBox {
    private Main main;
    private Button back;

    public Customer(Main main) {
        this.main = main;


        setBackground(new Background(new BackgroundFill(Paint.valueOf("#e3e3e3"), CornerRadii.EMPTY, Insets.EMPTY)));
        setAlignment(Pos.CENTER);
        this.back = new Button("Go to Main Scene");

        this.back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                main.getStage().setTitle("House Rental System");
                main.getStage().setScene(main.getMain());
            }
        });

        getChildren().add(this.back);
    }

}
