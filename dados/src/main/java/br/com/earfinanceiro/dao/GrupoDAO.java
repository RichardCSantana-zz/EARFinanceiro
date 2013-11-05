/**
 * 
 */
package br.com.earfinanceiro.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.criteria.Predicate;

import br.com.earfinanceiro.entidades.Grupo;

/**
 * @author Richard
 * 
 */
@Stateless
@Local
public class GrupoDAO extends AbstractDAO<Grupo> implements IGrupoDAO {

	/**
	 * @param classe
	 */
	public GrupoDAO() {
		super(Grupo.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IGrupoDAO#getPorNome(java.lang.String)
	 */
	@Override
	public Grupo getPorNome(String nome) {
		Predicate pred1 = cb.equal(root.get("descricao"), nome);
		return unicoCondicoes(pred1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IGrupoDAO#getPorId(java.lang.String)
	 */
	@Override
	public Grupo getPorId(Long id) {
		return em.find(Grupo.class, id);
	}

}
