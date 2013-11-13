/**
 * 
 */
package br.com.earfinanceiro.entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Richard
 * 
 */
@Entity
@DiscriminatorValue("saida")
@XmlRootElement(name = "saida")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Saida extends AbstractConta implements IConta {

	protected int parcelamento;

	/**
	 * 
	 */
	public Saida() {
		this.parcelamento = 1;
	}

	/**
	 * 
	 * Retorna se a conta foi parcelada
	 * 
	 * @return boolean que define se a conta foi parcelada
	 */
	@Transient
	@XmlTransient
	public boolean isParcelada() {
		return (this.parcelamento > 1);
	}

	/**
	 * 
	 * Preenche o número de parcelas da conta
	 * 
	 * @param parcelamento
	 *            - Integer que representa o número de parcelas
	 */
	public void setParcelamento(Integer parcelamento) {
		if (parcelamento < 1) {
			throw new IllegalArgumentException(
					"O número de parcelas deve ser no minimo 1");
		}
		this.parcelamento = parcelamento;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.financemanager.dados.IConta#contabilizaValor()
	 */
	@Override
	@XmlElement(name = "valorReal")
	@Transient
	public Double getContabilizaValor() {
		Double retorno = new Double(0.0) - this.valor;
		return retorno;
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
		if (!(obj instanceof Saida)) {
			return false;
		}
		return super.equals(obj);
	}

	/**
	 * 
	 * Retorna o número de parcelas
	 * 
	 * @return Integer que representa o número de parcelas
	 */
	@Column(name = "parcela")
	@NotNull(message = "O campo parcela deve ser preenchido")
	@XmlElement(name = "parcela", required = true)
	public Integer getParcelamento() {
		return this.parcelamento;
	}

}
