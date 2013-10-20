/**
 * 
 */
package br.com.financemanager.dados;



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
