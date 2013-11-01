/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author richard.santana
 * 
 */
public abstract class AbstractDAO<T> implements IDAO<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> classe;

	protected CriteriaBuilder cb;
	protected Root<T> root;

	/**
	 * @param classe
	 */
	protected AbstractDAO(Class<T> classe) {
		this.classe = classe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#salvar(T)
	 */
	@Override
	public void salvar(T valor) {
		em.persist(valor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#atualizar(T)
	 */
	@Override
	public void atualizar(T valor) {
		em.merge(valor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#excluir(T)
	 */
	@Override
	public void excluir(T valor) {
		em.remove(valor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#listaTodos()
	 */
	@Override
	public List<T> listaTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> criteria = cb.createQuery(classe);
		criteria.select(root);
		List<T> resultados;
		try {
			resultados = em.createQuery(criteria).getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("Não foram encontrados resultados.");
		}
		return resultados;
	}

	protected List<T> listaCondicoes(Predicate predicate) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> criteria = cb.createQuery(classe);
		criteria.select(root);
		criteria.where(predicate);
		List<T> resultados;
		try {
			resultados = em.createQuery(criteria).getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("Não foram encontrados resultados.");
		}
		return resultados;
	}

}
