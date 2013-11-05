/**
 * 
 */
package br.com.earfinanceiro.controllers.crud;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.earfinanceiro.cadastro.IGrupoNegocio;
import br.com.earfinanceiro.entidades.Grupo;

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
	private List<Grupo> grupos;

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
	}

	public void excluiGrupo() {
		grupoNegocio.excluirGrupo(grupo);
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

}
