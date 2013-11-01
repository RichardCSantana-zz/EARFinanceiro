package br.com.earfinanceiro.negocio.balanco;

import java.util.List;

import br.com.earfinanceiro.entidades.IConta;

public interface IBalancoBuilder {

	public Balanco geraBalanco(List<IConta> contas);

}