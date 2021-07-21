package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    @FXML
    Button reset;

    @FXML
    Button changeScene;

    int i=0;
    int menCounter=0;
    int womenCounter=0;
    int resultShowCounter=0;

    //MenPreference
    TextField [][] menTextFieldArray;
    //Women textfield
    TextField [][] womenTextFieldArray;





    private int N, engagedCount;

    private String[][] menPref;

    private String[][] womenPref;

    private String[] men;

    private String[] women;

    private String[] womenPartner;

    private boolean[] menEngaged;

    public void AddHboxForMenPreference(ActionEvent actionEvent) {

        if(char_number_of_column.getText().isBlank() || char_number_of_row.getText().isBlank())
        {
            show_error.setText("fill column and row");
            return;
        }
        int_number_of_column=Integer.parseInt(char_number_of_column.getText());
        int_number_of_row=Integer.parseInt(char_number_of_row.getText());
        menCounter++;
        if(menCounter>1){
            show_error2.setText("Ii is Max");
            return;
        }

        if(int_number_of_column !=int_number_of_row){
            show_error.setText("Row and Column must be equal");
            return;
        }
        show_error.setText("");
        menTextFieldArray= new TextField[int_number_of_row][int_number_of_column+1];
        for(int i=0;i<int_number_of_row;i++) {
            HBox hb= new HBox();
            for (int j = 0; j <= int_number_of_row; j++) {
                menTextFieldArray[i][j] = new TextField();
                int countMen=i+1;
                if (j == 0) {
                    menTextFieldArray[i][j].setPromptText(" Man " + countMen);
                } else {
                    menTextFieldArray[i][j].setPromptText(j + " Rank Woman");
                }
                hb.getChildren().add(menTextFieldArray[i][j]);

            }
            myVBox1.getChildren().add(hb);

        }
    }

    public void AddHboxForWomenPreference(ActionEvent actionEvent) {

        if(char_number_of_column.getText().isBlank() || char_number_of_row.getText().isBlank())
        {
            show_error.setText("fill column and row");
            return;
        }
        int_number_of_column=Integer.parseInt(char_number_of_column.getText());
        int_number_of_row=Integer.parseInt(char_number_of_row.getText());
        womenCounter++;
        if(womenCounter>1){
            show_error2.setText("Ii is Max");
            return;
        }

        if(int_number_of_column !=int_number_of_row){
            show_error.setText("Row and Column must be equal");
            return;
        }
        show_error.setText("");
        womenTextFieldArray= new TextField[int_number_of_row][int_number_of_column+1];
        for(int i=0;i<int_number_of_row;i++) {
            HBox hb= new HBox();
            for (int j = 0; j <= int_number_of_row; j++) {
                womenTextFieldArray[i][j] = new TextField();
                int countMen=i+1;
                if (j == 0) {
                    womenTextFieldArray[i][j].setPromptText(" Woman " + countMen);
                } else {
                    womenTextFieldArray[i][j].setPromptText(j + " Rank Man");
                }
                hb.getChildren().add(womenTextFieldArray[i][j]);

            }
            myVBox1.getChildren().add(hb);
        }
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
    public void showGale_shapley2(ActionEvent actionEvent){

        menPref= new String[int_number_of_row][int_number_of_column];
        for(int i=0; i<myVBox1.getChildren().size();i++){
            ObservableList<Node> childsHB = myVBox1.getChildren();
            HBox hb = (HBox)childsHB.get(i);
            int colCounter=0;
            for(int j=0; j<hb.getChildren().size();j++){
                TextField tf = (TextField)childsHB.get(j);
                menPref[i][colCounter]=tf.getText();
                System.out.println( "Men"+menPref[i][colCounter] );
                colCounter++;
            }
        }
       // GaleShapley gs= new GaleShapley(men,women,menPref,womenPref);
       // gs.calcMatches();
    }
    public void showGale_shapley(ActionEvent actionEvent){
        menPref= new String[int_number_of_row][int_number_of_column];
        men=new String[int_number_of_row];
        womenPref= new String[int_number_of_row][int_number_of_column];
        women=new String[int_number_of_row];

        int countMen =0;
        int countWomen=0;

        //textFieldArray= new TextField [int_number_of_row][int_number_of_column];
        for(int i=0; i<menTextFieldArray.length;i++){
            for(int j=0; j<menTextFieldArray[0].length;j++) {
                if (j == 0) {
                    men[countMen] = menTextFieldArray[i][j].getText();
                    System.out.println("Men " + menTextFieldArray[i][j].getText());
                    countMen++;
                } else {
                    menPref[i][j - 1] = menTextFieldArray[i][j].getText();
                    System.out.println("table " + menTextFieldArray[i][j].getText());
                    //countWomen++;
                }
            }
        }
        for(int i=0; i<womenTextFieldArray.length;i++){
            for(int j=0; j<womenTextFieldArray[0].length;j++) {
                if (j == 0) {
                    women[countWomen] = womenTextFieldArray[i][j].getText();
                    System.out.println("Women " + womenTextFieldArray[i][j].getText());
                    countWomen++;
                } else {
                    womenPref[i][j - 1] = womenTextFieldArray[i][j].getText();
                    System.out.println("table " + womenTextFieldArray[i][j].getText());
                    //countWomen++;
                }
            }
        }
         GaleShapley gs= new GaleShapley(men,women,menPref,womenPref);
         gs.calcMatches();
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
    public void reset (){
        myVBox1.getChildren().clear();
        resultShowCounter=0;
        menCounter=0;
        womenCounter=0;
    }
//    public void changeSceneMethod(){
//        Stage stage =new Stage();
//        FirstGUI gu=new FirstGUI();
//        gu.start(stage);
//    }

















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
