package br.com.earfinanceiro.cadastro;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.dao.IGrupoDAO;
import br.com.earfinanceiro.dao.ISubgrupoDAO;
import br.com.earfinanceiro.entidades.Grupo;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
@Stateless
@Local
public class SubgrupoNegocio implements ISubgrupoNegocio {

	@EJB
	private ISubgrupoDAO dao;

	@EJB
	private IGrupoDAO grupoDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.ISubGrupoNegocio#salvaSubgrupo(br.com.
	 * earfinanceiro.entidades.Subgrupo)
	 */
	@Override
	public void salva(Subgrupo subgrupo) {
		if (subgrupo.getId() == null) {
			this.dao.salvar(subgrupo);
		} else {
			this.dao.atualizar(subgrupo);
		}
		this.dao.salvar(subgrupo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.ISubGrupoNegocio#excluir(br.
	 * com.earfinanceiro.entidades.Subgrupo)
	 */
	@Override
	public void exclui(Subgrupo subgrupo) {
		this.dao.excluir(subgrupo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.ISubGrupoNegocio#listarSubgrupos()
	 */
	@Override
	public List<Subgrupo> lista() {
		return this.dao.listaTodos();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.ISubGrupoNegocio#getGrupos()
	 */
	@Override
	public List<Grupo> getGrupos() {
		return this.grupoDAO.listaTodos();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.ISubgrupoNegocio#retorna(java.lang.Long)
	 */
	@Override
	public Subgrupo retorna(Long id) {
		return this.dao.getPorId(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.ISubgrupoNegocio#exclui(java.lang.Long)
	 */
	@Override
	public void exclui(Long id) {
		this.dao.excluir(id);
	}

}
