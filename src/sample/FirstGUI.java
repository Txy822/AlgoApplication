package sample;
////import javafx.application.Application;
////import javafx.event.ActionEvent;
////import javafx.event.EventHandler;
////import javafx.scene.Scene;
////import javafx.scene.control.Button;
////import javafx.scene.control.Label;
////import javafx.scene.layout.StackPane;
////import javafx.scene.layout.VBox;
////import javafx.stage.Stage;
////
////public class FirstGUI extends Application {
////
////    Scene scene1, scene2;
////
////    @Override
////    public void start(Stage primaryStage) {
////
////        primaryStage.setTitle("My First JavaFX GUI");
////
//////Scene 1
////        Label label1= new Label("This is the first scene");
////        Button button1= new Button("Go to scene 2");
////        button1.setOnAction(e -> primaryStage.setScene(scene2));
////        VBox layout1 = new VBox(20);
////        layout1.getChildren().addAll(label1, button1);
////        scene1= new Scene(layout1, 300, 250);
////
//////Scene 2
////        Label label2= new Label("This is the second scene");
////        Button button2= new Button("Go to scene 1");
////        button2.setOnAction(e -> primaryStage.setScene(scene1));
////        VBox layout2= new VBox(20);
////        layout2.getChildren().addAll(label2, button2);
////        scene2= new Scene(layout2,300,250);
////
////
////        primaryStage.setScene(scene1);
////        primaryStage.show();
////    }
////
////    public static void main(String[] args) {
////        launch(args);
////    }
////
////}
//import java.util.ArrayList;
//import java.util.List;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class FirstGUI extends Application {
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        List<TextField> textFieldContainer = new ArrayList();
//
//        primaryStage.setTitle("GridPane Experiment");
//        GridPane gridPane = new GridPane();
//
//        for(int i=0;i<5;i++) {
//            VBox mainVBox = new VBox();
//            VBox vboxgrid1 = new VBox();
//            VBox vboxgrid2 = new VBox();
//            HBox hboxgrid = new HBox();
//            hboxgrid.setPadding(new Insets(5,5,5,5));
//
//            RadioButton rbYes = new RadioButton("Yes");
//            RadioButton rbNo = new RadioButton("No");
//            Label howmanyLabel = new Label("   How many?   ");
//            TextField howManytxtB = new TextField();
//
//            hboxgrid.getChildren().add(rbYes);
//            hboxgrid.getChildren().add(rbNo);
//            hboxgrid.getChildren().add(howmanyLabel);
//            hboxgrid.getChildren().add(howManytxtB);
//
//            vboxgrid1.getChildren().add(hboxgrid);
//
//            final Integer tempRow = i;
//            howManytxtB.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    vboxgrid2.getChildren().clear();
//                    Integer howManyNum = Integer.valueOf(howManytxtB.getText());
//
//                    //The next two lines clears TextFields if you change the amount and/or press enter
//                    textFieldContainer.removeIf(p -> p.getUserData().toString().startsWith("TextField_" + tempRow));
//                    for(int row=0;row<howManyNum;row++) {
//                        //creating rows for entering the new entities
//                        HBox innerRowbox = new HBox();
//                        TextField name = new TextField();
//                        final Integer innerRow = row;
//                        name.setUserData("TextField_" + tempRow + "_" + innerRow);
//                        System.out.println(name.getUserData().toString());
//                        textFieldContainer.add(name);
//                        ComboBox cb = new ComboBox(); //empty cb for now
//                        name.setPromptText("Enter name of the new Entity");
//                        name.setMinWidth(200);
//                        innerRowbox.getChildren().add(name);
//                        innerRowbox.getChildren().add(cb);
//                        vboxgrid2.getChildren().add(innerRowbox);
//                    }
//                }
//
//            });
//
//            mainVBox.getChildren().add(vboxgrid1);
//            mainVBox.getChildren().add(vboxgrid2);
//            gridPane.add(mainVBox,1, i);
//        }
//
//        for(int i=0;i<5;i++) {
//            gridPane.add(new Label("row"+i), 0 , i);
//        }
//
//        Button saveButton = new Button("save content");
//
//        saveButton.setOnAction(e-> {
//            System.out.println("Saving these TextField's Text:");
//            for(TextField textField : textFieldContainer)
//            {
//                System.out.println(textField.getUserData() + ": " + textField.getText());
//            }
//        });
//
//        gridPane.add(saveButton, 1, 5);
//        gridPane.setHgap(10);
//        gridPane.setVgap(10);
//        Scene scene = new Scene(gridPane, 500, 500);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        Application.launch(args);
//    }
//}
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class FirstGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();

        VBox vbox1 = new VBox();
        vbox1.setSpacing(5);//Set vbox spacing

        //Handles the number of row to be added to the vbox
        for(int i = 0; i < 4; i++)
        {
            vbox1.getChildren().add(addNewRow(i));
        }

        root.getChildren().add(vbox1);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    //Method creates all the nodes for a new row.
    HBox addNewRow(int rowNumber)
    {
        //Create nodes and adding correct spaceing
        HBox hbox = new HBox();
        hbox.setSpacing(5);
        RadioButton radioButton = new RadioButton();
        radioButton.setPrefHeight(25);
        TextField textField = new TextField();
        textField.setPrefWidth(40);
        Label label = new Label(Integer.toString(rowNumber + 1));
        label.setPrefHeight(25);
        HBox trailingHBox = new HBox();
        trailingHBox.setSpacing(5);
        hbox.getChildren().addAll(radioButton, textField, label, trailingHBox);

        //Event handler on textfield. Add right about of trailing textfields
        textField.setOnKeyReleased((event)->{
            if(textField.getText().trim().length() > 0 && Integer.parseInt(textField.getText()) > 0)//If textfield has some value greater than zero. I didn't catch for non integers
            {
                int tempInt = Integer.parseInt(textField.getText());
                //clear trailingHBox so that new Trailing hbox can be added
                if(trailingHBox.getChildren().size() > 0)
                {
                    trailingHBox.getChildren().clear();
                }
                //add the correct number of textFields.
                for(int i = 0; i < tempInt - 1; i++)
                {
                    TextField tempTextField = new TextField();
                    tempTextField.setPrefWidth(20);
                    trailingHBox.getChildren().add(tempTextField);
                }

                //add the blue and red textfields
                TextField textFieldBlue = new TextField();
                textFieldBlue.setPrefWidth(40);
                textFieldBlue.setStyle("-fx-background-color: BLUE");
                TextField textFieldRed = new TextField();
                textFieldRed.setPrefWidth(40);
                textFieldRed.setStyle("-fx-background-color: RED");

                trailingHBox.getChildren().addAll(textFieldBlue, textFieldRed);
            }
            else{
                trailingHBox.getChildren().clear();//clear traingHbox if it's has no value
            }
        });

        return hbox;
    }
}