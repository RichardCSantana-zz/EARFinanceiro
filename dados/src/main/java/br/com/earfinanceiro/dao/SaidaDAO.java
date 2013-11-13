/**
 * 
 */
package br.com.earfinanceiro.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.entidades.Saida;
import br.com.earfinanceiro.entidades.TipoEnum;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class SaidaDAO extends ContaAbstractDAO<Saida> implements ISaidaDAO {

	/**
	 * 
	 */
	public SaidaDAO() {
		super(Saida.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.AbstractDAO#salvar(java.lang.Object)
	 */
	@Override
	public void salvar(Saida valor) {
		if (!valor.getSubgrupo().getGrupo().getTipo().equals(TipoEnum.SAIDA)) {
			throw new IllegalArgumentException("O valor deve ser de saída");
		}
		super.salvar(valor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.AbstractDAO#atualizar(java.lang.Object)
	 */
	@Override
	public void atualizar(Saida valor) {
		if (!valor.getSubgrupo().getGrupo().getTipo().equals(TipoEnum.SAIDA)) {
			throw new IllegalArgumentException("O valor deve ser de saída");
		}
		super.atualizar(valor);
	}

}
