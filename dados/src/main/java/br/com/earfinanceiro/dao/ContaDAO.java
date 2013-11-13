/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.criteria.Predicate;

import br.com.earfinanceiro.entidades.AbstractConta;
import br.com.earfinanceiro.entidades.IConta;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class ContaDAO extends ContaAbstractDAO<AbstractConta> implements
		IContaDAO {

	/**
	 * 
	 */
	public ContaDAO() {
		super(AbstractConta.class);
	}

	@Override
	public List<IConta> getContasNaoEfetivas() {
		Predicate pred = this.cb.isNull(this.root.get("dataEfetivacao").as(
				Calendar.class));
		List<IConta> contas = new ArrayList<>();
		for (IConta conta : this.listaCondicoes(pred)) {
			contas.add(conta);
		}
		return contas;
	}

}
