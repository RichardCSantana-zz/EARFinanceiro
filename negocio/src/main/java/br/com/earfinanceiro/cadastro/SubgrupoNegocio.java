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
	public void salvaSubgrupo(Subgrupo subgrupo) {
		this.dao.salvar(subgrupo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.ISubGrupoNegocio#atualizaSubgrupo(br.com
	 * .earfinanceiro.entidades.Subgrupo)
	 */
	@Override
	public void atualizaSubgrupo(Subgrupo subgrupo) {
		this.dao.atualizar(subgrupo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.ISubGrupoNegocio#excluirsubSubgrupo(br.
	 * com.earfinanceiro.entidades.Subgrupo)
	 */
	@Override
	public void excluirsubSubgrupo(Subgrupo subgrupo) {
		this.dao.excluir(subgrupo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.ISubGrupoNegocio#listarSubgrupos()
	 */
	@Override
	public List<Subgrupo> listarSubgrupos() {
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

}
