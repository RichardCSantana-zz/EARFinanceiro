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

	/**
	 * Prepara o controller para uma nova ação
	 */
	@PostConstruct
	public void init() {
		if (this.grupo == null) {
			this.grupo = new Grupo();
		}
	}

	/**
	 * Encaminha para a tela de grupos
	 * 
	 * @return String de mapeamento da página de grupos
	 */
	public String criarGrupo() {
		this.init();
		return "grupos";
	}

	/**
	 * 
	 * Persiste o grupo atual
	 * 
	 */
	public void salvarGrupo() {
		this.grupoNegocio.salvaGrupo(this.grupo);
		this.grupo = null;
		this.init();
	}

	/**
	 * 
	 * Exclui o grupo atual
	 * 
	 */
	public void excluiGrupo() {
		this.grupoNegocio.excluirGrupo(this.grupo);
	}

	/**
	 * 
	 * Encaminha para a tela de edição
	 * 
	 * @return String de mapeamento da página de grupos
	 */
	public String editarGrupo() {
		return "grupos";
	}

	/**
	 * Retorna o grupo
	 * 
	 * @return {@link Grupo} que representa o grupo
	 */
	public Grupo getGrupo() {
		return this.grupo;
	}

	/**
	 * 
	 * Preenche o grupo
	 * 
	 * @param grupo
	 *            - {@link Grupo} que representa o grupo
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	/**
	 * 
	 * Retorna grupos disponíveis
	 * 
	 * @return {@link List} de {@link Grupo} para o subgrupo
	 */
	public List<Grupo> getGrupos() {
		return this.grupoNegocio.listarGrupos();
	}

	/**
	 * 
	 * Retorna tipos disponíveis para aquele grupo
	 * 
	 * @return {@link List} de {@link TipoEnum}
	 */
	public List<SelectItem> getTipos() {
		List<SelectItem> itens = new ArrayList<>();
		for (TipoEnum tipo : TipoEnum.values()) {
			SelectItem item = new SelectItem(tipo, tipo.toString());
			itens.add(item);
		}
		return itens;
	}

}
