package br.com.siscof.api.repository.funcionario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.com.siscof.api.model.Funcionario;
import br.com.siscof.api.repository.filter.FuncionarioFilter;

public class FuncionarioRepositoryImpl implements FuncionarioRepositoryQuery{

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Funcionario> filtrar(FuncionarioFilter funcionarioFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Funcionario> criteria = builder.createQuery(Funcionario.class);
		Root<Funcionario> root = criteria.from(Funcionario.class);
		
		Predicate[] predicates = criarRestricoes(funcionarioFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Funcionario> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(FuncionarioFilter funcionarioFilter, CriteriaBuilder builder,
			Root<Funcionario> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(funcionarioFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get("nome")), "%" + funcionarioFilter.getNome().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(funcionarioFilter.getCpf())) {
			predicates.add(builder.equal(
					builder.lower(root.get("cpf")), "%" + funcionarioFilter.getCpf().toLowerCase() + "%"));
		}
		
				
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
