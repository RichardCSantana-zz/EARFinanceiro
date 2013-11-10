package br.com.earfinanceiro.dao;

import java.util.Calendar;
import java.util.List;

import br.com.earfinanceiro.entidades.AbstractConta;

/**
 * @author Richard
 * 
 * @param <T>
 *            - Class base para os procedimentos de persistência
 */
public abstract class ContaAbstractDAO<T extends AbstractConta> extends
		AbstractDAO<T> implements IAbstractContaDAO<T> {

	private GeradorCriteriaData<T> gcd;

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

}