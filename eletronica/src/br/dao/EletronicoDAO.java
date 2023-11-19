package br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.beans.Eletronico;
import br.dao.ClienteDAO;
import br.beans.Cliente;

public class EletronicoDAO {
	public boolean inserirEletronico(Eletronico eletr) {
		Connection con = new ConnectionFactory().getConnection();
		
		String sql= "INSERT INTO eletronicos(num_serial, tipo, marca, modelo, cliente_cpf)" + 
				" VALUES (?,?,?,?,?)";
		
		try {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setString(1, eletr.getNumSerial());
				ps.setString(2, eletr.getTipo());
				ps.setString(3, eletr.getMarca());
				ps.setString(4, eletr.getModelo());
				ps.setString(5, eletr.getCliente().getCpf());

				ps.execute();
			}
			con.close();
			return true;
		} catch (SQLException ex) {
			System.out.println("Nao foi Possível Cadastrar o Eletronico: " + ex.getMessage());
	        return false;
		}
	}
	
	public boolean excluirEletronico(Eletronico eletr){ 
        Connection con = new ConnectionFactory().getConnection();
        
        String sql = "delete from eletronicos where num_serial = ?";
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setString(1, eletr.getNumSerial());
         
                stmt.execute();
            }
            con.close();
            return true;
        } catch (SQLException ex) {
           System.out.println("Nao foi Possível excluir Eletronico: " + ex.getMessage());
           return false;
        }
    }
	
	public boolean atualizarEletronico(Eletronico eletr){
        Connection con = new ConnectionFactory().getConnection();
        String sql = "UPDATE eletronicos SET tipo = ?, marca = ?,"
					+ "modelo = ?, cliente_cpf = ? "
					+ "WHERE num_serial = ?";
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
               
				stmt.setString(1, eletr.getTipo());
				stmt.setString(2, eletr.getMarca());
				stmt.setString(3, eletr.getModelo());
				stmt.setString(4, eletr.getCliente().getCpf());
				stmt.setString(5, eletr.getNumSerial());
				
                stmt.execute();
            }
            con.close();
            return true;
        } catch (SQLException ex) {
           System.out.println("Nao Foi Possível Alterar o Eletronico: " + ex.getMessage());
           return false;
        }
    }
	
	public Eletronico buscarEletronicos(String numSerial){
        Connection con = new ConnectionFactory().getConnection();   
        String sql = "SELECT * FROM eletronicos where num_serial = ?";
        
        ResultSet rs; 
        
        Eletronico eletr = new Eletronico();
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setString(1, numSerial);
                
                rs = stmt.executeQuery();
                
                ClienteDAO cliDAO = new ClienteDAO();
             
                while(rs.next()){
                	
                	String cpf = rs.getString("cliente_cpf");
    				Cliente cli = cliDAO.buscarClientes(cpf);
                    
                	eletr.setNumSerial(rs.getString("num_serial"));
                	eletr.setTipo(rs.getString("tipo"));
                	eletr.setMarca(rs.getString("marca"));
                	eletr.setModelo(rs.getString("modelo"));    
                	eletr.setCliente(cli);
                }
            }
            con.close();
            
            return eletr;
            
        }catch(SQLException ex){
             System.out.println("Nao Foi Possível Buscar o Eletronico: " + ex.getMessage());
            return null;
        }
    }
	
	
	public List<Eletronico> listarEletronicos(){
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM eletronicos";
        ResultSet rs;
                       
        List<Eletronico> lista = new ArrayList<>();
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                	
                	ClienteDAO cliDAO = new ClienteDAO();
                    
                    String cpf = rs.getString("cliente_cpf");
    				Cliente cli = cliDAO.buscarClientes(cpf);
                    
                	Eletronico eletr = new Eletronico();

                	eletr.setNumSerial(rs.getString("num_serial"));
                	eletr.setTipo(rs.getString("tipo"));
                	eletr.setMarca(rs.getString("marca"));
                	eletr.setModelo(rs.getString("modelo"));    
                	eletr.setCliente(cli);

                    lista.add(eletr);
                }
            }
            con.close();
            
            return lista;
            
        }catch(SQLException ex){
             System.out.println("Nao Foi Possível Listar os Eletronicos: " + ex.getMessage());
            return null;
        }
    }	
}
