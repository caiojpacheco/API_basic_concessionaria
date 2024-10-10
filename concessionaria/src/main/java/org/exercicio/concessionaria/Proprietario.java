package org.exercicio.concessionaria;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "proprietarios")
public class Proprietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min=2, message = "O nome do proprietário deve ter pelo menos 2 caracteres")
	private String nome;
	@NotBlank
	@Size(min=10, message = "A CNH do proprietário deve conter 10 caracteres")
	private String cnh;
	@NotBlank
	@Size(min=9, message = "O telefone do proprietário deve conter 9 caracteres")
	private String telefone;
	
	@OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Veiculo> veiculos;
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	public void setVeiculos(List<Veiculo> veiculos) {
		veiculos.forEach(v -> v.setProprietario(this));
		this.veiculos = veiculos;
	}
	
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
	
	public String getCnh() {
		return cnh;
	}
	
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
