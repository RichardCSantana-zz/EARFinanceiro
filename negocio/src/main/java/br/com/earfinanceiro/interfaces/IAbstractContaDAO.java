package br.com.earfinanceiro.interfaces;

import java.util.Calendar;
import java.util.List;

import br.com.earfinanceiro.entidades.AbstractConta;

public interface IAbstractContaDAO<T extends AbstractConta> {

	public abstract List<T> geraListaPorDataEfetivacao(Calendar inicio,
			Calendar fim);

}