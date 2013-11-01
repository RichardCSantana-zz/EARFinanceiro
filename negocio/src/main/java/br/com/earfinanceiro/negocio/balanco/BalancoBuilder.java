/**
 * 
 */
package br.com.earfinanceiro.negocio.balanco;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.entidades.IConta;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class BalancoBuilder implements IBalancoBuilder {

	public static Balanco geraBalanco(List<IConta> contas) {
		Balanco balanco = new Balanco();
		balanco.setContas(contas);
		return balanco;
	}

}
