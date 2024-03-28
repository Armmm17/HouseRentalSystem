package com.armmm17.houserentalsystem;

// import javafx things
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


    private HBox hBox;

    private GridPane grid;
    private Label lName, lStreet, lCity, lCap, lOwner, lPrice, lNRoom, lTel;
    private TextField tfName, tfStreet, tfCity, tfCap, tfOwner, tfPrice, tfNRoom, tfTel;
    private StackPane houseCenter;
    private ImageView houseView;

    private StackPane footer;
    private VBox centerFooter;
    private Button publish, back;

    public Owner(Main main){
        this.main = main;
        setBackground(new Background(new BackgroundFill(Paint.valueOf("#e3e3e3"), CornerRadii.EMPTY, Insets.EMPTY)));

        this.hBox = new HBox();

        // FORM CREATION
        this.grid = new GridPane(2,8);
        this.grid.setMinSize(V.WIDTH/2, V.HEIGHT/2);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(25, 25, 25, 25));


        // NameField : TextField
        this.lName = new Label("House name :");
        this.tfName = new TextField();
        this.tfName.setMaxWidth(250);
        this.grid.add(this.lName, 0, 1);
        this.grid.add(this.tfName, 1, 1);


        this.lStreet = new Label("Street :");
        this.tfStreet = new TextField();
        this.tfStreet.setMaxWidth(250);
        this.grid.add(this.lStreet, 0, 2);
        this.grid.add(this.tfStreet, 1, 2);

        this.lCity = new Label("City :");
        this.tfCity = new TextField();
        this.tfCity.setMaxWidth(250);
        this.grid.add(this.lCity, 0, 3);
        this.grid.add(this.tfCity, 1, 3);

        this.lCap = new Label("Cap :");
        this.tfCap = new TextField();
        this.tfCap.setMaxWidth(250);
        this.grid.add(this.lCap, 0, 4);
        this.grid.add(this.tfCap, 1, 4);


        this.lOwner = new Label("Owner :");
        this.tfOwner = new TextField();
        this.tfOwner.setMaxWidth(250);
        this.grid.add(this.lOwner, 0, 5);
        this.grid.add(this.tfOwner, 1, 5);

        this.lPrice = new Label("Price :");
        this.tfPrice = new TextField();
        this.tfPrice.setMaxWidth(250);
        this.grid.add(this.lPrice, 0, 6);
        this.grid.add(this.tfPrice, 1, 6);

        this.lNRoom =new Label("Room :");
        this.tfNRoom = new TextField();
        this.tfNRoom.setMaxWidth(250);
        this.grid.add(this.lNRoom, 0, 7);
        this.grid.add(this.tfNRoom, 1, 7);

        this.lTel = new Label("Tel :");
        this.tfTel = new TextField();
        this.tfTel.setMaxWidth(250);
        this.grid.add(this.lTel, 0, 8);
        this.grid.add(this.tfTel, 1, 8);


        // house ImageView
        Image img = new Image(V.houseImg);
        this.houseCenter = new StackPane();
        this.houseCenter.setMinSize(V.WIDTH/2, V.HEIGHT/2);
        this.houseView = new ImageView(img);
        this.houseView.setFitHeight(250);
        this.houseView.setFitWidth(250);
        

        // "FOOTER" StackPane per centrare, dentro esso VBox per verticale
        this.footer = new StackPane();
        this.centerFooter = new VBox();
        this.centerFooter.setSpacing(10);
        this.centerFooter.setAlignment(Pos.BOTTOM_CENTER);

        // Write on database.csv the information
        this.publish = new Button("Send");
        this.publish.setOnAction(new EventHandler<ActionEvent>() {
            public static final String delimiter = ",";
            @Override
            public void handle(ActionEvent actionEvent) {

                String tutto = "";
                // Reading the database file and temporany saving in local var for append text later

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(V.db));
                    String riga;
                    while ((riga = reader.readLine()) != null) {
                        System.out.println(riga);
                        tutto += riga + "\n";
                    }
                    reader.close();

                    System.out.println("\n\n"+tutto);
                    System.out.println();
                    System.out.println();

                } catch (Exception e){
                    e.printStackTrace();
                }

                // Convert the TextFields to String and format it in CSV
                String append = "";
                append += tfName.getText() + ", " + tfStreet.getText() + ", " + tfCity.getText() + ", " + tfCap.getText() + ", " + tfOwner.getText() + ", " + tfPrice.getText() + ", " + tfNRoom.getText() + ", " + tfNRoom.getText();
                tutto += append;
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(V.db));
                    writer.write(tutto);
                    writer.close();

                    new Alert(Alert.AlertType.CONFIRMATION, "Inviato!").show();


                } catch (Exception e) {
                    e.printStackTrace();
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



    // Aggiunta di tuttto

        // Bottoni dentro il VBox per metterli verticali
        this.centerFooter.getChildren().add(this.publish);
        this.centerFooter.getChildren().add(this.back);

        // VBox dentro stackPane per centrare
        this.footer.getChildren().add(this.centerFooter);

        // ImageView dentro StackPane per centrare
        this.houseCenter.getChildren().add(this.houseView);

        // Grid allinterno dell'HBOX
        this.hBox.getChildren().add(this.grid);
        this.hBox.getChildren().add(this.houseCenter);

        //
        getChildren().add(this.hBox);
        getChildren().add(this.footer);

    }

}
