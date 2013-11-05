package br.com.earfinanceiro.dao;

import java.util.Calendar;
import java.util.List;

import br.com.earfinanceiro.entidades.AbstractConta;

public abstract class ContaAbstractDAO<T extends AbstractConta> extends
		AbstractDAO<T> implements IAbstractContaDAO<T> {

	private GeradorCriteriaData<T> gcd;

	public ContaAbstractDAO(Class<T> classe) {
		super(classe);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.dao.IAbstractContaDAO#geraListaPorDataEfetivacao
	 * (java.util.Calendar, java.util.Calendar)
	 */
	@Override
	public List<T> geraListaPorDataEfetivacao(Calendar inicio, Calendar fim) {
		gcd = new GeradorCriteriaData<>(cb, root);
		return listaCondicoes(gcd.geraCriteria(inicio, fim));
	}

}