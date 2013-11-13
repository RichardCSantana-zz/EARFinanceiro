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
 * @param <T>
 *            Class base para os procedimentos de persistência
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
	 *            - Class que determina o tipo de classe do objeto
	 */
	protected AbstractDAO(Class<T> classe) {
		this.classe = classe;
	}

	@PostConstruct
	void init() {
		this.cb = this.em.getCriteriaBuilder();
		this.criteria = this.cb.createQuery(this.classe);
		this.root = this.criteria.from(this.classe);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#procurar(java.lang.Long)
	 */
	@Override
	public T procurar(Long id) {
		return this.em.find(this.classe, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#salvar(T)
	 */
	@Override
	public void salvar(T valor) {
		this.em.persist(valor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#atualizar(T)
	 */
	@Override
	public void atualizar(T valor) {
		this.em.merge(valor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#excluir(T)
	 */
	@Override
	public void excluir(T valor) {
		this.em.remove(this.em.getReference(classe, valor));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#excluir(java.lang.Long)
	 */
	@Override
	public void excluir(Long id) {
		this.em.remove(this.em.getReference(classe, id));
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
			resultados = this.em.createQuery(this.criteria).getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("Não foram encontrados resultados.");
		}
		return resultados;
	}

	protected List<T> listaCondicoes(Predicate predicate) {
		this.criteria.select(this.root);
		this.criteria.where(predicate);
		List<T> resultados;
		try {
			resultados = this.em.createQuery(this.criteria).getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("Não foram encontrados resultados.");
		}
		return resultados;
	}

	protected T unicoCondicoes(Predicate predicate) {
		this.criteria.select(this.root);
		this.criteria.where(predicate);
		T resultado;
		try {
			resultado = this.em.createQuery(this.criteria).getSingleResult();
		} catch (NoResultException e) {
			throw new NoResultException("Não foram encontrados resultados.");
		}
		return resultado;
	}

}
