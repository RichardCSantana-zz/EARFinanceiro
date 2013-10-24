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

}
