/**
 * 
 */
package br.com.earfinanceiro.entidades;

import java.util.Calendar;
import java.util.List;

/**
 * @author Richard
 * 
 */
public interface IConta {

	/**
	 * 
	 * Retorna valor significativo(caso saida número negativo) da conta
	 * 
	 * @return Double significativo da conta
	 */
	Double getContabilizaValor();

	/**
	 * 
	 * Retorn o subgrupo ao qual a conta pertence
	 * 
	 * @return {@link Subgrupo} a qual a conta pertence
	 */
	Subgrupo getSubgrupo();

	/**
	 * 
	 * Retorn true se a conta estiver efetiva
	 * 
	 * @return boolean que indica se a conta está efetiva
	 */
	Boolean isEfetiva();

	/**
	 * 
	 * Retorna data em que a conta foi efetiva(paga)
	 * 
	 * @return {@link Calendar} que indica a data em que a conta foi efetiva
	 */
	Calendar getDataEfetivacao();

	/**
	 * 
	 * Retorna valor da conta
	 * 
	 * @return Double que representa o valor da conta
	 */
	Double getValor();

	/**
	 * 
	 * Retorna a data de previsão de pagamento para a conta
	 * 
	 * @return {@link Calendar} que indica a data de previsão de pagamento da
	 *         conta
	 */
	Calendar getDataVencimento();

	/**
	 * 
	 * Retorna descrição da conta
	 * 
	 * @return String que define a descrição da conta
	 */
	String getDescricao();

	/**
	 * 
	 * Retorna o identificador da conta
	 * 
	 * @return Long que define o identificador da conta
	 */
	Long getId();

	/**
	 * 
	 * Preenche a data de Efetivação da conta
	 * 
	 * @param dataEfetivacao
	 *            Calendar que define a data de efetivação da conta
	 */
	void setDataEfetivacao(Calendar dataEfetivacao);

	/**
	 * Retorna se o tipo é saída
	 * 
	 * @return true se o tipo de objeto for saída
	 */
	boolean isSaida();

	/**
	 * @param parcelas
	 *            the parcelas to set
	 */
	public void setParcelas(List<Parcela> parcelas);

	List<Parcela> getParcelas();

}