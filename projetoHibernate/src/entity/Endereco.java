package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblendereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="endereco_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEndereco;
	@Column(length=50)
	private String bairro;
	@Column(length=50)
	private String cidade;
	@Column(length=50)
	private String logradouro;
	@Column(length=2)
	private String estado;
	
	
	@OneToOne
	@JoinColumn(name="fkcliente_id",referencedColumnName="cliente_id") //foreign key
	private Cliente cliente;
	
	public Endereco() {
		
	}
	public Endereco(Integer idEndereco, String bairro, String cidade, String logradouro, String estado) {
		
		this.idEndereco = idEndereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.estado = estado;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
