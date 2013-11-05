/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.dao.IGrupoDAO;
import br.com.earfinanceiro.entidades.Grupo;

/**
 * @author Richard
 * 
 */
@Stateless
@Local
public class GrupoNegocio implements IGrupoNegocio {

	@EJB
	private IGrupoDAO dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IGrupoNegocio#salvaGrupo(br.com.earfinanceiro
	 * .entidades.Grupo)
	 */
	@Override
	public void salvaGrupo(Grupo grupo) {
		dao.salvar(grupo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.IGrupoNegocio#atualizarGrupo(br.com.
	 * earfinanceiro.entidades.Grupo)
	 */
	@Override
	public void atualizaGrupo(Grupo grupo) {
		dao.atualizar(grupo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IGrupoNegocio#excluirGrupo(br.com.earfinanceiro
	 * .entidades.Grupo)
	 */
	@Override
	public void excluirGrupo(Grupo grupo) {
		dao.excluir(grupo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.IGrupoNegocio#listarGrupos()
	 */
	@Override
	public List<Grupo> listarGrupos() {
		return dao.listaTodos();
	}

}
