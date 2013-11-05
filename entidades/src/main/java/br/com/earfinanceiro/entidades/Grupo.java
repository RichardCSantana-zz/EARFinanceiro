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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + id;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GRUPO_SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "descricao")
	@NotNull(message = "O campo descricao deve ser preenchido")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Enumerated
	@Column(name = "tipo")
	@NotNull(message = "O campo tipo deve ser preenchido")
	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

}
