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

import br.com.earfinanceiro.cadastro.ISaidaNegocio;
import br.com.earfinanceiro.entidades.Saida;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
@Named
@SessionScoped
public class SaidaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7085497147468865061L;

	@EJB
	private ISaidaNegocio negocio;

	private Saida saida;

	/**
	 * Prepara o controller para uma nova ação
	 */
	@PostConstruct
	public void init() {
		if (this.saida == null) {
			this.saida = new Saida();
		}
	}

	/**
	 * Encaminha para a tela de saídas
	 * 
	 * @return String de mapeamento da página de saídas
	 */
	public String criarSaida() {
		this.init();
		return "saidas";
	}

	/**
	 * 
	 * Persiste a saída atual
	 * 
	 */
	public void salvar() {
		this.negocio.salva(this.saida);
		this.saida = null;
		this.init();
	}

	/**
	 * 
	 * Exclui a saída atual
	 * 
	 */
	public void excluir() {
		this.negocio.excluir(this.saida);
	}

	/**
	 * 
	 * Encaminha para a tela de edição
	 * 
	 * @return String de mapeamento da página de saídas
	 */
	public String editar() {
		return "saidas";
	}

	/**
	 * 
	 * Retorna a saida atual
	 * 
	 * @return {@link Saida} que representa a saida
	 */
	public Saida getSaida() {
		return this.saida;
	}

	/**
	 * 
	 * Preenche a saida
	 * 
	 * @param saida
	 *            - {@link Saida} que representa a saida
	 */
	public void setSaida(Saida saida) {
		this.saida = saida;
	}

	/**
	 * 
	 * Retorna subgrupos para aquela saída
	 * 
	 * @return {@link List} de {@link Subgrupo} para a saida
	 * 
	 */
	public List<SelectItem> getSubgrupos() {
		List<SelectItem> itens = new ArrayList<>();
		for (Subgrupo subgrupo : this.negocio.getSubgrupos()) {
			SelectItem item = new SelectItem(subgrupo, subgrupo.getDescricao());
			itens.add(item);
		}
		return itens;
	}

}
