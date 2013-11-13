/**
 * 
 */
package br.com.earfinanceiro.services.auxiliares;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author richard.santana
 * 
 */
@XmlRootElement(name = "datas")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ParametrosBalanco {

	private Calendar dataInicial;
	private Calendar dataFinal;

	/**
	 * 
	 * Retorna a data inicial
	 * 
	 * @return Calendar que representa a data inicial
	 */
	@XmlElement(name = "dataInicial")
	public Calendar getDataInicial() {
		return this.dataInicial;
	}

	/**
	 * 
	 * Preenche a data inicial
	 * 
	 * @param dataInicial
	 *            - Calendar que representa a data inicial
	 * 
	 */
	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * 
	 * Retorna a data final
	 * 
	 * @return Calendar que representa a data final
	 */
	@XmlElement(name = "dataFinal")
	public Calendar getDataFinal() {
		return this.dataFinal;
	}

	/**
	 * 
	 * Preenche a data final
	 * 
	 * @param dataFinal
	 *            - Calendar que representa a data final
	 * 
	 */
	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

}
