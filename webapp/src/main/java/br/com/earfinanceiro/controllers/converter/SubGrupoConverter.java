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

import br.com.earfinanceiro.dao.ISubgrupoDAO;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
@FacesConverter(forClass = Subgrupo.class)
@SessionScoped
public class SubGrupoConverter implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1096704565538783849L;

	private ISubgrupoDAO dao;

	/**
	 * 
	 */
	public SubGrupoConverter() {
		try {
			dao = InitialContext
					.doLookup("java:global/ear-1.0/dados-1.0/SubgrupoDAO!br.com.earfinanceiro.dao.ISubgrupoDAO");
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
		return dao.getPorId(new Long(arg2));
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
		Subgrupo subgrupo = (Subgrupo) arg2;
		return subgrupo.toString();
	}

}
