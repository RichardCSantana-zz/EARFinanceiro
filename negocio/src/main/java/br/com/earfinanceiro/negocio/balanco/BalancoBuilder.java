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

import br.com.earfinanceiro.dao.IParcelaDAO;
import br.com.earfinanceiro.entidades.AbstractConta;
import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.entidades.Parcela;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class BalancoBuilder implements IBalancoBuilder {

	@EJB
	private IParcelaDAO dao;

	@Override
	public Balanco geraBalanco(Calendar dataInicial, Calendar dataFinal)
			throws IllegalArgumentException {
		if (dataFinal.compareTo(dataInicial) < 0) {
			throw new IllegalArgumentException(
					"A data inicial deve ser maior ou igual a data final");
		}
		List<Parcela> parcelas = this.dao.geraListaPorDataEfetivacao(
				dataInicial, dataFinal);
		List<IConta> contas = new ArrayList<>();
		for (Parcela parcela : parcelas) {
			IConta conta = parcela.getConta();
			if (!contas.contains(parcela.getConta())) {
				contas.add(conta);
				((AbstractConta) conta).setParcelas(new ArrayList<Parcela>());
			}
			conta.getParcelas().add(parcela);
		}
		Balanco balanco = new Balanco();
		balanco.setContas(contas);
		return balanco;
	}

}
