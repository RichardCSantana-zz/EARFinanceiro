/**
 * 
 */
package br.com.earfinanceiro.controllers.crud;

import java.io.Serializable;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.earfinanceiro.negocio.balanco.Balanco;
import br.com.earfinanceiro.negocio.balanco.IBalancoBuilder;

/**
 * @author richard.santana
 * 
 */
@Named
@SessionScoped
public class BalancoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6987027439171169389L;

	private Calendar dataInicial;
	private Calendar dataFinal;
	private Balanco balanco;

	/**
	 * 
	 */
	protected BalancoController() {
		dataInicial = Calendar.getInstance();
		dataFinal = Calendar.getInstance();
	}

	@EJB
	private IBalancoBuilder builder;

	public String iniciaBalanco() {
		return "balancos";
	}

	public void geraBalanco() {
		balanco = builder.geraBalanco(dataInicial, dataFinal);
	}

	public Calendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Calendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Balanco getBalanco() {
		return balanco;
	}

	public void setBalanco(Balanco balanco) {
		this.balanco = balanco;
	}

}
