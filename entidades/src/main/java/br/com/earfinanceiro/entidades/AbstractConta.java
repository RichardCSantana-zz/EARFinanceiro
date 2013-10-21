/**
 * 
 */
package br.com.earfinanceiro.entidades;

import java.util.Calendar;

import br.com.earfinanceiro.exceptions.ErroCadastroException;

/**
 * @author Richard
 * 
 */
public abstract class AbstractConta implements IConta {

	protected Long id;
	protected String descricao;
	protected Calendar dataCadastro;
	protected Calendar dataEfetivacao;
	protected Grupo subGrupo;
	protected boolean efetiva;
	protected double valor;

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
					"A conta que estão tentando efetivar já foi efetivada");
		}
		this.efetiva = true;
		this.dataEfetivacao = dataEfetivacao;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValor() {
		return valor;
	}

	public Calendar getDataEfetivacao() {
		return dataEfetivacao;
	}

	public Boolean getEfetiva() {
		return efetiva;
	}

	public Grupo getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(Grupo subGrupo) {
		this.subGrupo = subGrupo;
	}

}