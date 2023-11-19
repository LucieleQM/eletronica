package br.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.beans.Cliente;
import br.beans.Eletronico;
import br.beans.OrdemServico;
import br.beans.Servico;
import br.beans.Tecnico;
//import br.beans.Eletronico;

public class OrdemServicoDAO {
	public boolean inserirOrdem(OrdemServico ord) {
		Connection con = new ConnectionFactory().getConnection();
		
		String sql= "INSERT INTO ordensservico(cliente_cpf, eletronico_num_serial, tecnico_id = ?, "
				+ "tipo_id_servico, avarias, defeito,"
				+ "dt_registro, dt_conclusao)" + 
				" VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setString(1, ord.getCliente().getCpf());
				ps.setString(2, ord.getEletronico().getNumSerial());
				ps.setLong(3, ord.getTecnico().getId());
				ps.setLong(4, ord.getServico().getId());
				ps.setString(5, ord.getAvarias());
				ps.setString(6, ord.getDefeito());
				ps.setDate(7, (Date) ord.getDtRegistro());
				ps.setDate(8, (Date) ord.getDtConclusao());

				ps.execute();
			}
			con.close();
			return true;
		} catch (SQLException ex) {
			System.out.println("Nao foi Possível Cadastrar a Ordem de Servico: " + ex.getMessage());
	        return false;
		}
	}
	
	public boolean excluirOrdem(OrdemServico ord){ 
        Connection con = new ConnectionFactory().getConnection();
        
        String sql = "delete from ordensservico where id = ?";
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setLong(1, ord.getId());
         
                stmt.execute();
            }
            con.close();
            return true;
        } catch (SQLException ex) {
           System.out.println("Nao foi Possível excluir Ordem de Servico: " + ex.getMessage());
           return false;
        }
    }
	
	public boolean atualizarOrdem(OrdemServico ord){
        Connection con = new ConnectionFactory().getConnection();
        String sql = "UPDATE ordensservico SET cliente_cpf = ?, eletronico_num_serial = ?,"
					+ "tipo_servico_id = ?, tecnico_id = ?,"
					+ "avarias = ?, defeito = ?, "
					+ "dt_registro = ?, dt_conclusao = ?"
					+ "WHERE id = ?";
        
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
               
            	ps.setString(1, ord.getCliente().getCpf());
				ps.setString(2, ord.getEletronico().getNumSerial());
				ps.setLong(3, ord.getTecnico().getId());
				ps.setLong(4, ord.getServico().getId());
				ps.setString(5, ord.getAvarias());
				ps.setString(6, ord.getDefeito());
				ps.setDate(7, (Date) ord.getDtRegistro());
				ps.setDate(8, (Date) ord.getDtConclusao());
				ps.setLong(9, ord.getId());
				
                ps.execute();
            }
            con.close();
            return true;
        } catch (SQLException ex) {
           System.out.println("Nao Foi Possível Alterar a Ordem de Servico: " + ex.getMessage());
           return false;
        }
    }
	
	public OrdemServico buscarOrdens(Long id){
        Connection con = new ConnectionFactory().getConnection();   
        String sql = "SELECT * FROM ordensservico where id = ?";
        
        ResultSet rs; 
        
        OrdemServico ord = new OrdemServico();
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                stmt.setLong(1, id);
                
                rs = stmt.executeQuery();
                
                ClienteDAO cliDAO = new ClienteDAO();
                TecnicoDAO tecDAO =new TecnicoDAO();
                ServicoDAO servDAO = new ServicoDAO();
                EletronicoDAO eletDAO = new EletronicoDAO();
             
                while(rs.next()){
                	
                	String cpf = rs.getString("cliente_cpf");
    				Cliente cli = cliDAO.buscarClientes(cpf);
    				
    				long idT = rs.getLong("tecnico_id");
    				Tecnico tec = tecDAO.buscarTecnicos(idT);
    				
    				String numS = rs.getString("eletronico_num_serial");
    				Eletronico elet = eletDAO.buscarEletronicos(numS);
    				
    				long idS = rs.getLong("tipo_servico_id");
    				Servico serv = servDAO.buscarServicos(idS);
                    
    				ord.setCliente(cli);
    				ord.setEletronico(elet);
    				ord.setServico(serv);
    				ord.setTecnico(tec);
    				ord.setAvarias(rs.getString("avarias"));
    				ord.setDefeito(rs.getString("defeito"));
    				ord.setDtConclusao(rs.getDate("dt_conclusao"));
    				ord.setDtRegistro(rs.getDate("dt_registro"));	
                }
            }
            con.close();
            
            return ord;
            
        }catch(SQLException ex){
             System.out.println("Nao Foi Possível Buscar a Ordem de Servico: " + ex.getMessage());
            return null;
        }
    }
	
	
	public List<OrdemServico> listarOrdens(){
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM ordensservico";
        ResultSet rs;
                       
        List<OrdemServico> lista = new ArrayList<>();
        
        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
                rs = stmt.executeQuery();
                
                ClienteDAO cliDAO = new ClienteDAO();
                TecnicoDAO tecDAO =new TecnicoDAO();
                ServicoDAO servDAO = new ServicoDAO();
                EletronicoDAO eletDAO = new EletronicoDAO();
                
                while(rs.next()){
                	
                	OrdemServico ord = new OrdemServico();
                	
                	String cpf = rs.getString("cliente_cpf");
    				Cliente cli = cliDAO.buscarClientes(cpf);
    				
    				long idT = rs.getLong("tecnico_id");
    				Tecnico tec = tecDAO.buscarTecnicos(idT);
    				
    				String numS = rs.getString("eletronico_num_serial");
    				Eletronico elet = eletDAO.buscarEletronicos(numS);
    				
    				long idS = rs.getLong("tipo_servico_id");
    				Servico serv = servDAO.buscarServicos(idS);
                    
    				ord.setCliente(cli);
    				ord.setEletronico(elet);
    				ord.setServico(serv);
    				ord.setTecnico(tec);
    				ord.setAvarias(rs.getString("avarias"));
    				ord.setDefeito(rs.getString("defeito"));
    				ord.setDtConclusao(rs.getDate("dt_conclusao"));
    				ord.setDtRegistro(rs.getDate("dt_registro"));	

                    lista.add(ord);
                }
            }
            con.close();
            
            return lista;
            
        }catch(SQLException ex){
             System.out.println("Nao Foi Possível Listar as Ordens de Servico: " + ex.getMessage());
            return null;
        }
    }	
}
