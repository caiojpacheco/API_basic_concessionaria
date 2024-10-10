package org.exercicio.concessionaria;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "veiculos")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min=2, message = "O modelo do veículo deve ter pelo menos 2 caracteres")
	private String modelo;
	@Enumerated(EnumType.STRING)
	private Combustivel combustivel;
	@Enumerated(EnumType.STRING)
	private Marca marca;
	@Enumerated(EnumType.STRING)
	private Cor cor;
	@Positive(message = "O ano de fabricação deve ser positivo")
	private int anoFabricacao;
	@OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Acessorio> acessorios;
	
	@ManyToOne(cascade = CascadeType.ALL) // precisou do cascade aqui pra funcionar
    @JsonIgnoreProperties("veiculos") // mágica que conserta o loop infinito!
	private Proprietario proprietario;
	
	public Proprietario getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	
	public void setAcessorios(List<Acessorio> acessorios) {
		acessorios.forEach(a -> a.setVeiculo(this));
		this.acessorios = acessorios;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Combustivel getCombustivel() {
		return combustivel;
	}
	
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
	public Marca getMarca() {
		return marca;
	}
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public Cor getCor() {
		return cor;
	}
	
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
}
