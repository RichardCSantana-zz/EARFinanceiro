package br.com.earfinanceiro.negocio.balanco;

import java.util.Calendar;

public interface IBalancoBuilder {

	public Balanco geraBalanco(Calendar dataInicial, Calendar dataFinal);

}