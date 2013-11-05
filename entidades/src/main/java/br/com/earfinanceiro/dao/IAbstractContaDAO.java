package br.com.earfinanceiro.dao;

import java.util.Calendar;
import java.util.List;

import br.com.earfinanceiro.entidades.AbstractConta;

public interface IAbstractContaDAO<T extends AbstractConta> extends IDAO<T> {

	public abstract List<T> geraListaPorDataEfetivacao(Calendar inicio,
			Calendar fim);

}