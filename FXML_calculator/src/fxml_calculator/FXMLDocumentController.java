/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField text_result;
    
    String Op="";
    long number_1;
    long number_2;
    
    
    public void Number (ActionEvent ae){
    
    
       String num = ((Button)ae.getSource()).getText();
    text_result.setText(text_result.getText()+ num);
    }

    public void Operation (ActionEvent ae){
        String Operator = ((Button)ae.getSource()).getText();
        if (!Operator.equals("=")){      
            if(!Op.equals("")){
                return;
            }
            Op = Operator;
            number_1 = Long.parseLong(text_result.getText());
            text_result.setText("");
        }else {       
            if(Op.equals("")){
                return;
            }
            number_2 = Long.parseLong(text_result.getText());
            calculate(number_1, number_2, Op);
            Op="";
        }
    
    }
    
    
    public void AC (ActionEvent ae){
        text_result.setText("");
        
    }
    public void calculate (long n1, long n2, String op){
    
        switch (op){
        
            case "+" : text_result.setText(n1 + n2 + "");break;
            case "-" : text_result.setText(n1 - n2 + "");break;
            case "*" : text_result.setText(n1 * n2 + "");break;
            case "/" : 
                if (n2 == 0){
                text_result.setText("0");break;
                }
                text_result.setText(n1/n2+ "");break;  
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
