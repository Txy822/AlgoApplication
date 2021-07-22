package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
public class AlgoAppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AlgoApp");
        Pane myPane2 = (Pane)FXMLLoader.load(getClass().getResource
                ("algoAppFxml.fxml"));
        Pane myPane = (Pane)FXMLLoader.load(getClass().getResource
                ("galeShapley.fxml"));
        Scene myScene1 = new Scene(myPane);
        Scene myScene21 = new Scene(myPane2);
        Button back = new Button("Back ..");
        back.setPrefWidth(100.0);
        back.setPrefHeight(100.0);
        Button forth = new Button(".. forth.");
        forth.setPrefWidth(100.0);
        forth.setPrefHeight(100.0);


        Scene myScene = new Scene(back);
        Scene myScene2 = new Scene(forth);
        back.setOnAction(actionEvent -> primaryStage.setScene(myScene2)
        );

            forth.setOnAction(actionEvent -> primaryStage.setScene(myScene21)
            );


        myScene.setCursor(Cursor.CROSSHAIR);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

