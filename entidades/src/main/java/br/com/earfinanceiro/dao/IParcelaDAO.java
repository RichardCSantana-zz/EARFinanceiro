package br.com.earfinanceiro.dao;

import java.util.Calendar;
import java.util.List;

import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.entidades.Parcela;

public interface IParcelaDAO extends IAbstractContaDAO<Parcela> {

	List<Parcela> geraListaPorDataEfetivacao(
			Calendar dataInicial, Calendar dataFinal);

	List<Parcela> geraListaPorDataEfetivacaoEConta(Calendar dataInicial,
			Calendar dataFinal, IConta conta);

}
