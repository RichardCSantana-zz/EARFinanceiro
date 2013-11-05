/**
 * 
 */
package br.com.earfinanceiro.controllers.crud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.earfinanceiro.cadastro.IGrupoNegocio;
import br.com.earfinanceiro.entidades.Grupo;
import br.com.earfinanceiro.entidades.TipoEnum;

/**
 * @author Richard
 * 
 */
@Named
@SessionScoped
public class GrupoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 68758873813372893L;

	@EJB
	private IGrupoNegocio grupoNegocio;

	private Grupo grupo;

	@PostConstruct
	public void init() {
		if (grupo == null) {
			grupo = new Grupo();
		}
	}

	public String criarGrupo() {
		init();
		return "grupos";
	}

	public void salvarGrupo() {
		if (grupo.getId() == null) {
			grupoNegocio.salvaGrupo(grupo);
		} else {
			grupoNegocio.atualizaGrupo(grupo);
		}
		grupo = null;
		init();
	}

	public void excluiGrupo() {
		grupoNegocio.excluirGrupo(grupo);
	}

	public String editarGrupo() {
		return "grupos";
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Grupo> getGrupos() {
		return grupoNegocio.listarGrupos();
	}

	public List<SelectItem> getTipos() {
		List<SelectItem> itens = new ArrayList<>();
		for (TipoEnum tipo : TipoEnum.values()) {
			SelectItem item = new SelectItem(tipo, tipo.toString());
			itens.add(item);
		}
		return itens;
	}

}
