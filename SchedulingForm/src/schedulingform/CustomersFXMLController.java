/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulingform;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Aaron
 */
public class CustomersFXMLController implements Initializable {
 @FXML
    private TextField txtCustomerName;
    @FXML
    private TextField txtStreet;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtCountry;
    @FXML
    private TableView<Customer> allCustomersTable;
    @FXML 
    private FXMLDocumentController parentController;
    @FXML private Button btnCustomerSave;
    @FXML private Button btnCustomerUpdate;
    @FXML private Label lblCustomerError;
    
    @FXML private TableColumn<Customer, String> customerName;
    @FXML private TableColumn<Customer, Integer> customerID;
    @FXML private TableColumn<Customer, String> customerStreet;
    @FXML private TableColumn<Customer, String> customerCity;
    @FXML private TableColumn<Customer, String> customerCountry;
    
    
    private Customer custToUpdate;
    private Customer updatedCustomer;
    
    private List<Customer> allCustomersList;
    /**
     * Displays confirmation message asking for confirmation to close the window
     * If Yes is clicked. The window gets closed
     * @param event 
     */
    @FXML
    private void closeButtonAction(ActionEvent event) 
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        //alert.setHeaderText("");
        alert.setContentText("Are you sure you want to cancel?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } 
        else 
        {
        }
    }
    
    public void addCustomer(ActionEvent event) throws SQLException
    {
        String name = txtCustomerName.getText();
        String street = txtStreet.getText();
        String city = txtCity.getText();
        String country = txtCountry.getText();
        Customer cust = new Customer(name, street, city, country);
        DataConnector dc = new DataConnector();
        dc.insertCustomer(cust);
        
    }
    
    /**
     * Sets the parent controller to the FXMLDocumentController
     * Gives access to variables of the Parent controller by having this set
     * @param controller 
     */
    public void setParentController(FXMLDocumentController controller)
    {
        this.parentController = controller;
    }
    
    /**
     * Loads the table that displays all of the available parts
     * Gets the parts list from the parent controller to use for the table data
     */
    public void loadTable()
    {
        /*customerName.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        customerStreet.setCellValueFactory(new PropertyValueFactory<Customer, String>("street"));
        customerCity.setCellValueFactory(new PropertyValueFactory<Customer, String>("city"));
        customerCountry.setCellValueFactory(new PropertyValueFactory<Customer, String>("country"));
        allCustomersTable.getItems().setAll(allCustomersList);*/
        
        //String thisId = Integer.toString(parentController.getNextProductID());
        //txtProductID.setText(thisId);
    }
    
    /**
     * Sets the product that will be updated
     * Calls the fill fields method to prefill the fields from the existing product being updated
     * @param prod 
     */
    public void setCustomerToUpdate(Customer cust)
    {
        this.custToUpdate = cust;
        //fillFields(cust);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Fills the form fields with data from Product object
     * @param prod 
     */
    
}
