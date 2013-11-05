/**
 * 
 */
package br.com.earfinanceiro.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.earfinanceiro.exceptions.ErroCadastroException;

/**
 * @author Richard
 * 
 */
@Entity
@Table(name = "conta")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
@SequenceGenerator(name = AbstractConta.CONTA_SEQUENCE, sequenceName = AbstractConta.CONTA_SEQUENCE, initialValue = 1, allocationSize = 10)
public abstract class AbstractConta implements IConta {

	public static final String CONTA_SEQUENCE = "conta_sequence";

	protected Long id;
	protected String descricao;
	protected Calendar dataCadastro;
	protected Calendar dataEfetivacao;
	protected Subgrupo subGrupo;
	protected boolean efetiva;
	protected double valor;
	protected int reincidencia;
	protected boolean reincidente;

	/**
	 * 
	 */
	public AbstractConta() {
		super();
	}

	@Override
	public void efetiva(Calendar dataEfetivacao) throws ErroCadastroException {
		if (dataEfetivacao.before(dataCadastro)) {
			throw new ErroCadastroException(
					"Data de efetivacao deve ser posterior a data de cadastro");
		}
		if (efetiva) {
			throw new ErroCadastroException(
					"A conta que est�o tentando efetivar j� foi efetivada");
		}
		this.efetiva = true;
		this.dataEfetivacao = dataEfetivacao;
	}

	@Override
	public void reincide(Integer reincidencia) throws ErroCadastroException {
		if (reincidencia < 1) {
			throw new ErroCadastroException(
					"O prazo de reincidencia deve ser no minimo 1 dia");
		}
		if (reincidente) {
			throw new ErroCadastroException(
					"A conta em quest�o j� foi marcada como reincidente");
		}
		this.reincidente = true;
		this.reincidencia = reincidencia;
	}

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
		Entrada other = (Entrada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setValor(Double valor) throws ErroCadastroException {
		if (valor.compareTo(0.0) < 1) {
			throw new ErroCadastroException("Valor deve ser maior que 0");
		}
		this.valor = valor;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CONTA_SEQUENCE)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "descricao")
	@NotNull(message = "O campo descrição deve ser preenchido")
	@Size(min = 3, max = 40, message = "O campo descricao deve possuir entre 3 e 40 caracteres")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	@Column(name = "data_cadastro")
	@NotNull(message = "O campo data cadastro deve ser preenchido")
	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	@Column(name = "valor")
	@NotNull(message = "O campo valor deve ser preenchido")
	public Double getValor() {
		return valor;
	}

	@Override
	@Column(name = "data_efetivacao")
	public Calendar getDataEfetivacao() {
		return dataEfetivacao;
	}

	@Override
	@Column(name = "efetiva")
	public Boolean isEfetiva() {
		return efetiva;
	}

	@Override
	@ManyToOne(targetEntity = Subgrupo.class, fetch = FetchType.EAGER)
	public Subgrupo getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(Subgrupo subGrupo) {
		this.subGrupo = subGrupo;
	}

	@Override
	@Column(name = "reincidencia")
	public Integer getReincidencia() {
		return reincidencia;
	}

	@Column(name = "eh_reincidente")
	public boolean isReincidente() {
		return reincidente;
	}

	@SuppressWarnings("unused")
	private void setDataEfetivacao(Calendar dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

	@SuppressWarnings("unused")
	private void setEfetiva(boolean efetiva) {
		this.efetiva = efetiva;
	}

	@SuppressWarnings("unused")
	private void setValor(double valor) {
		this.valor = valor;
	}

	@SuppressWarnings("unused")
	private void setReincidencia(int reincidencia) {
		this.reincidencia = reincidencia;
	}

	@SuppressWarnings("unused")
	private void setReincidente(boolean reincidente) {
		this.reincidente = reincidente;
	}

}