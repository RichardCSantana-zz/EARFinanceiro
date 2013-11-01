/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.Calendar;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author richard.santana
 * 
 */
public class GeradorCriteriaData<T> {

	private CriteriaBuilder cb;
	private Root<T> root;

	/**
	 * 
	 */
	protected GeradorCriteriaData(CriteriaBuilder cb, Root<T> root) {
		this.cb = cb;
		this.root = root;
	}

	public Predicate geraCriteria(Calendar inicio, Calendar fim) {
		Predicate cond1 = cb.greaterThanOrEqualTo(root.get("dataEfetivacao")
				.as(Calendar.class), inicio);
		Calendar dataFinal = (Calendar) fim.clone();
		dataFinal.add(Calendar.DAY_OF_MONTH, 1);
		Predicate cond2 = cb.lessThanOrEqualTo(
				root.get("dataEfetivacao").as(Calendar.class), dataFinal);
		return cb.and(cond1, cond2);
	}

}
