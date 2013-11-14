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
		this.dataInicial = Calendar.getInstance();
		this.dataFinal = Calendar.getInstance();
	}

	@EJB
	private IBalancoBuilder builder;

	/**
	 * 
	 * Encaminha para a tela de balanço
	 * 
	 * @return String de mapeamento da página de balanço
	 */
	public String iniciaBalanco() {
		return "balancos";
	}

	/**
	 * Gera o balanço
	 */
	public void geraBalanco() {
		this.balanco = this.builder.geraBalanco(this.dataInicial,
				this.dataFinal);
	}

	/**
	 * 
	 * Retorna se a lista possui itens
	 * 
	 * @return boolean que determina se a lista possui itens
	 */
	public boolean isListaPreenchida() {
		return (this.balanco != null && !this.balanco.getContas().isEmpty());
	}

	/**
	 * 
	 * Retorna o valor do atributo data inicial
	 * 
	 * @return Calendar que representa a data inicial
	 */
	public Calendar getDataInicial() {
		return this.dataInicial;
	}

	/**
	 * 
	 * Preenche o atributo data inicial
	 * 
	 * @param dataInicial
	 *            - Calendar que representa a data inicial
	 */
	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * 
	 * Retorna o valor do atributo data final
	 * 
	 * @return Calendar que representa a data final
	 */
	public Calendar getDataFinal() {
		return this.dataFinal;
	}

	/**
	 * 
	 * Preenche o atributo data final
	 * 
	 * @param dataFinal
	 *            - Calendar que representa a data final
	 */
	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	/**
	 * 
	 * Retorna o valor do atributo data final
	 * 
	 * @return Calendar que representa a data final
	 */
	public Balanco getBalanco() {
		return this.balanco;
	}

	/**
	 * 
	 * Preenche o atributo data inicial
	 * 
	 * @param balanco
	 *            - {@link Balanco} que representa o balanco
	 */
	public void setBalanco(Balanco balanco) {
		this.balanco = balanco;
	}

}
