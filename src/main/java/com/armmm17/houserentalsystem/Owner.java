package com.armmm17.houserentalsystem;

// import javafx things
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

// import other things
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.*;
import java.util.ArrayList;

public class Owner extends VBox {
    private Main main;
    private Button publish, back;
    private Label lName, lStreet, lOwner, lPrice, lNRoom;
    private TextField tfName, tfStreet, tfOwner, tfPrice, tfNRoom;


    public Owner(Main main, double spacing){
        super(spacing);
        this.main = main;
        setBackground(new Background(new BackgroundFill(Paint.valueOf("#e3e3e3"), CornerRadii.EMPTY, Insets.EMPTY)));
        //setAlignment(Pos.CENTER);

        // FORM CREATION
        GridPane grid = new GridPane(2,5);
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        // NameField : TextField
        this.lName = new Label("Nome casa :");
        this.tfName = new TextField();
        this.tfName.setMaxWidth(250);
        grid.add(this.lName, 0, 1);
        grid.add(this.tfName, 1, 1);

        this.lStreet = new Label("Street :");
        this.tfStreet = new TextField();
        this.tfStreet.setMaxWidth(250);
        grid.add(this.lStreet, 0, 2);
        grid.add(this.tfStreet, 1, 2);

        this.lOwner = new Label("Nome casa :");
        this.tfOwner = new TextField();
        this.tfOwner.setMaxWidth(250);
        grid.add(this.lOwner, 0, 3);
        grid.add(this.tfOwner, 1, 3);

        this.lPrice = new Label("Prezzo :");
        this.tfPrice = new TextField();
        this.tfPrice.setMaxWidth(250);
        grid.add(this.lPrice, 0, 4);
        grid.add(this.tfPrice, 1, 4);

        this.lNRoom =new Label("Room :");
        this.tfNRoom = new TextField();
        this.tfNRoom.setMaxWidth(250);
        grid.add(this.lNRoom, 0, 5);
        grid.add(this.tfNRoom, 1, 5);




        StackPane backPane = new StackPane();
        VBox centerBack = new VBox();
        centerBack.setSpacing(15);
        centerBack.setAlignment(Pos.BOTTOM_CENTER);

        // Write on database.csv the information
        this.publish = new Button("Send");
        this.publish.setOnAction(new EventHandler<ActionEvent>() {
            public static final String delimiter = ",";
            @Override
            public void handle(ActionEvent actionEvent) {



                System.out.println("Premuto");

                try {
                    File file = new File("database.csv");
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line = "";
                    String[] tempArr;
                    while((line = br.readLine()) != null) {
                        tempArr = line.split(delimiter);
                        for(String tempStr : tempArr) {
                            System.out.print(tempStr + " ");
                        }
                        System.out.println();
                    }
                    br.close();
                } catch (Exception e) {

                }

            }

        });


        // Go back to main Scene
        this.back = new Button("Go to Main Scene");
        this.back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                main.getStage().setTitle("House Rental System");
                main.getStage().setScene(main.getMain());
            }
        });

        centerBack.getChildren().add(this.publish);
        centerBack.getChildren().add(this.back);


        backPane.getChildren().add(centerBack);

        getChildren().add(grid);
        getChildren().add(backPane);

    }

}
