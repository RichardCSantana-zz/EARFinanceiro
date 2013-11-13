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

import br.com.earfinanceiro.cadastro.IEntradaNegocio;
import br.com.earfinanceiro.entidades.Entrada;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
@Named
@SessionScoped
public class EntradaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 370435909252937717L;

	@EJB
	private IEntradaNegocio negocio;

	private Entrada entrada;

	/**
	 * Prepara o controller para uma nova ação
	 */
	@PostConstruct
	public void init() {
		if (this.entrada == null) {
			this.entrada = new Entrada();
		}
	}

	/**
	 * Encaminha para a tela de entrada
	 * 
	 * @return String de mapeamento da página de entradas
	 */
	public String criarEntrada() {
		this.init();
		return "entradas";
	}

	/**
	 * 
	 * Persiste a entrada atual
	 * 
	 */
	public void salvar() {
		this.negocio.salva(this.entrada);
		this.entrada = null;
		this.init();
	}

	/**
	 * 
	 * Exclui a entrada atual
	 * 
	 */
	public void excluir() {
		this.negocio.excluir(this.entrada);
	}

	/**
	 * 
	 * Encaminha para a tela de edição
	 * 
	 * @return String de mapeamento da página de entradas
	 */
	public String editar() {
		return "entradas";
	}

	/**
	 * 
	 * Retorna entrada atual
	 * 
	 * @return {@link Entrada} que representa a entrada
	 */
	public Entrada getEntrada() {
		return this.entrada;
	}

	/**
	 * 
	 * Preenche a entrada
	 * 
	 * @param entrada
	 *            - {@link Entrada} que representa a entrada
	 */
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	/**
	 * 
	 * Retorna subgrupos para aquela entrada
	 * 
	 * @return {@link List} de {@link Subgrupo} para a entrada
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
