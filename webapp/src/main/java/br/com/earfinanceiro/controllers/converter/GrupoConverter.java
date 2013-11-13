/**
 * 
 */
package br.com.earfinanceiro.controllers.converter;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.earfinanceiro.dao.IGrupoDAO;
import br.com.earfinanceiro.entidades.Grupo;

/**
 * @author Richard
 * 
 */
@FacesConverter(forClass = Grupo.class)
@SessionScoped
public class GrupoConverter implements Serializable, Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6931263817484446884L;

	private IGrupoDAO dao;

	/**
	 * 
	 */
	public GrupoConverter() {
		try {
			this.dao = InitialContext
					.doLookup("java:global/ear-1.0/dados-1.0/GrupoDAO!br.com.earfinanceiro.dao.IGrupoDAO");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return this.dao.procurar(new Long(arg2));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Grupo grupo = (Grupo) arg2;
		return grupo.getId().toString();
	}

}
