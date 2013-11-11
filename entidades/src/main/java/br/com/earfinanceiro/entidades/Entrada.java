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
@DiscriminatorValue("entrada")
public class Entrada extends AbstractConta implements IConta {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.financemanager.dados.IConta#contabilizaValor()
	 */
	@Override
	public Double contabilizaValor() {
		return this.valor;
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
		if (!(obj instanceof Entrada)) {
			return false;
		}
		return super.equals(obj);
	}

}
