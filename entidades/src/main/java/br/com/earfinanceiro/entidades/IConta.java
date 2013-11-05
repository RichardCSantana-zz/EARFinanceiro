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

	void efetiva(Calendar dataEfetivacao) throws ErroCadastroException;

	void reincide(Integer reincidencia) throws ErroCadastroException;

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