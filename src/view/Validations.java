package view;

import javax.swing.JOptionPane;

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

}

