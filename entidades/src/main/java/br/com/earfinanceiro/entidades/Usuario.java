/**
 * 
 */
package br.com.earfinanceiro.entidades;

import java.beans.Transient;

import javax.ejb.EJB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.earfinanceiro.cripto.ICripto;

/**
 * @author richard
 *
 */
@Entity
@Table(name = "usuario")
@SequenceGenerator(name = Usuario.USUARIO_SEQUENCE, sequenceName = Usuario.USUARIO_SEQUENCE, initialValue = 1, allocationSize = 10)
@XmlRootElement(name = "usuario")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Usuario implements Persistivel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6095193168618448961L;
	static final String USUARIO_SEQUENCE = "usuario_sequence";
	private Long id;
	private String nome;
	private String senha;
	@EJB
	private ICripto cripto;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + this.id;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USUARIO_SEQUENCE)
	@XmlAttribute(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nome")
	@NotNull(message = "O campo nome deve ser preenchido")
	@Size(min = 3, max = 12, message = "O Campo nome deve possuir entre 3 e 12 caracteres")
	@XmlAttribute(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Transient
	@XmlTransient
	public String getSenhaInternal() {
		return senha;
	}

	public void setSenhaInternal(String senha) {
		setSenha(senha);
	}

	@Column(name = "senha")
	@NotNull(message = "O campo senha deve ser preenchido")
	@Size(min = 3, max = 12, message = "O Campo senha deve possuir entre 3 e 12 caracteres")
	@XmlAttribute(name = "senha")
	public String getSenha() {
		return " ";
	}

	public void setSenha(String senha) {
		this.senha = cripto.criptografa(senha);
	}

}
