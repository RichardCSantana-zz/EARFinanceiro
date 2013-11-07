/**
 * 
 */
package br.com.earfinanceiro.entidades;

import java.util.Calendar;

import br.com.earfinanceiro.exceptions.ErroCadastroException;

/**
 * @author Richard
 * 
 */
public interface IConta {

	/**
	 * 
	 * Efetiva a conta
	 * 
	 * @param dataEfetivacao
	 *            - Calendar que define a data de efetivação
	 * @throws ErroCadastroException
	 *             - Quando a data de efetivação é inferior a data de cadastro
	 */
	void efetiva(Calendar dataEfetivacao) throws ErroCadastroException;

	/**
	 * 
	 * Gera uma reincidencia para a conta
	 * 
	 * @param reincidencia
	 *            - Integer que define a reincidência da conta
	 * @throws ErroCadastroException
	 *             - Quando a reincidência é menor ou igual a 0
	 */
	void reincide(Integer reincidencia) throws ErroCadastroException;

	/**
	 * 
	 * Retorna valor significativo(caso saida número negativo) da conta
	 * 
	 * @return Double significativo da conta
	 */
	Double contabilizaValor();

	Integer getReincidencia();

	Subgrupo getSubGrupo();

	Boolean isEfetiva();

	Calendar getDataEfetivacao();

	Double getValor();

	Calendar getDataCadastro();

	String getDescricao();

	Long getId();

}