/**
 * 
 */
package br.com.financemanager.entidades;



/**
 * @author Richard
 * 
 */
public class Entrada extends AbstractConta implements IConta {

	/* (non-Javadoc)
	 * @see br.com.financemanager.dados.IConta#contabilizaValor()
	 */
	@Override
	public Double contabilizaValor() {
		return this.valor;
	}

}
