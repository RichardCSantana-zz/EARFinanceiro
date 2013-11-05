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
		dao.salvar(saida);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.ISaidaNegocio#atualiza(br.com.earfinanceiro
	 * .entidades.Saida)
	 */
	@Override
	public void atualiza(Saida saida) {
		dao.atualizar(saida);
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
		dao.excluir(saida);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.ISaidaNegocio#getSubgrupos()
	 */
	@Override
	public List<Subgrupo> getSubgrupos() {
		return subgrupoDAO.listaSubgruposSaida();
	}

}
