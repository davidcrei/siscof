package br.com.siscof.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siscof.api.model.Funcionario;
import br.com.siscof.api.repository.filter.FuncionarioFilter;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	public List<Funcionario> filtrar(FuncionarioFilter funcionarioFilter);
}
