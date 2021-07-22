package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static javafx.fxml.FXMLLoader.load;

public class HomeController {

    @FXML
    private TextField char_number_of_column;
    @FXML
    private TextField char_number_of_row;

    //    @FXML
//    private Label show_error_one;
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

    /**
     *HBox to add Men Preferences in the GUI
     * returns void
     */
    public void AddHboxForMenPreference() {
        //check if the number of men and women input is empty
        //or not equal in size
        if(char_number_of_column.getText().isBlank() || char_number_of_row.getText().isBlank()||int_number_of_row==1||int_number_of_column==1)
        {
            show_error_two.setText("Enter number of men and women");
            show_error_two.setWrapText(true);
            return;
        }
        int_number_of_column=Integer.parseInt(char_number_of_column.getText());
        int_number_of_row=Integer.parseInt(char_number_of_row.getText());
        //counting the number of the provided button press to avoid more entry of the table
        countNumberOfButtonPressed_menPref++;
        if(countNumberOfButtonPressed_menPref>1){
            show_error_two.setText("Men Preference Entered");
            show_error_two.setWrapText(true);
            return;
        }
        if(int_number_of_column !=int_number_of_row){
            show_error_two.setText("Number of Men and Women must be equal and greater than 1");
            show_error_two.setWrapText(true);
            return;
        }
        show_error_two.setText("");
        //store the textField to access the variable of entries
        menPrefTextFieldArray= new TextField[int_number_of_row][int_number_of_column+1];
        Label menPrefLabel= new Label("Men Preferences ");
        myVBox.getChildren().add(menPrefLabel);
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

    /**
     *HBox to add Women Preferences in the GUI
     * returns void
     */
    public void AddHboxForWomenPreference() {
        //check if the number of men and women input is empty
        //or not equal in size
        if(char_number_of_column.getText().isBlank() || char_number_of_row.getText().isBlank()||int_number_of_row==1||int_number_of_column==1)
        {
            show_error_two.setText("Enter number of men and women");
            show_error_two.setWrapText(true);
            return;
        }
        int_number_of_column=Integer.parseInt(char_number_of_column.getText());
        int_number_of_row=Integer.parseInt(char_number_of_row.getText());
        //counting the number of the provided button press to avoid more entry of the table
        countNumberOfButtonPressed_womenPref++;
        if(countNumberOfButtonPressed_womenPref>1){
            show_error_two.setText("Women Preference Entered");
            show_error_two.setWrapText(true);
            return;
        }

        if(int_number_of_column !=int_number_of_row){
            show_error_two.setText("Number of Men and Women must be equal");
            show_error_two.setWrapText(true);
            return;
        }
        show_error_two.setText("");
        //store the textField to access the variable of entries
        womenPrefTextFieldArray= new TextField[int_number_of_row][int_number_of_column+1];
        Label womenPrefLabel= new Label("Women Preferences: ");
        myVBox.getChildren().add(womenPrefLabel);
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

    /**
     * Result: to display the result in GUI
     * @param map
     */
    @FXML
    public void result(HashMap<String, String> map){

        resultShowCounter++;
//        if(resultShowCounter>1){
//            return;
//        }
        Set<Map.Entry<String, String>> set = map.entrySet();

        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        Label gale_Shapley_label= new Label("The Match Result: ");
        myVBox.getChildren().add(gale_Shapley_label);
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

    /**
     * Gale-Shapley implementation and Display on GUI
     */
    public void showGale_shapley(){
        if(resultShowCounter>1){
            show_error_two.setText("The match Table is shown already");
            show_error_two.setWrapText(true);
            return;
        }
        if(char_number_of_column.getText().isBlank() || char_number_of_row.getText().isBlank())
        {
            show_error_two.setText("Enter number of men and women");
            show_error_two.setWrapText(true);
            return;
        }
        String[][] menPref = new String[int_number_of_row][int_number_of_column];
        String[] men = new String[int_number_of_row];
        String[][] womenPref = new String[int_number_of_row][int_number_of_column];
        String[] women = new String[int_number_of_row];

        //To isolate the first column of the table for women preference and men preference table
        int countMen =0;
        int countWomen=0;
        if(menPrefTextFieldArray==null || menPrefTextFieldArray.length==0) {
            show_error_two.setText("Please enter man preference");
            show_error_two.setWrapText(true);
            return;
        }
        else {
            for(int i=0; i<menPrefTextFieldArray.length;i++){
                for(int j=0; j<menPrefTextFieldArray[0].length;j++) {
                    if(menPrefTextFieldArray[i][j].getText().isBlank()){
                        show_error_two.setText("Please enter all man preference");
                        show_error_two.setWrapText(true);
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
            show_error_two.setWrapText(true);
            return;
        }
        else {
            for(int i=0; i<womenPrefTextFieldArray.length;i++){
                for(int j=0; j<womenPrefTextFieldArray[0].length;j++) {
                    if(womenPrefTextFieldArray[i][j].getText().isBlank()){
                        show_error_two.setText("Please enter all Woman preference");
                        show_error_two.setWrapText(true);
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
        //display the match
        gs= new GaleShapley(men, women, menPref, womenPref);
        gs.calcMatches();
        result(gs.men_women_match());;
        show_error_two.setText("");
    }

    /**
     * To reset all values for new entry
     */
    public void reset () {
        if(char_number_of_column.getText().isBlank() || char_number_of_row.getText().isBlank()||(int_number_of_column !=int_number_of_row))
        {
            show_error_two.setText("Enter Equal number of men and women");
            show_error_two.setWrapText(true);
            char_number_of_row.clear();
            char_number_of_column.clear();
            return;
        }
        char_number_of_row.clear();
        char_number_of_column.clear();
        myVBox.getChildren().clear();
        gs.men_women_match().clear();
        resultShowCounter=0;
        countNumberOfButtonPressed_menPref=0;
        countNumberOfButtonPressed_womenPref=0;
    }

    public void changeSceneBack() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GaleShapley.fxml"));
        Stage sg =new Stage();
        sg.setScene(new Scene(root));

        sg.show();
    }
}
