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

}
