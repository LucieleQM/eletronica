package br.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.beans.Tecnico;

public class TecnicoDAO {
	public boolean inserirTecnico(Tecnico tecnico) {
		Connection con = new ConnectionFactory().getConnection();
		
		String sql= "INSERT INTO tecnicos(cpf, nome, endereco, telefone, email)" + 
				" VALUES (?,?,?,?,?)";
		
		try {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, tecnico.getCpf());
				ps.setString(2, tecnico.getNome());
				ps.setString(3, tecnico.getEndereco());
				ps.setString(4, tecnico.getTelefone());
				ps.setString(5, tecnico.getEmail());
				
				ps.execute();
			}
			con.close();
			return true;
		} catch (SQLException ex) {
			System.out.println("Nao foi Possível Cadastrar o Tecnico: " + ex.getMessage());
	        return false;
		}
	}
	
	public boolean excluirTecnico(Tecnico tecnico){ 
        Connection con = new ConnectionFactory().getConnection();
        
        String sql = "delete from tecnicos where id = ?";
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setLong(1, tecnico.getId());
         
                stmt.execute();
            }
            con.close();
            return true;
        } catch (SQLException ex) {
           System.out.println("Nao foi Possível excluir Tecnico: " + ex.getMessage());
           return false;
        }
    }
	
	public boolean atualizarTecnico(Tecnico tecnico){
        Connection con = new ConnectionFactory().getConnection();
        String sql = "update tecnicos set nome = ?, endereco = ?, telefone = ?, email = ?, cpf = ? where id = ?";
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setString(1, tecnico.getNome());
                stmt.setString(2, tecnico.getEndereco());
                stmt.setString(3, tecnico.getTelefone());
                stmt.setString(4, tecnico.getEmail());
                stmt.setString(5, tecnico.getCpf());
                stmt.setLong(6, tecnico.getId());
         
                stmt.execute();
            }
            con.close();
            return true;
        } catch (SQLException ex) {
           System.out.println("Nao Foi Possível Alterar o Tecnico: " + ex.getMessage());
           return false;
        }
    }
	
	public Tecnico buscarTecnicos(Long id){
        Connection con = new ConnectionFactory().getConnection();   
        String sql = "SELECT * FROM tecnicos WHERE id = ?";
        
        ResultSet rs; 
        
        Tecnico tec = new Tecnico();
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setLong(1, id);
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    
                    tec.setId(rs.getLong("id"));
                    tec.setNome(rs.getString("nome"));
                    tec.setCpf(rs.getString("cpf"));    
                    tec.setEndereco(rs.getString("endereco"));
                    tec.setTelefone(rs.getString("telefone"));
                    tec.setEmail(rs.getString("email"));
                }
            }
            con.close();
            
            return tec;
            
        }catch(SQLException ex){
             System.out.println("Nao Foi Possível Buscar o Tecnico: " + ex.getMessage());
            return null;
        }
    }
	
	
	public List<Tecnico> listarTecnicos(){
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM tecnicos";
        ResultSet rs;
                       
        List<Tecnico> lista = new ArrayList<>();
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    
                    Tecnico tec = new Tecnico();

                    tec.setId(rs.getLong("id"));
                    tec.setNome(rs.getString("nome"));
                    tec.setCpf(rs.getString("cpf"));    
                    tec.setEndereco(rs.getString("endereco"));
                    tec.setTelefone(rs.getString("telefone"));
                    tec.setEmail(rs.getString("email"));

                    lista.add(tec);
                }
            }
            con.close();
            
            return lista;
            
        }catch(SQLException ex){
             System.out.println("Nao Foi Possível Listar os Tecnicos: " + ex.getMessage());
            return null;
        }
    }	
}
