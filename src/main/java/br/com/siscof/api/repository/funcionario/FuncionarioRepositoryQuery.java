package br.com.siscof.api.repository.funcionario;

import java.util.List;

import br.com.siscof.api.model.Funcionario;
import br.com.siscof.api.repository.filter.FuncionarioFilter;

public interface FuncionarioRepositoryQuery {
	public List<Funcionario> filtrar(FuncionarioFilter funcionario);
}
