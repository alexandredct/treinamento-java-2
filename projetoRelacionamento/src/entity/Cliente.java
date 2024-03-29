package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@Column(name="cliente_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCliente;
	
	private String nome;
	
	@Column(length=50, unique=true)
	private String email;
	
	@OneToMany(
			mappedBy="cliente",
			cascade={CascadeType.ALL}
			)
	private List<Telefone> telefones;
	
	
	
	
	
	
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer idCliente, String nome, String email) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void adicionarTelefone (Telefone t) {
		if (this.telefones == null) {
			this.telefones = new ArrayList<Telefone>();
		}
		this.telefones.add(t);
	}
	
	public void adicionarTelefone (Telefone ...t) {
		if (this.telefones == null) {
			this.telefones = new ArrayList<Telefone>();
		}
		this.telefones.addAll(Arrays.asList(t));
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", telefones=" + telefones
				+ "]";
	}
	
	

}
