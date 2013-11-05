/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.Calendar;
import java.util.List;

import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.exceptions.ErroCadastroException;

/**
 * @author richard.santana
 * 
 */
public interface IContaNegocio {

	List<IConta> getContasNaoEfetivas();

	void efetiva(IConta conta, Calendar dataEfetivacao)
			throws ErroCadastroException;

}
