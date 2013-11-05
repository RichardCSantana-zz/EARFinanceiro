/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.ArrayList;
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

	public ContaDAO() {
		super(AbstractConta.class);
	}

	@Override
	public List<IConta> getContasNaoEfetivas() {
		Predicate pred1 = cb.equal(root.get("efetiva"), false);
		List<IConta> contas = new ArrayList<>();
		for (IConta conta : listaCondicoes(pred1)) {
			contas.add(conta);
		}
		return contas;
	}

}
