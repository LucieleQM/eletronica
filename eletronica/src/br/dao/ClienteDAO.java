package br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
