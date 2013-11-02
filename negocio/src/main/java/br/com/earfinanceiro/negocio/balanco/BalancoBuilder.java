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

import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.interfaces.IContaDAO;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class BalancoBuilder implements IBalancoBuilder {

	@EJB
	private IContaDAO dao;

	public Balanco geraBalanco(Calendar dataInicial, Calendar dataFinal) {
		Balanco balanco = new Balanco();
		List<IConta> contas = new ArrayList<>();
		contas.addAll(dao.geraListaPorDataEfetivacao(dataInicial, dataFinal));
		balanco.setContas(contas);
		return balanco;
	}

}
