/**
 * 
 */
package br.com.earfinanceiro.controllers.converter;

import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.earfinanceiro.entidades.TipoEnum;

/**
 * @author richard.santana
 * 
 */
@FacesConverter(forClass = TipoEnum.class)
@SessionScoped
public class TipoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return TipoEnum.valueOf(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		TipoEnum tipo = (TipoEnum) arg2;
		return tipo.toString();
	}

}
