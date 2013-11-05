/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.criteria.Predicate;

import br.com.earfinanceiro.entidades.Subgrupo;
import br.com.earfinanceiro.entidades.TipoEnum;

/**
 * @author Richard
 * 
 */
@Stateless
@Local
public class SubgrupoDAO extends AbstractDAO<Subgrupo> implements ISubgrupoDAO {

	/**
	 * @param classe
	 */
	protected SubgrupoDAO() {
		super(Subgrupo.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.IGrupoDAO#getPorId(java.lang.String)
	 */
	@Override
	public Subgrupo getPorId(Long id) {
		return em.find(Subgrupo.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.ISubgrupoDAO#SubgruposEntrada()
	 */
	@Override
	public List<Subgrupo> listaSubgruposEntrada() {
		Predicate predicate = cb.equal(root.get("grupo").get("tipo"),
				TipoEnum.ENTRADA);
		return super.listaCondicoes(predicate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.ISubgrupoDAO#SubgruposSaida()
	 */
	@Override
	public List<Subgrupo> listaSubgruposSaida() {
		Predicate predicate = cb.equal(root.get("grupo").get("tipo"),
				TipoEnum.SAIDA);
		return super.listaCondicoes(predicate);
	}

}
