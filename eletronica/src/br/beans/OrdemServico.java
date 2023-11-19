package br.beans;

import java.util.Date;


public class OrdemServico {
	private long id;
	private String avarias;
	private String defeito;
	private Cliente cliente;
	private Eletronico eletronico;
	private Servico servico;
	private Tecnico tecnico;
	private Date dtRegistro;
	private Date dtConclusao;
	

	public OrdemServico() {
	
	}

	public OrdemServico(long id, String avarias, String defeito, Cliente cliente, Eletronico eletronico,
			Servico servico, Tecnico tecnico, Date dtRegistro, Date dtConclusao) {
		this.id = id;
		this.avarias = avarias;
		this.defeito = defeito;
		this.cliente = cliente;
		this.eletronico = eletronico;
		this.servico = servico;
		this.tecnico = tecnico;
		dtRegistro = dtRegistro;
		dtConclusao = dtConclusao;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAvarias() {
		return avarias;
	}

	public void setAvarias(String avarias) {
		this.avarias = avarias;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Eletronico getEletronico() {
		return eletronico;
	}

	public void setEletronico(Eletronico eletronico) {
		this.eletronico = eletronico;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Date getDtRegistro() {
		return dtRegistro;
	}

	public void setDtRegistro(Date dtRegistro) {
		this.dtRegistro = dtRegistro;
	}

	public Date getDtConclusao() {
		return dtConclusao;
	}

	public void setDtConclusao(Date dtConclusao) {
		this.dtConclusao = dtConclusao;
	}

}
