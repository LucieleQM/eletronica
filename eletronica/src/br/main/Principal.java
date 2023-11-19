package br.main;

import br.views.CadastroCliente;
import br.views.CadastroTecnico;

public class Principal {
	 public static void main(String[] args) {
	        
	        CadastroCliente formCliente = new CadastroCliente();
	        
	        formCliente.preencherTbl();
	        
	        formCliente.setVisible(true);
	        
	        CadastroTecnico formTecnico = new CadastroTecnico();
	        
	        formTecnico.preencherTbl();
	        
	        formTecnico.setVisible(true);
	        
	    }
	 
}
