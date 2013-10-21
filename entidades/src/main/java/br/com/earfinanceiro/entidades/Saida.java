/**
 * 
 */
package br.com.earfinanceiro.entidades;

/**
 * @author Richard
 * 
 */
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
