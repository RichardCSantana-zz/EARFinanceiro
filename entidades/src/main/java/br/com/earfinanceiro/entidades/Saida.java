/**
 * 
 */
package br.com.earfinanceiro.entidades;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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

	/**
	 * 
	 */
	public Saida() {

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
		return (this.parcelas.size() > 1);
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
		this.parcelas = new ArrayList<>();
		Calendar vencimento = (Calendar) dataVencimento.clone();
		for (int i = 0; i < parcelamento; i++) {
			Parcela parcela = new Parcela();
			parcela.setConta(this);
			Double valorParcela = valor / parcelamento;
			parcela.setValor(valorParcela);
			parcela.setDataVencimento((Calendar) vencimento.clone());
			vencimento.add(Calendar.MONTH, 1);
			this.parcelas.add(parcela);
		}
	}

	@Transient
	@XmlTransient
	public Integer getParcelamento() {
		return this.parcelas.size();
	}

	@Override
	@XmlTransient
	@Transient
	public Double getValorConvertido(Double valorAtual) {
		Double retorno = new Double(0.0) - valorAtual;
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

}
