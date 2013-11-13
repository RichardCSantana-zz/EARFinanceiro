/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.dao.ISaidaDAO;
import br.com.earfinanceiro.dao.ISubgrupoDAO;
import br.com.earfinanceiro.entidades.Saida;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
@Stateless
@Local
public class SaidaNegocio implements ISaidaNegocio {

	@EJB
	private ISubgrupoDAO subgrupoDAO;

	@EJB
	private ISaidaDAO dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.ISaidaNegocio#salva(br.com.earfinanceiro
	 * .entidades.Saida)
	 */
	@Override
	public void salva(Saida saida) {
		if (saida.getId() == null) {
			// TODO: rever parcelamento
			this.dao.salvar(saida);
		} else {
			this.dao.atualizar(saida);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.ISaidaNegocio#excluir(br.com.earfinanceiro
	 * .entidades.Saida)
	 */
	@Override
	public void excluir(Saida saida) {
		this.dao.excluir(saida);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.ISaidaNegocio#getSubgrupos()
	 */
	@Override
	public List<Subgrupo> getSubgrupos() {
		return this.subgrupoDAO.listaSubgruposSaida();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.ISaidaNegocio#retorna(java.lang.Long)
	 */
	@Override
	public Saida retorna(Long id) {
		return this.dao.procurar(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.ISaidaNegocio#exclui(java.lang.Long)
	 */
	@Override
	public void exclui(Long id) {
		this.dao.excluir(id);
	}

}
