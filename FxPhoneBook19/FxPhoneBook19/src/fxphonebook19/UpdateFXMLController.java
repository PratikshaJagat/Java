/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxphonebook19;

import ECUtils.GUIValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pb.bean.Phone;
import pb.dao.PhoneDAO;

/**
 * FXML Controller class
 *
 * @author com
 */
public class UpdateFXMLController implements Initializable {
    
    GUIValidator g1 = new GUIValidator();

    public static String id;
    
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPn;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        g1.addRequiredValidator(txtPn);
        g1.addNameAndReqValidator(txtName);
        g1.addPNValidator(txtPn);

        Phone p1 = PhoneDAO.searchById(id);
        txtName.setText(p1.getUserName());
        txtPn.setText(p1.getPhoneNo());
    }    

    @FXML
    private void he(ActionEvent event) {
        try {
                if(event.getSource()==btnAdd){
                                    if(!g1.validateAll()){
                    return;
                }
		Phone p1 = new Phone();
		p1.setUserName(txtName.getText());
		p1.setPhoneNo(txtPn.getText());
                p1.setId(id);
                if(PhoneDAO.searchByPhoneNo(p1.getPhoneNo())!= null){
                   JOptionPane.showMessageDialog(null, "Phone No Already Exists!!");                      
                   return;
                }

                PhoneDAO.update(p1);

                Stage stage = (Stage)btnAdd.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("SearchFXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();                
                }
                else {
                Stage stage = (Stage)btnAdd.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("SearchFXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();                                    
                }

                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
