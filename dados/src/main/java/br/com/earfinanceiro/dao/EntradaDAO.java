/**
 * 
 */
package br.com.earfinanceiro.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.entidades.Entrada;
import br.com.earfinanceiro.entidades.TipoEnum;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class EntradaDAO extends ContaAbstractDAO<Entrada> implements
		IEntradaDAO {

	/**
	 * 
	 */
	public EntradaDAO() {
		super(Entrada.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.AbstractDAO#salvar(java.lang.Object)
	 */
	@Override
	public void salvar(Entrada valor) {
		if (!valor.getSubgrupo().getGrupo().getTipo().equals(TipoEnum.ENTRADA)) {
			throw new IllegalArgumentException("O valor deve ser de entrada");
		}
		super.salvar(valor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.dao.AbstractDAO#atualizar(java.lang.Object)
	 */
	@Override
	public void atualizar(Entrada valor) {
		if (!valor.getSubgrupo().getGrupo().getTipo().equals(TipoEnum.ENTRADA)) {
			throw new IllegalArgumentException("O valor deve ser de entrada");
		}
		super.atualizar(valor);
	}

}
