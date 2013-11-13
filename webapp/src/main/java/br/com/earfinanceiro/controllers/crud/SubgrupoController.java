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

	/**
	 * Prepara o controller para uma nova ação
	 */
	@PostConstruct
	public void init() {
		if (this.subgrupo == null) {
			this.subgrupo = new Subgrupo();
		}
	}

	/**
	 * Encaminha para a tela de subgrupo
	 * 
	 * @return String de mapeamento da página de subgrupos
	 */
	public String criarSubgrupo() {
		this.init();
		return "subgrupos";
	}

	/**
	 * 
	 * Persiste a o subgrupo atual
	 * 
	 */
	public void salvarSubgrupo() {
		this.negocio.salva(this.subgrupo);
		this.subgrupo = null;
		this.init();
	}

	/**
	 * 
	 * Exclui o subgrupo atual
	 * 
	 */
	public void excluiSubgrupo() {
		this.negocio.exclui(this.subgrupo);
	}

	/**
	 * 
	 * Encaminha para a tela de edição
	 * 
	 * @return String de mapeamento da página de subgrupos
	 */
	public String editarSubgrupo() {
		return "subgrupos";
	}

	/**
	 * 
	 * Retorna subgrupo atual
	 * 
	 * @return {@link Subgrupo} que representa o subgrupo
	 */
	public Subgrupo getSubgrupo() {
		return this.subgrupo;
	}

	/**
	 * 
	 * Preenche o subgrupo
	 * 
	 * @param subgrupo
	 *            - {@link Subgrupo} que representa o subgrupo
	 */
	public void setSubgrupo(Subgrupo subgrupo) {
		this.subgrupo = subgrupo;
	}

	/**
	 * 
	 * Retorna subgrupos
	 * 
	 * @return {@link List} de {@link Subgrupo}
	 * 
	 */
	public List<Subgrupo> getSubgrupos() {
		return this.negocio.lista();
	}

	/**
	 * 
	 * Retorna grupos para aquele subgrupo
	 * 
	 * @return {@link List} de {@link Grupo} para o subgrupo
	 * 
	 */
	public List<SelectItem> getGrupos() {
		List<SelectItem> itens = new ArrayList<>();
		for (Grupo grupo : this.negocio.getGrupos()) {
			SelectItem item = new SelectItem(grupo, grupo.getDescricao());
			itens.add(item);
		}
		return itens;
	}
}
