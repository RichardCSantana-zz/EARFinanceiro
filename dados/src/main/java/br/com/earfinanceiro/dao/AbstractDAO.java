/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.List;

import javax.annotation.PostConstruct;
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

	@PersistenceContext(unitName = "primary")
	protected EntityManager em;

	private Class<T> classe;

	protected CriteriaBuilder cb;
	protected CriteriaQuery<T> criteria;
	protected Root<T> root;

	/**
	 * @param classe
	 */
	protected AbstractDAO(Class<T> classe) {
		this.classe = classe;
	}

	@PostConstruct
	void init() {
		cb = em.getCriteriaBuilder();
		criteria = cb.createQuery(classe);
		root = criteria.from(classe);
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
		List<T> resultados;
		try {
			resultados = em.createQuery(criteria).getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("Não foram encontrados resultados.");
		}
		return resultados;
	}

	protected List<T> listaCondicoes(Predicate predicate) {
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

	protected T unicoCondicoes(Predicate predicate) {
		criteria.select(root);
		criteria.where(predicate);
		T resultado;
		try {
			resultado = em.createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			throw new NoResultException("Não foram encontrados resultados.");
		}
		return resultado;
	}

}
