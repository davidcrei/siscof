package br.com.siscof.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscof.api.event.RecursoCriadoEvent;
import br.com.siscof.api.model.Funcionario;
import br.com.siscof.api.repository.FuncionarioRepository;
import br.com.siscof.api.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {
	@Autowired
	FuncionarioRepository repository;
	
	@Autowired
	private FuncionarioService funcioanrioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Funcionario>lista(){
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> criar(@Valid @RequestBody Funcionario funcionario, HttpServletResponse response) {
		Funcionario funcionarioSalvo = repository.save(funcionario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, funcionarioSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscarPeloCodigo(@PathVariable Long id) {
		Funcionario funcionario = repository.findOne(id);
		return funcionario != null ? ResponseEntity.ok(funcionario) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		repository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long codigo, @Valid @RequestBody Funcionario funcionario) {
		Funcionario funcionarioSalvo = funcioanrioService.atualizar(codigo, funcionario);
		return ResponseEntity.ok(funcionarioSalvo);
	}
}
