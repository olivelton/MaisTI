package view;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

public class Validations {

    //metodo para retornar todas em maiusculas;
    public String upperCase(String word){
       return word.toUpperCase();
        }

    	public boolean verificaVazioText(String campo) {
    		if(campo.isEmpty()) {
    			return false;
    		}else {
    			return true;
    		}
    		
    	}

    	public boolean comparaSenhas(String campo1, String campo2) {
    		if(campo1.equals(campo2)) {
    			return true;
    		}else {
    			JOptionPane.showMessageDialog(null, " as senhas não conferem");
    			return false;
    		}
    		
    		
    	}

    	public void mascaraNumero() {
    	MaskFormatter fmt = null;
    	 try{
    		fmt = new MaskFormatter("1234567890");
    	 }catch(ParseException e){}
    	 JFormattedTextField tft2 = new JFormattedTextField(fmt);
    	}
    	
    	public void ValidaNumero(JTextField numero) {
    		long valor;
    		if (numero.getText().length() != 0){
    		try {
    		valor = Long.parseLong(numero.getText());
    		}catch(NumberFormatException ex){
    		numero.setText("");
    		numero.grabFocus();
    		}
    		}
    		}

    	
    	
}

