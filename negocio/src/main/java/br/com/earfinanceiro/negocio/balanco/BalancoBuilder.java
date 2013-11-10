/**
 * 
 */
package br.com.earfinanceiro.negocio.balanco;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.dao.IContaDAO;
import br.com.earfinanceiro.entidades.IConta;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class BalancoBuilder implements IBalancoBuilder {

	@EJB
	private IContaDAO dao;

	@Override
	public Balanco geraBalanco(Calendar dataInicial, Calendar dataFinal)
			throws IllegalArgumentException {
		if (dataFinal.compareTo(dataInicial) < 0) {
			throw new IllegalArgumentException(
					"A data inicial deve ser maior ou igual a data final");
		}
		Balanco balanco = new Balanco();
		List<IConta> contas = new ArrayList<>();
		contas.addAll(this.dao.geraListaPorDataEfetivacao(dataInicial,
				dataFinal));
		balanco.setContas(contas);
		return balanco;
	}

}
