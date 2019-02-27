package br.com.siscof.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.siscof.api.model.Funcionario;
import br.com.siscof.api.repository.FuncionarioRepository;
import br.com.siscof.api.repository.filter.FuncionarioFilter;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario atualizar(Long id, Funcionario funcionario) {

		Funcionario funcionarioSalvo = buscarFuncionarioPeloCodigo(id);
		BeanUtils.copyProperties(funcionario, funcionarioSalvo, "idcodigo");
		return funcionario;

	}
	public Funcionario buscarFuncionarioPeloCodigo(Long id) {
		Funcionario funcionarioSalvo= funcionarioRepository.findOne(id);
		if (funcionarioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return funcionarioSalvo;
	}
	
	public  List<Funcionario> filtrar(FuncionarioFilter filtro) {
		 List<Funcionario> listaFuncionario= funcionarioRepository.filtrar(filtro);
		
		return listaFuncionario;
	}
	
}
