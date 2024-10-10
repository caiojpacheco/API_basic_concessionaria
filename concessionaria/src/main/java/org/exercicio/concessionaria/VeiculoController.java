package org.exercicio.concessionaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private  IVeiculoRepository repository;
	
	@GetMapping
	public List<Veiculo> obterTodos() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> obterVeiculoPorId(@PathVariable Long id) {
		
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build(); // 
		}
		return ResponseEntity.ok(repository.findById(id).get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo cadastrarVeiculo(@RequestBody @Valid Veiculo veiculo) {
		return repository.save(veiculo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id) { 
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> alterarVeiculoPorId(@PathVariable Long id, @RequestBody @Valid Veiculo veiculo) {
		if(repository.existsById(id)) {
			veiculo.setId(id);
			repository.save(veiculo);
			return ResponseEntity.ok(veiculo);
		}
		return ResponseEntity.notFound().build();
	}
}
