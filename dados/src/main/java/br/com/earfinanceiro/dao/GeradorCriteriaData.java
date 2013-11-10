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
 * @param <T>
 *            - Class base para os procedimentos de persistência
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

	/**
	 * 
	 * Método que gera um predicate de BETWEEN com duas datas para limite
	 * 
	 * @param inicio
	 *            - {@link Calendar} que representa a data de inicio da Criteria
	 * @param fim
	 *            - {@link Calendar} que representa a data de final da Criteria
	 * @return Predicate com determinação de datas
	 */
	public Predicate geraCriteria(Calendar inicio, Calendar fim) {
		Predicate cond1 = this.cb.greaterThanOrEqualTo(
				this.root.get("dataEfetivacao").as(Calendar.class), inicio);
		Calendar dataFinal = (Calendar) fim.clone();
		dataFinal.add(Calendar.DAY_OF_MONTH, 1);
		Predicate cond2 = this.cb.lessThanOrEqualTo(
				this.root.get("dataEfetivacao").as(Calendar.class), dataFinal);
		return this.cb.and(cond1, cond2);
	}

}
