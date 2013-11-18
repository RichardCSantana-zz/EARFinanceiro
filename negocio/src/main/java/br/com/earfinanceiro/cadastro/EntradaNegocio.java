/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.dao.IEntradaDAO;
import br.com.earfinanceiro.dao.IParcelaDAO;
import br.com.earfinanceiro.dao.ISubgrupoDAO;
import br.com.earfinanceiro.entidades.Entrada;
import br.com.earfinanceiro.entidades.Parcela;
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

	@EJB
	private IParcelaDAO parcelaDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IEntradaNegocio#salva(br.com.earfinanceiro
	 * .entidades.Entrada)
	 */
	@Override
	public void salva(Entrada entrada) {
		if (entrada.getId() == null) {
			for (Parcela parcela : entrada.getParcelas()) {
				parcelaDao.salvar(parcela);
			}
			this.dao.salvar(entrada);
		} else {
			this.dao.atualizar(entrada);
		}
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
		this.dao.excluir(entrada);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.IEntradaNegocio#getSubgrupos()
	 */
	@Override
	public List<Subgrupo> getSubgrupos() {
		return this.subgrupoDAO.listaSubgruposEntrada();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IEntradaNegocio#retorna(java.lang.Long)
	 */
	@Override
	public Entrada retorna(Long id) {
		return this.dao.procurar(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.IEntradaNegocio#exclui(java.lang.Long)
	 */
	@Override
	public void exclui(Long id) {
		this.dao.excluir(id);
	}

}
