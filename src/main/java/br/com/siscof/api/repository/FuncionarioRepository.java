package br.com.siscof.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siscof.api.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
