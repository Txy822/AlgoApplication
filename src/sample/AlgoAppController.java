package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AlgoAppController {

    @FXML
    private TextField char_number_of_column;
    @FXML
    private TextField char_number_of_row;

    @FXML
    private Label show_error_one;
    @FXML
    private Label show_error_two;

    @FXML
    private VBox myVBox;

//    @FXML
//    private Button result;
//    @FXML
//    private Button reset;
//    @FXML
//    private Button changeScene;

    private int int_number_of_column;
    private int int_number_of_row;
    private int countNumberOfButtonPressed_menPref=0;
    private int countNumberOfButtonPressed_womenPref=0;
    private int resultShowCounter=0;

    private GaleShapley gs;

    private TextField [][] menPrefTextFieldArray;
    private TextField [][] womenPrefTextFieldArray;


    public void AddHboxForMenPreference() {

        if(char_number_of_column.getText().isBlank() || char_number_of_row.getText().isBlank())
        {
            show_error_one.setText("Enter number of men and women");
            return;
        }
        int_number_of_column=Integer.parseInt(char_number_of_column.getText());
        int_number_of_row=Integer.parseInt(char_number_of_row.getText());
        countNumberOfButtonPressed_menPref++;
        if(countNumberOfButtonPressed_menPref>1){
            show_error_two.setText("Men Preference Entered");
            return;
        }

        if(int_number_of_column !=int_number_of_row){
            show_error_one.setText("Number of Men and Women must be equal");
            return;
        }
        show_error_one.setText("");
        menPrefTextFieldArray= new TextField[int_number_of_row][int_number_of_column+1];
        for(int i=0;i<int_number_of_row;i++) {
            HBox hb= new HBox();
            for (int j = 0; j <= int_number_of_row; j++) {
                menPrefTextFieldArray[i][j] = new TextField();
                int countMen=i+1;
                if (j == 0) {
                    menPrefTextFieldArray[i][j].setPromptText(" Man " + countMen);
                } else {
                    menPrefTextFieldArray[i][j].setPromptText(j + " Rank Woman");
                }
                hb.getChildren().add(menPrefTextFieldArray[i][j]);
            }
            myVBox.getChildren().add(hb);
        }
    }

    public void AddHboxForWomenPreference() {

        if(char_number_of_column.getText().isBlank() || char_number_of_row.getText().isBlank())
        {
            show_error_one.setText("Enter number of men and women");
            return;
        }
        int_number_of_column=Integer.parseInt(char_number_of_column.getText());
        int_number_of_row=Integer.parseInt(char_number_of_row.getText());
        countNumberOfButtonPressed_womenPref++;
        if(countNumberOfButtonPressed_womenPref>1){
            show_error_two.setText("Women Preference Entered");
            return;
        }

        if(int_number_of_column !=int_number_of_row){
            show_error_one.setText("Number of Men and Women must be equal");
            return;
        }
        show_error_one.setText("");
        womenPrefTextFieldArray= new TextField[int_number_of_row][int_number_of_column+1];
        for(int i=0;i<int_number_of_row;i++) {
            HBox hb= new HBox();
            for (int j = 0; j <= int_number_of_row; j++) {
                womenPrefTextFieldArray[i][j] = new TextField();
                int countMen=i+1;
                if (j == 0) {
                    womenPrefTextFieldArray[i][j].setPromptText(" Woman " + countMen);
                } else {
                    womenPrefTextFieldArray[i][j].setPromptText(j + " Rank Man");
                }
                hb.getChildren().add(womenPrefTextFieldArray[i][j]);
            }
            myVBox.getChildren().add(hb);
        }
    }
    @FXML
    public void result(HashMap<String, String> map){

        resultShowCounter++;
        if(resultShowCounter>1){
            return;
        }
        //HashMap<String, String> map=map();

        Set<Map.Entry<String, String>> set = map.entrySet();

        Iterator<Map.Entry<String, String>> iterator = set.iterator();

        for(int i=0;i<map.size();i++){
            HBox hb= new HBox();
            Map.Entry mentry = (Map.Entry)iterator.next();
                TextField textFiled_one= new TextField();
                textFiled_one.setText(mentry.getKey().toString());

                TextField textFiled_two= new TextField();
                textFiled_two.setText(mentry.getValue().toString());

                hb.getChildren().addAll(textFiled_one,textFiled_two);

            myVBox.getChildren().add(hb);
        }

    }
    public void showGale_shapley(){
        String[][] menPref = new String[int_number_of_row][int_number_of_column];
        String[] men = new String[int_number_of_row];
        String[][] womenPref = new String[int_number_of_row][int_number_of_column];
        String[] women = new String[int_number_of_row];

        int countMen =0;
        int countWomen=0;
        if(menPrefTextFieldArray==null || menPrefTextFieldArray.length==0) {
            show_error_two.setText("Please enter man preference");
            return;
        }
        else {
            for(int i=0; i<menPrefTextFieldArray.length;i++){
                for(int j=0; j<menPrefTextFieldArray[0].length;j++) {
                    if(menPrefTextFieldArray[i][j].getText().isBlank()){
                        show_error_two.setText("Please enter all man preference");
                        return;
                    }
                    else {
                        if (j == 0) {
                            men[countMen] = menPrefTextFieldArray[i][j].getText();
                            countMen++;
                        }
                        else {
                            menPref[i][j - 1] = menPrefTextFieldArray[i][j].getText();
                        }
                    }
                }
            }
        }
        if(womenPrefTextFieldArray==null || womenPrefTextFieldArray.length==0){
            show_error_two.setText("Please enter Women preference");
            return;
        }
        else {
            for(int i=0; i<womenPrefTextFieldArray.length;i++){
                for(int j=0; j<womenPrefTextFieldArray[0].length;j++) {
                    if(womenPrefTextFieldArray[i][j].getText().isBlank()){
                        show_error_two.setText("Please enter all Woman preference");
                        return;
                    }
                    else {
                        if (j == 0) {
                            women[countWomen] = womenPrefTextFieldArray[i][j].getText();
                            countWomen++;
                        }
                        else {
                            womenPref[i][j - 1] = womenPrefTextFieldArray[i][j].getText();
                        }
                    }
                }
            }
        }
         gs= new GaleShapley(men, women, menPref, womenPref);
         gs.calcMatches();
         result(gs.men_women_match());;
         show_error_two.setText("");
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
        myVBox.getChildren().clear();
        gs.men_women_match().clear();
        resultShowCounter=0;
        countNumberOfButtonPressed_menPref=0;
        countNumberOfButtonPressed_womenPref=0;
    }
//    public void changeSceneMethod(){
//        Stage stage =new Stage();
//        FirstGUI gu=new FirstGUI();
//        gu.start(stage);
//    }

}
