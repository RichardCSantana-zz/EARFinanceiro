/**
 * 
 */
package br.com.earfinanceiro.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Richard
 * 
 */
@Entity
@Table(name = "subgrupo")
@SequenceGenerator(name = Subgrupo.SUBGRUPO_SEQUENCE, sequenceName = Subgrupo.SUBGRUPO_SEQUENCE, initialValue = 1, allocationSize = 10)
@XmlRootElement(name = "subgrupo")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Subgrupo implements Persistivel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8519984059548449729L;
	static final String SUBGRUPO_SEQUENCE = "subgrupo_sequence";
	private Long id;
	private String descricao;
	private Grupo grupo;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Subgrupo other = (Subgrupo) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "" + this.id;
	}

	/**
	 * 
	 * Retorna o identificador do subgrupo
	 * 
	 * @return Long que define o identificador do subgrupo
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SUBGRUPO_SEQUENCE)
	@XmlAttribute(name = "id", required = true)
	public Long getId() {
		return this.id;
	}

	/**
	 * 
	 * Define o identificador do subgrupo
	 * 
	 * @param id
	 *            - Long que define o identificador do subgrupo
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Retorna descrição do subgrupo
	 * 
	 * @return String que define a descrição do subgrupo
	 */
	@Column(name = "descricao")
	@NotNull(message = "O campo descrição deve ser preenchido")
	@Size(min = 3, max = 40, message = "O campo descrição deve possuir entre 3 e 40 caracteres")
	@XmlElement(name = "descricao", required = true)
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * 
	 * Define a descrição do subgrupo
	 * 
	 * @param descricao
	 *            - String que define a descrição do subgrupo
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * 
	 * Retorna o grupo ao qual o subgrupo pertence
	 * 
	 * @return {@link Grupo} ao qual o subgrupo pertence
	 */
	@ManyToOne(targetEntity = Grupo.class, fetch = FetchType.EAGER)
	@XmlElement(type = Grupo.class, name = "grupo", required = true)
	public Grupo getGrupo() {
		return this.grupo;
	}

	/**
	 * 
	 * Define a qual grupo o subgrupo pertence
	 * 
	 * @param grupo
	 *            - {@link Grupo} ao qual o subgrupo pertence
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
