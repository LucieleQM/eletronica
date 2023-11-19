package br.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.beans.Cliente;

public class ClienteDAO {
	public boolean inserirCliente(Cliente cliente) {
		Connection con = new ConnectionFactory().getConnection();
		
		String sql= "INSERT INTO clientes(cpf, nome, endereco, telefone, email)" + 
				" VALUES (?,?,?,?,?)";
		
		try {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, cliente.getCpf());
				ps.setString(2, cliente.getNome());
				ps.setString(3, cliente.getEndereco());
				ps.setString(4, cliente.getTelefone());
				ps.setString(5, cliente.getEmail());
				
				ps.execute();
			}
			con.close();
			return true;
		} catch (SQLException ex) {
			System.out.println("Nao foi Possível Cadastrar o Cliente: " + ex.getMessage());
	        return false;
		}
	}
	
	public boolean excluirCliente(Cliente cliente){ 
        Connection con = new ConnectionFactory().getConnection();
        
        String sql = "delete from clientes where cpf = ?";
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setString(1, cliente.getCpf());
         
                stmt.execute();
            }
            con.close();
            return true;
        } catch (SQLException ex) {
           System.out.println("Nao foi Possível excluir Cliente: " + ex.getMessage());
           return false;
        }
    }
	
	public boolean atualizarCliente(Cliente cliente){
        Connection con = new ConnectionFactory().getConnection();
        String sql = "update clientes set nome = ?, endereco = ?, telefone = ?, email = ? where cpf = ?";
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getEndereco());
                stmt.setString(3, cliente.getTelefone());
                stmt.setString(4, cliente.getEmail());
                stmt.setString(5, cliente.getCpf());
         
                stmt.execute();
            }
            con.close();
            return true;
        } catch (SQLException ex) {
           System.out.println("Nao Foi Possível Alterar o Cliente: " + ex.getMessage());
           return false;
        }
    }
	
	public Cliente buscarClientes(String cpf){
        Connection con = new ConnectionFactory().getConnection();   
        String sql = "SELECT * FROM clientes where cpf = ?";
        
        ResultSet rs; 
        
        Cliente cli = new Cliente(0, sql, sql, sql, sql, sql);
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setString(1, cpf);
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    
                    cli.setId(rs.getLong("id"));
                    cli.setNome(rs.getString("nome"));
                    cli.setCpf(rs.getString("cpf"));    
                    cli.setEndereco(rs.getString("endereco"));
                    cli.setTelefone(rs.getString("telefone"));
                    cli.setEmail(rs.getString("email"));
                }
            }
            con.close();
            
            return cli;
            
        }catch(SQLException ex){
             System.out.println("Nao Foi Possível Buscar o Cliente: " + ex.getMessage());
            return null;
        }
    }
	
	
	public List<Cliente> listarClientes(){
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM clientes";
        ResultSet rs;
                       
        List<Cliente> lista = new ArrayList<>();
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    
                    Cliente cli = new Cliente();

                    cli.setId(rs.getLong("id"));
                    cli.setNome(rs.getString("nome"));
                    cli.setCpf(rs.getString("cpf"));    
                    cli.setEndereco(rs.getString("endereco"));
                    cli.setTelefone(rs.getString("telefone"));
                    cli.setEmail(rs.getString("email"));

                    lista.add(cli);
                }
            }
            con.close();
            
            return lista;
            
        }catch(SQLException ex){
             System.out.println("Nao Foi Possível Listar os Clientes: " + ex.getMessage());
            return null;
        }
    }	
}
