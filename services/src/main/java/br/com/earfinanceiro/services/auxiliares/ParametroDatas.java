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
public class ParametroDatas {

	private Calendar dataInicial;
	private Calendar dataFinal;

	/**
	 * @return the dataInicial
	 */
	@XmlElement(name = "dataInicial")
	public Calendar getDataInicial() {
		return dataInicial;
	}

	/**
	 * @param dataInicial
	 *            the dataInicial to set
	 */
	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * @return the dataFinal
	 */
	@XmlElement(name = "dataFinal")
	public Calendar getDataFinal() {
		return dataFinal;
	}

	/**
	 * @param dataFinal
	 *            the dataFinal to set
	 */
	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

}
