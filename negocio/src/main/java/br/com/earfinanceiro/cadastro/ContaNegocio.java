/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.dao.IContaDAO;
import br.com.earfinanceiro.entidades.AbstractConta;
import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.exceptions.ErroCadastroException;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class ContaNegocio implements IContaNegocio {

	@EJB
	private IContaDAO dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.IContaNegocio#getContasNaoEfetivas()
	 */
	@Override
	public List<IConta> getContasNaoEfetivas() {
		return dao.getContasNaoEfetivas();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.IContaNegocio#efetiva(java.util.List,
	 * java.util.Calendar)
	 */
	@Override
	public void efetiva(List<IConta> contas, Calendar dataEfetivacao)
			throws ErroCadastroException {
		for (IConta conta : contas) {
			conta.setDataEfetivacao(dataEfetivacao);
			dao.atualizar((AbstractConta) conta);
		}

	}

}
