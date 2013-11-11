/**
 * 
 */
package br.com.earfinanceiro.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Richard
 * 
 */
@Entity
@Table(name = "grupo")
@SequenceGenerator(name = Grupo.GRUPO_SEQUENCE, sequenceName = Grupo.GRUPO_SEQUENCE, initialValue = 1, allocationSize = 10)
public class Grupo {

	static final String GRUPO_SEQUENCE = "grupo_sequence";
	private Long id;
	private String descricao;
	private TipoEnum tipo;

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
		Grupo other = (Grupo) obj;
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
	 * Retorna o identificador do grupo
	 * 
	 * @return Long que identifica o grupo
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GRUPO_SEQUENCE)
	public Long getId() {
		return this.id;
	}

	/**
	 * 
	 * Insere um id
	 * 
	 * @param id
	 *            - Long identificador do grupo
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Retorna descrição do grupo
	 * 
	 * @return String que descreve o grupo
	 */
	@Column(name = "descricao")
	@NotNull(message = "O campo descrição deve ser preenchido")
	@Size(min = 3, max = 40, message = "O campo descrição deve possuir entre 3 e 40 caracteres")
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * 
	 * Insere uma descrição
	 * 
	 * @param descricao
	 *            - String que descreve o grupo
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * 
	 * Retorna o tipo de grupo
	 * 
	 * @return {@link TipoEnum} do grupo
	 */
	@Enumerated
	@Column(name = "tipo")
	@NotNull(message = "O campo tipo deve ser preenchido")
	public TipoEnum getTipo() {
		return this.tipo;
	}

	/**
	 * 
	 * Insere um tipo
	 * 
	 * @param tipo
	 *            - {@link TipoEnum} do grupo
	 */
	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

}
