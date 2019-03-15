package br.com.siscof.api.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Funcionario {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull
	private String nome;
	private String cpf;
	
	@Column(name="dataInicio",updatable=true,nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicio;
	
	@OneToOne
	private DocumentoDigitalizado documentoDigitalizado;
	
	@ManyToOne
	private Obra obra;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Obra getObra() {
		return obra;
	}
	public void setObra(Obra obra) {
		this.obra = obra;
	}
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	
	
}
