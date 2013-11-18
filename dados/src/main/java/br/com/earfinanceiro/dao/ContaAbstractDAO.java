package br.com.earfinanceiro.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.criteria.Predicate;

/**
 * @author Richard
 * 
 * @param <T>
 *            - Class base para os procedimentos de persistência
 */
public abstract class ContaAbstractDAO<T> extends AbstractDAO<T> implements
		IAbstractContaDAO<T> {

	protected GeradorCriteriaData<T> gcd;

	/**
	 * @param classe
	 *            - Class que determina o tipo de classe do objeto
	 */
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
		this.gcd = new GeradorCriteriaData<>(this.cb, this.root);
		return this.listaCondicoes(this.gcd.geraCriteria(inicio, fim));
	}

	public List<T> getNaoEfetivas() {
		Predicate pred = this.cb.isNull(this.root.get("dataEfetivacao").as(
				Calendar.class));
		List<T> contas = new ArrayList<>();
		for (T conta : this.listaCondicoes(pred)) {
			contas.add(conta);
		}
		return contas;
	}

}