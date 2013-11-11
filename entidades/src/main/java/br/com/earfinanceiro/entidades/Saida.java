/**
 * 
 */
package br.com.earfinanceiro.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Richard
 * 
 */
@Entity
@DiscriminatorValue("saida")
public class Saida extends AbstractConta implements IConta {

	/**
	 * 
	 */
	public Saida() {
		this.parcelamento = 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.financemanager.dados.IConta#contabilizaValor()
	 */
	@Override
	public Double contabilizaValor() {
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

}
