/**
 * 
 */
package br.com.earfinanceiro;

import java.util.List;

import br.com.financemanager.entidades.IConta;

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
