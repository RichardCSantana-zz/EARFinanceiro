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

/**
 * @author Richard
 * 
 */
@Entity
@Table(name = "subgrupo")
@SequenceGenerator(name = Subgrupo.SUBGRUPO_SEQUENCE, sequenceName = Subgrupo.SUBGRUPO_SEQUENCE, initialValue = 1, allocationSize = 10)
public class Subgrupo {

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
	@NotNull(message = "O campo descricao deve ser preenchido")
	@Size(min = 3, max = 40)
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
