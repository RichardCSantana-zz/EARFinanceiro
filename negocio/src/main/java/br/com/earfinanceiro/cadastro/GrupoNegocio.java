/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.dao.IGrupoDAO;
import br.com.earfinanceiro.entidades.Grupo;
import br.com.earfinanceiro.entidades.TipoEnum;

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
	public void salva(Grupo grupo) {
		if (grupo.getId() == null) {
			this.dao.salvar(grupo);
		} else {
			this.dao.atualizar(grupo);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IGrupoNegocio#excluirGrupo(br.com.earfinanceiro
	 * .entidades.Grupo)
	 */
	@Override
	public void exclui(Grupo grupo) {
		this.dao.excluir(grupo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.IGrupoNegocio#listarGrupos()
	 */
	@Override
	public List<Grupo> lista() {
		return this.dao.listaTodos();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IGrupoNegocio#excluirGrupo(java.lang.Long)
	 */
	@Override
	public void exclui(Long id) {
		this.dao.excluir(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IGrupoNegocio#retornaGrupo(java.lang.Long)
	 */
	@Override
	public Grupo retorna(Long id) {
		return this.dao.procurar(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.IGrupoNegocio#listaTipos()
	 */
	@Override
	public List<TipoEnum> listaTipos() {
		List<TipoEnum> tipos = Arrays.asList(TipoEnum.values());
		return tipos;
	}

}
