package br.main;

import br.views.CadastroCliente;
import br.views.CadastroTecnico;
import br.views.RegistroEletronico;
import br.views.RegistroServico;

public class Principal {
	 public static void main(String[] args) {
	        
	        CadastroCliente formCliente = new CadastroCliente();
	        
	        formCliente.preencherTbl();
	        
	        formCliente.setVisible(true);
	        
	        
	        
	        CadastroTecnico formTecnico = new CadastroTecnico();
	        
	        formTecnico.preencherTbl();
	        
	        formTecnico.setVisible(true);
	        
	        
	        
	        RegistroServico formServico = new RegistroServico();
	        
	        formServico.preencherTbl();
	        
	        formServico.setVisible(true);
	        
	        
	        RegistroEletronico formEltronico = new RegistroEletronico();
	        
	        formEltronico.preencherTbl();
	        
	        formEltronico.setVisible(true);
	        
	    }
	 
}
