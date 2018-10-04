package br.com.siscof.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class DocumentoObra {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idDocumento;
	@ManyToMany
	private List<Obra> obra;
	
	public List<Obra> getObra() {
		return obra;
	}

	public void setObra(List<Obra> obra) {
		this.obra = obra;
	}

	private String nome;

	public Long getIdDocumento() {
		return idDocumento;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
