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

import br.com.earfinanceiro.cadastro.ISubgrupoNegocio;
import br.com.earfinanceiro.entidades.Grupo;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
@Named
@SessionScoped
public class SubgrupoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8759654720750546127L;

	@EJB
	private ISubgrupoNegocio negocio;

	private Subgrupo subgrupo;

	@PostConstruct
	public void init() {
		if (subgrupo == null) {
			subgrupo = new Subgrupo();
		}
	}

	public String criarSubgrupo() {
		init();
		return "subgrupos";
	}

	public void salvarSubgrupo() {
		if (subgrupo.getId() == null) {
			negocio.salvaSubgrupo(subgrupo);
		} else {
			negocio.atualizaSubgrupo(subgrupo);
		}
		subgrupo = null;
		init();
	}

	public void excluiSubgrupo() {
		negocio.excluirsubSubgrupo(subgrupo);
	}

	public String editarSubgrupo() {
		return "subgrupos";
	}

	public Subgrupo getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(Subgrupo subgrupo) {
		this.subgrupo = subgrupo;
	}

	public List<Subgrupo> getSubgrupos() {
		return negocio.listarSubgrupos();
	}

	public List<SelectItem> getGrupos() {
		List<SelectItem> itens = new ArrayList<>();
		for (Grupo grupo : negocio.getGrupos()) {
			SelectItem item = new SelectItem(grupo, grupo.getDescricao());
			itens.add(item);
		}
		return itens;
	}
}
