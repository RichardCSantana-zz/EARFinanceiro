/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.earfinanceiro.entidades.Persistivel;
import br.com.earfinanceiro.log.factory.ILoggerFactory;

/**
 * @author richard.santana
 * @param <T>
 *            Class base para os procedimentos de persistência
 * 
 */
public abstract class AbstractDAO<T extends Persistivel> implements IDAO<T> {

	@EJB
	private ILoggerFactory loggerFactory;

	private Logger logger;

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
		logger = loggerFactory.getLog(this.getClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#procurar(java.lang.Long)
	 */
	@Override
	public T procurar(Long id) {
		logger.fine("Procurando pelo id=" + id);
		T find = this.em.find(this.classe, id);
		if (find == null) {
			logger.fine("Nada encontrado");
		} else {
			logger.fine("Encontrado:" + find.verbalizar());
		}
		return find;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#salvar(T)
	 */
	@Override
	public void salvar(T valor) {
		logger.fine("Persistindo valor:" + valor.verbalizar());
		this.em.persist(valor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#atualizar(T)
	 */
	@Override
	public void atualizar(T valor) {
		logger.fine("Atualizar valor:" + valor.verbalizar());
		this.em.merge(valor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#excluir(T)
	 */
	@Override
	public void excluir(T valor) {
		excluir(valor.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#excluir(java.lang.Long)
	 */
	@Override
	public void excluir(Long id) {
		T reference = this.em.getReference(classe, id);
		logger.fine("Excluir valor:" + reference.verbalizar());
		this.em.remove(reference);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IDAO#listaTodos()
	 */
	@Override
	public List<T> listaTodos() {
		logger.fine("Listando itens");
		List<T> resultados = null;
		try {
			resultados = this.em.createQuery(this.criteria).getResultList();
		} catch (NoResultException e) {
			logger.severe("Não foram encontrados resultados");
		}
		init();
		if (!resultados.isEmpty()) {
			logger.fine("Foram encontrados " + resultados.size()
					+ " resultados");
		}
		return resultados;
	}

	protected List<T> listaCondicoes(Predicate predicate) {
		logger.fine("Listando itens");
		this.criteria.select(this.root);
		this.criteria.where(predicate);
		List<T> resultados = null;
		try {
			resultados = this.em.createQuery(this.criteria).getResultList();
		} catch (NoResultException e) {
			logger.severe("Não foram encontrados resultados");
		}
		init();
		if (!resultados.isEmpty()) {
			logger.fine("Foram encontrados " + resultados.size()
					+ " resultados");
		}
		return resultados;
	}

	protected T unicoCondicoes(Predicate predicate) {
		logger.fine("Procurando item");
		this.criteria.select(this.root);
		this.criteria.where(predicate);
		List<T> resultados = null;
		try {
			resultados = this.em.createQuery(this.criteria).getResultList();
		} catch (NoResultException e) {
			logger.severe("Não foi encontrado resultado");
		}
		init();
		if (resultados.isEmpty()) {
			return null;
		} else if (resultados.size() != 1) {
			throw new NonUniqueResultException(
					"Mais de um resultado encontrado");
		} else {
			return resultados.get(0);
		}
	}

}
