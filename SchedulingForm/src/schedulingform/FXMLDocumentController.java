/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulingform;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aaron
 */
public class FXMLDocumentController implements Initializable 
{
    
    @FXML
    private Label label;
    private Button closeButton;
    //private List<Part> partList;
    //private List<Product> productList = new ArrayList<Product>();
    
    @FXML private Label lblLocation; 
    
    @FXML private Label lblError;
    @FXML TextField txtUsername;
    @FXML TextField txtPassword;
    /*@FXML private TableView<Part> partTable;
    @FXML private TableColumn<Part, String> partName;
    @FXML private TableColumn<Part, Integer> partID;
    @FXML private TableColumn<Part, Integer> partInventory;
    @FXML private TableColumn<Part, Double> partCost;
    
    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Part, String> productName;
    @FXML private TableColumn<Part, Integer> productID;
    @FXML private TableColumn<Part, Integer> productInventory;
    @FXML private TableColumn<Part, Double> productCost;*/
    //Locale locale_fr = new Locale("fr");
    
    
    
    
    /*Locale.setDefault("fr");
    Locale.setDefault(new Locale("fr", "FRANCE", "MAC"));*/
    
    
    /**
     * Closes the window if Yes is clicked in the confirmation dialog
     * @param event 
     */
    @FXML
    private void closeButtonAction(ActionEvent event)
    {
        Locale.setDefault(new Locale("es"));
        Locale locale = Locale.getDefault();
        ResourceBundle localStrings = ResourceBundle.getBundle("StringsBundle", locale);
        String exitString = localStrings.getString("exitString");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        //alert.setHeaderText("");
        alert.setContentText(exitString);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } 
        else 
        {
        }

    }
    
    /**
     * Updates the parts table with the search results
     * @param event 
     */
    @FXML
    private void login(ActionEvent event) throws IOException
    { 
        //Locale.setDefault(new Locale("es"));
        Locale locale = Locale.getDefault();
        ResourceBundle localStrings = ResourceBundle.getBundle("StringsBundle", locale);
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        System.out.println(locale);
        lblLocation.setText(locale.toString());
        try
        {
            DataConnector conn = new DataConnector();
            ResultSet rs = conn.callDb("SELECT * FROM U04bpv.user;");
            while(rs.next())
            {
                /*System.out.println(rs.getString("username"));
                System.out.println(rs.getString("password"));*/
            }
            System.out.println(localStrings.getString("loggedin"));
            
       
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomersFXML.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            CustomersFXMLController controller = fxmlLoader.<CustomersFXMLController>getController();
            //controller.setAllParts(this.partList);
            controller.setParentController(this);

            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add Product");
            stage.setScene(new Scene(root2)); 
            controller.loadTable(); 
            //controller.updateBtnLabel("Save");
            //controller.showSaveButton();
            stage.show();
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        
        
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
