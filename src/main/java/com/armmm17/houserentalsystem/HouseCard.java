package com.armmm17.houserentalsystem;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;

public class HouseCard extends StackPane {
    public Admin admin;

    private Label label;


    public Customer customer;

    public HouseCard(Admin admin) {
        this.admin = admin;
        setMinSize(550/4, 260/2);
        setMaxSize(550/4, 260/2);
        setBorder(Border.stroke(Paint.valueOf("black")));

        this.label = new Label("House Card");

        getChildren().add(this.label);


    }




    public HouseCard(Customer customer) {
        this.customer = customer;



    }





}
