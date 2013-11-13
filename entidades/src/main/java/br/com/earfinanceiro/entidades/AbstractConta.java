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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Richard
 * 
 */
@Entity
@Table(name = "conta")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
@SequenceGenerator(name = AbstractConta.CONTA_SEQUENCE, sequenceName = AbstractConta.CONTA_SEQUENCE, initialValue = 1, allocationSize = 10)
@XmlRootElement(name = "conta")
@XmlAccessorType(XmlAccessType.PROPERTY)
public abstract class AbstractConta implements IConta {

	/**
	 * 
	 */
	public AbstractConta() {
		this.dataVencimento = Calendar.getInstance();
	}

	/**
	 * String que define a sequencia dessa entidade
	 */
	public static final String CONTA_SEQUENCE = "conta_sequence";

	protected Long id;
	protected String descricao;
	protected Calendar dataVencimento;
	protected Calendar dataEfetivacao;
	protected Subgrupo subgrupo;
	protected double valor;

	/**
	 * 
	 * Insere um valor
	 * 
	 * @param valor
	 *            - Double a ser inserida na conta
	 */
	public void setValor(Double valor) {
		if (valor.compareTo(0.0) < 1) {
			throw new IllegalArgumentException("Valor deve ser maior que 0");
		}
		this.valor = valor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.entidades.IConta#setDataEfetivacao(java.util.Calendar
	 * )
	 */
	@Override
	public void setDataEfetivacao(Calendar dataEfetivacao) {
		if ((dataEfetivacao != null)
				&& dataEfetivacao.after(Calendar.getInstance())) {
			throw new IllegalArgumentException(
					"Uma conta não pode ser efetivada para um dia depois de hoje.");
		}
		this.dataEfetivacao = dataEfetivacao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractConta)) {
			return false;
		}
		AbstractConta other = (AbstractConta) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.entidades.IConta#getId()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CONTA_SEQUENCE)
	@Column(name = "id")
	@XmlAttribute(name = "id")
	public Long getId() {
		return this.id;
	}

	/**
	 * 
	 * Insere um id
	 * 
	 * @param id
	 *            - Long identificador da conta
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.entidades.IConta#getDescricao()
	 */
	@Override
	@Column(name = "descricao")
	@NotNull(message = "O campo descrição deve ser preenchido")
	@Size(min = 3, max = 40, message = "O campo descricao deve possuir entre 3 e 40 caracteres")
	@XmlElement(name = "descricao", required = true)
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * 
	 * Insere uma descrição
	 * 
	 * @param descricao
	 *            - String que servirá de descrição da conta
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.entidades.IConta#getDataCadastro()
	 */
	@Override
	@Column(name = "data_vencimento")
	@NotNull(message = "O campo data cadastro deve ser preenchido")
	@XmlElement(name = "dataVencimento", required = true)
	public Calendar getDataVencimento() {
		return this.dataVencimento;
	}

	/**
	 * 
	 * Insere a data de vencimento da conta
	 * 
	 * @param dataVencimento
	 *            - Calendar que define a data de vencimento para o pagamento da
	 *            conta
	 */
	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.entidades.IConta#getValor()
	 */
	@Override
	@Column(name = "valor")
	@NotNull(message = "O campo valor deve ser preenchido")
	@XmlElement(name = "valor", required = true)
	public Double getValor() {
		return this.valor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.entidades.IConta#getDataEfetivacao()
	 */
	@Override
	@Column(name = "data_efetivacao")
	@XmlElement(name = "dataEfetivacao")
	public Calendar getDataEfetivacao() {
		return this.dataEfetivacao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.entidades.IConta#isEfetiva()
	 */
	@Override
	@Transient
	@XmlTransient
	public Boolean isEfetiva() {
		return (this.dataEfetivacao != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.entidades.IConta#getSubGrupo()
	 */
	@Override
	@ManyToOne(targetEntity = Subgrupo.class, fetch = FetchType.EAGER)
	@XmlElement(type = Subgrupo.class, name = "subgrupo", required = true)
	public Subgrupo getSubgrupo() {
		return this.subgrupo;
	}

	/**
	 * 
	 * Insere um subgrupo
	 * 
	 * @param subgrupo
	 *            - {@link Subgrupo} da conta
	 */
	public void setSubgrupo(Subgrupo subgrupo) {
		this.subgrupo = subgrupo;
	}
}