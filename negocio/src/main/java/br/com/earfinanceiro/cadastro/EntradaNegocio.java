/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.dao.IEntradaDAO;
import br.com.earfinanceiro.dao.ISubgrupoDAO;
import br.com.earfinanceiro.entidades.Entrada;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
@Stateless
@Local
public class EntradaNegocio implements IEntradaNegocio {

	@EJB
	private ISubgrupoDAO subgrupoDAO;

	@EJB
	private IEntradaDAO dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IEntradaNegocio#salva(br.com.earfinanceiro
	 * .entidades.Entrada)
	 */
	@Override
	public void salva(Entrada entrada) {
		dao.salvar(entrada);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IEntradaNegocio#atualiza(br.com.earfinanceiro
	 * .entidades.Entrada)
	 */
	@Override
	public void atualiza(Entrada entrada) {
		dao.atualizar(entrada);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IEntradaNegocio#excluir(br.com.earfinanceiro
	 * .entidades.Entrada)
	 */
	@Override
	public void excluir(Entrada entrada) {
		dao.excluir(entrada);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.IEntradaNegocio#getSubgrupos()
	 */
	@Override
	public List<Subgrupo> getSubgrupos() {
		return subgrupoDAO.listaSubgruposEntrada();
	}

}
