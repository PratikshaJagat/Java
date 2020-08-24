/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxphonebook19;

import ECUtils.MyUtils;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pb.bean.Phone;
import pb.dao.PhoneDAO;

/**
 * FXML Controller class
 *
 * @author com
 */
public class SearchFXMLController implements Initializable {
    public static String si = "";
    public static String sc = "id";
    @FXML
    private TableView<?> tblSearch;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtSi;
    @FXML
    private ComboBox<?> cmbSc;
    @FXML
    private Button btnUp;
    @FXML
    private Button btnDel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MyUtils.populateColumnNames(cmbSc, "phone_book");
        txtSi.setText(si);
        MyUtils.selectComboBoxValue(cmbSc, sc);
        populate();
    }    

    @FXML
    private void he(ActionEvent event) {
           try {
            if(event.getSource()==btnBack){
                Stage stage = (Stage)btnBack.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();                
            }
            else if(event.getSource()==btnDel){
                String id = MyUtils.getSelColValue("id", tblSearch);
                if(id==null){
                    JOptionPane.showMessageDialog(null, "Please select a row!!!");
                }
                else {
                    int res = JOptionPane.showConfirmDialog(null, "R u sure??");
                    if(res==0){
                        PhoneDAO.delete(id);                   
                        populate();                        
                    }
                }
            }
            else if(event.getSource()==btnUp){
                String id = MyUtils.getSelColValue("id", tblSearch);
                if(id==null){
                    JOptionPane.showMessageDialog(null, "Please select a row!!!");
                }
                else {
                    UpdateFXMLController.id = id;
                    Stage stage = (Stage)btnBack.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("UpdateFXML.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();                                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    @FXML
    private void kr(KeyEvent event) { 
        si = txtSi.getText();
        populate();
    }
    
    private void populate(){
	LinkedList<Phone> res = PhoneDAO.search(cmbSc.getValue().toString() ,txtSi.getText());
        MyUtils.populateTable(tblSearch, res, Phone.class);        
    }

    @FXML
    private void cc(ActionEvent event) {
        sc = cmbSc.getValue().toString();
        populate();
    }
    
}
