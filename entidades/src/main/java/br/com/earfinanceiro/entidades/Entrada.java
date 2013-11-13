/**
 * 
 */
package br.com.earfinanceiro.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Richard
 * 
 */
@Entity
@DiscriminatorValue("entrada")
@XmlRootElement(name = "entrada")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Entrada extends AbstractConta implements IConta {

	/**
	 * 
	 */
	public Entrada() {
		this.parcelamento = 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.financemanager.dados.IConta#contabilizaValor()
	 */
	@Override
	@XmlElement(name = "valorReal")
	@Transient
	public Double getContabilizaValor() {
		return this.valor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Entrada)) {
			return false;
		}
		return super.equals(obj);
	}

}
