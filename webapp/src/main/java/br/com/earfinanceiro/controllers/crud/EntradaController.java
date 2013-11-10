/**
 * 
 */
package br.com.earfinanceiro.controllers.crud;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.earfinanceiro.cadastro.IEntradaNegocio;
import br.com.earfinanceiro.entidades.Entrada;
import br.com.earfinanceiro.entidades.Subgrupo;

import java.io.Serializable;

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

	@PostConstruct
	public void init() {
		if (entrada == null) {
			entrada = new Entrada();
			entrada.setDataPrevisao(Calendar.getInstance());
		}
	}

	public String criarEntrada() {
		init();
		return "entradas";
	}

	public void salvar() {
		if (entrada.getId() == null) {
			negocio.salva(entrada);
		} else {
			negocio.atualiza(entrada);
		}
		entrada = null;
		init();
	}

	public void excluir() {
		negocio.excluir(entrada);
	}

	public String editar() {
		return "entradas";
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public List<SelectItem> getSubgrupos() {
		List<SelectItem> itens = new ArrayList<>();
		for (Subgrupo subgrupo : negocio.getSubgrupos()) {
			SelectItem item = new SelectItem(subgrupo, subgrupo.getDescricao());
			itens.add(item);
		}
		return itens;
	}

}
