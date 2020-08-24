/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxbilling;

import ECUtils.FXMLConst;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author com
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnUser;
    @FXML
    private Button btnAdmin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void he(ActionEvent event) {
        if(event.getSource()==btnUser){
            try {
                Stage stage = (Stage)btnUser.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource(FXMLConst.USER_FXML));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(event.getSource()==btnAdmin){
            try {
                Stage stage = (Stage)btnUser.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource(FXMLConst.LOGIN_FXML));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
