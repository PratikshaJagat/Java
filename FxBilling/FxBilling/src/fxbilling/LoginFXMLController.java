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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author com
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void he(ActionEvent event) {
        if(event.getSource()==btnBack){
            try {
                Stage stage = (Stage)btnBack.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource(FXMLConst.MAIN_FXML));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        

    }
    
}
