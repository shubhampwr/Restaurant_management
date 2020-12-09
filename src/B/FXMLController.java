/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JButton;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLController implements Initializable {
@FXML
private JButton b1;

  public void say()
  {
      System.out.println("hii");
  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
