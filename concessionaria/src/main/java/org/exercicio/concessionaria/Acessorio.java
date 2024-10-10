package org.exercicio.concessionaria;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "acessorios")
public class Acessorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Positive
	private int qntPorta;
	@Enumerated(EnumType.STRING)
	private TipoCarro tipo;
	private boolean arCondicionado;
	private boolean cambio;
	@ManyToOne
	private Veiculo veiculo;
	
	/*public Veiculo getVeiculo() {
		return veiculo;
	}*/
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getQntPorta() {
		return qntPorta;
	}
	
	public void setQntPorta(int qntPorta) {
		this.qntPorta = qntPorta;
	}
	
	public TipoCarro getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoCarro tipo) {
		this.tipo = tipo;
	}
	
	public boolean isArCondicionado() {
		return arCondicionado;
	}
	
	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
	
	public boolean isCambio() {
		return cambio;
	}
	
	public void setCambio(boolean cambio) {
		this.cambio = cambio;
	}
}
