package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.*;

public class AlgoAppController {

    @FXML
    private TextField char_number_of_column;
    @FXML
    private TextField char_number_of_row;

    @FXML
    private Label show_error;

    @FXML
    private Label show_error2;


    private int int_number_of_column;
    private int int_number_of_row;

    @FXML
    AnchorPane myAnchorPane;
    @FXML
    VBox myVBox1;
    @FXML
    HBox myHBox1;
    @FXML
    HBox myHBox2;
    @FXML
    HBox myHBox3;
    @FXML
    HBox myHBox4;
    @FXML
    HBox myHBox5;
    @FXML
    HBox myHBox6;
    @FXML
    HBox myHBox7;
    @FXML
    HBox myHBox8;
    @FXML
    HBox myHBox9;
    @FXML
    HBox myHBox10;
    @FXML
    HBox myHBox11;
    @FXML
    HBox myHBox12;
    @FXML
    HBox myHBox13;
    @FXML
    HBox myHBox14;
    @FXML
    HBox myHBox15;
    @FXML
    Button addRow;
    @FXML
    Button addColumn;

    @FXML
    Button deleteRow;
    @FXML
    Button deleteColumn;

    @FXML
    Button result;

    int i=0;
    int menCounter=0;
    int resultShowCounter=0;


    public void AddHbox(ActionEvent actionEvent) {
        int_number_of_column=Integer.parseInt(char_number_of_column.getText());
        int_number_of_row=Integer.parseInt(char_number_of_row.getText());
        menCounter++;
        if(menCounter>int_number_of_row){
            show_error2.setText("Ii is Max");
            return;
        }

        if(int_number_of_column !=int_number_of_row){
            show_error.setText("Row and Column must be equal");
            return;
        }
        show_error.setText("");
        //TextField txarray[]= new TextField[int_number_of_column];
        HBox hb= new HBox();
        for(int i=0;i<=int_number_of_row;i++){
            TextField txtFiled= new TextField();
            if(i==0) {
                txtFiled.setPromptText(" Men "+menCounter);
                hb.getChildren().add(txtFiled);
            }
            else{
                txtFiled.setPromptText(i+" Rank Woman");
                hb.getChildren().add(txtFiled);
            }
        }
        myVBox1.getChildren().add(hb);
    }
    public void result(ActionEvent actionEvent){

        resultShowCounter++;
        if(resultShowCounter>1){
            return;
        }
        HashMap<String, String> map=map();

        Set set = map.entrySet();

        Iterator iterator = set.iterator();

        for(int i=0;i<map.size();i++){
            HBox hb= new HBox();
            Map.Entry mentry = (Map.Entry)iterator.next();
                TextField textFiled_one= new TextField();
                textFiled_one.setText(mentry.getKey().toString());

                TextField textFiled_two= new TextField();
                textFiled_two.setText(mentry.getValue().toString());

                hb.getChildren().addAll(textFiled_one,textFiled_two);

            myVBox1.getChildren().add(hb);
        }

    }
    public HashMap<String, String> map(){

        /* This is how to declare HashMap */
        HashMap<String, String> hmap = new HashMap<String, String>();

        /*Adding elements to HashMap*/
        hmap.put("me1", "Chaitanya");
        hmap.put("m2", "Rahul");
        hmap.put("m3", "Singh");
        hmap.put("me4", "Ajeet");
        hmap.put("m5", "Anuj");

     return  hmap;
    }
    public void addRow1(ActionEvent actionEvent) {
        myHBox1.getChildren().add(new TextField());
    }
    public void addRow2(ActionEvent actionEvent) {
        myHBox2.getChildren().add(new TextField());
    }
    public void addRow3(ActionEvent actionEvent) {
        myHBox3.getChildren().add(new TextField());
    }
    public void addRow4(ActionEvent actionEvent) {
        myHBox4.getChildren().add(new TextField());
    }
    public void addRow5(ActionEvent actionEvent) {
        myHBox5.getChildren().add(new TextField());
    }
    public void addRow6(ActionEvent actionEvent) {
        myHBox6.getChildren().add(new TextField());
    }
    public void addRow7(ActionEvent actionEvent) {
        myHBox7.getChildren().add(new TextField());
    }
    public void addRow8(ActionEvent actionEvent) {
        myHBox8.getChildren().add(new TextField());
    }
    public void addRow9(ActionEvent actionEvent) {
        myHBox9.getChildren().add(new TextField());
    }
    public void addRow10(ActionEvent actionEvent) {
        myHBox10.getChildren().add(new TextField());
    }
    public void addRow11(ActionEvent actionEvent) {
        myHBox11.getChildren().add(new TextField());
    }
    public void addRow12(ActionEvent actionEvent) {
        myHBox12.getChildren().add(new TextField());
    }
    public void addRow13(ActionEvent actionEvent) {
        myHBox13.getChildren().add(new TextField());
    }
    public void addRow14(ActionEvent actionEvent) {
        myHBox14.getChildren().add(new TextField());
    }
    public void addRow15(ActionEvent actionEvent) {
        myHBox15.getChildren().add(new TextField());
    }


}
