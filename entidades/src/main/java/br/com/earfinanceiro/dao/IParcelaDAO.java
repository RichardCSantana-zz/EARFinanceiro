package br.com.earfinanceiro.dao;

import java.util.Calendar;
import java.util.List;

import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.entidades.Parcela;

/**
 * @author Richard
 * 
 */
public interface IParcelaDAO extends IAbstractContaDAO<Parcela> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.dao.IAbstractContaDAO#geraListaPorDataEfetivacao
	 * (java.util.Calendar, java.util.Calendar)
	 */
	@Override
	List<Parcela> geraListaPorDataEfetivacao(Calendar dataInicial,
			Calendar dataFinal);

	/**
	 * @param dataInicial
	 *            - data inicial a procurar a parcela
	 * @param dataFinal
	 *            - data Final a procurar a parcela
	 * @param conta
	 *            - conta que possui as parcelas
	 * @return {@link List} de {@link Parcela}
	 */
	List<Parcela> geraListaPorDataEfetivacaoEConta(Calendar dataInicial,
			Calendar dataFinal, IConta conta);

}
