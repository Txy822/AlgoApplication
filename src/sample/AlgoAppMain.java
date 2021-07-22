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
        Pane myPaneAlgo = (Pane)FXMLLoader.load(getClass().getResource
                ("algoAppFxml.fxml"));
        Pane myPaneGaleShapley = (Pane)FXMLLoader.load(getClass().getResource
                ("galeShapley.fxml"));
        Pane myPaneHome = (Pane)FXMLLoader.load(getClass().getResource
                ("Home.fxml"));
        Scene mySceneAlgo = new Scene(myPaneAlgo);
        Scene mySceneGaleShapley = new Scene(myPaneGaleShapley);

        Button back = new Button("Back ..");
        back.setPrefWidth(100.0);
        back.setPrefHeight(100.0);
        Button forth = new Button(".. forth.");
        forth.setPrefWidth(100.0);
        forth.setPrefHeight(100.0);
        Button galeShapleyButton = new Button(".. GaleShapley.");
        galeShapleyButton.setPrefWidth(100.0);
        galeShapleyButton.setPrefHeight(100.0);
        Button weightedIntervalSchedulingButton = new Button(".. weightedIntervalScheduling.");
        weightedIntervalSchedulingButton.setPrefWidth(100.0);
        weightedIntervalSchedulingButton.setPrefHeight(100.0);


        Scene mySceneBack = new Scene(back);
        Scene mySceneForth = new Scene(forth);
        Scene galeShapleyScene = new Scene(galeShapleyButton);
        Scene weightedIntervalSchedulingScene = new Scene(weightedIntervalSchedulingButton);


        back.setOnAction(actionEvent -> primaryStage.setScene(mySceneBack));
        forth.setOnAction(actionEvent -> primaryStage.setScene(mySceneGaleShapley));
        galeShapleyButton.setOnAction(actionEvent -> primaryStage.setScene(galeShapleyScene));
        weightedIntervalSchedulingButton.setOnAction(actionEvent -> primaryStage.setScene(weightedIntervalSchedulingScene));

        mySceneForth.setCursor(Cursor.CROSSHAIR);
        primaryStage.setScene(mySceneForth);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

