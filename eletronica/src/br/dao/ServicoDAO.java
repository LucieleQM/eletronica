package br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.beans.Servico;

public class ServicoDAO {
	public boolean inserirServico(Servico servico) {
		Connection con = new ConnectionFactory().getConnection();
		
		String sql= "INSERT INTO tiposservicos(nome, descricao, preco_base)" + 
				" VALUES (?,?,?)";
		
		try {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, servico.getNome());
				ps.setString(2, servico.getDescricao());
				ps.setDouble(3, servico.getPreco());
				
				ps.execute();
			}
			con.close();
			return true;
		} catch (SQLException ex) {
			System.out.println("Nao foi Possível Cadastrar o Servico: " + ex.getMessage());
	        return false;
		}
	}
	
	public boolean excluirServico(Servico servico){ 
        Connection con = new ConnectionFactory().getConnection();
        
        String sql = "delete from tiposservicos where id = ?";
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setLong(1, servico.getId());
         
                stmt.execute();
            }
            con.close();
            return true;
        } catch (SQLException ex) {
           System.out.println("Nao foi Possível excluir Servico: " + ex.getMessage());
           return false;
        }
    }
	
	public boolean atualizarServico(Servico servico){
        Connection con = new ConnectionFactory().getConnection();
        String sql = "update servicos set nome = ?, descricao = ?, preco_base = ? where id = ?";
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setString(1, servico.getNome());
                stmt.setString(2, servico.getDescricao());
                stmt.setDouble(3, servico.getPreco());
                stmt.setLong(4, servico.getId());
         
                stmt.execute();
            }
            con.close();
            return true;
        } catch (SQLException ex) {
           System.out.println("Nao Foi Possível Alterar o Servico: " + ex.getMessage());
           return false;
        }
    }
	
	public Servico buscarServicos(Long id){
        Connection con = new ConnectionFactory().getConnection();   
        String sql = "SELECT * FROM tiposservicos where id = ?";
        
        ResultSet rs; 
        
        Servico sev = new Servico();
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setLong(1, id);
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    
                	sev.setId(rs.getLong("id"));
                	sev.setNome(rs.getString("nome"));
                	sev.setDescricao(rs.getString("descricao"));    
                	sev.setPreco(rs.getDouble("preco_base"));
                }
            }
            con.close();
            
            return sev;
            
        }catch(SQLException ex){
             System.out.println("Nao Foi Possível Buscar o Servico: " + ex.getMessage());
            return null;
        }
	}
	
	
	public List<Servico> listarServicos(){
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM tiposservicos";
        ResultSet rs;
                       
        List<Servico> lista = new ArrayList<>();
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    
                	Servico sev = new Servico();

                	sev.setId(rs.getLong("id"));
                	sev.setNome(rs.getString("nome"));
                	sev.setDescricao(rs.getString("descricao"));    
                	sev.setPreco(rs.getDouble("preco_base"));

                    lista.add(sev);
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
