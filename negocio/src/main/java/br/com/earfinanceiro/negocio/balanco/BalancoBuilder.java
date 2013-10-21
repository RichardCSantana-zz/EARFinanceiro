/**
 * 
 */
package br.com.earfinanceiro.negocio.balanco;

import java.util.List;

import br.com.earfinanceiro.entidades.IConta;

/**
 * @author richard.santana
 * 
 */
public class BalancoBuilder {

	public static Balanco geraBalanco(List<IConta> contas) {
		Balanco balanco = new Balanco();
		balanco.setContas(contas);
		return balanco;
	}

}
