/**
 * 
 */
package br.com.earfinanceiro.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author richard.santana
 * 
 */
@Entity
@Table(name = "parcela")
@SequenceGenerator(name = Parcela.PARCELA_SEQUENCE, sequenceName = Parcela.PARCELA_SEQUENCE, initialValue = 1, allocationSize = 50)
@XmlRootElement(name = "parcela")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Parcela {

	/**
	 * String que define a sequencia dessa entidade
	 */
	public static final String PARCELA_SEQUENCE = "parcela_sequence";

	private Long id;
	private Calendar dataVencimento;
	private Calendar dataEfetivacao;
	private Double valor;
	private IConta conta;

	/**
	 * 
	 */
	public Parcela() {
		this.dataVencimento = Calendar.getInstance();
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @param dataEfetivacao
	 *            the dataEfetivacao to set
	 */
	public void setDataEfetivacao(Calendar dataEfetivacao) {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parcela other = (Parcela) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = PARCELA_SEQUENCE, strategy = GenerationType.SEQUENCE)
	@XmlAttribute(name = "id")
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dataVencimento
	 */
	@Column(name = "data_vencimento")
	@NotNull(message = "O campo data cadastro deve ser preenchido")
	@XmlElement(name = "dataVencimento", required = true)
	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * @param dataVencimento
	 *            the dataVencimento to set
	 */
	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	/**
	 * @return the dataEfetivacao
	 */
	@Column(name = "data_efetivacao")
	@XmlElement(name = "dataEfetivacao")
	public Calendar getDataEfetivacao() {
		return dataEfetivacao;
	}

	/**
	 * @return the valor
	 */
	@Column(name = "valor")
	@NotNull(message = "O campo valor deve ser preenchido")
	@XmlElement(name = "valor", required = true)
	public Double getValor() {
		return valor;
	}

	@Transient
	@XmlTransient
	public Double getContabilizaValor() {
		return conta.getContabilizaValor();
	}

	/**
	 * @return the saida
	 */
	@ManyToOne(targetEntity = AbstractConta.class, fetch = FetchType.EAGER)
	@XmlTransient
	public IConta getConta() {
		return conta;
	}

	public void setConta(IConta conta) {
		this.conta = conta;

	}

}
