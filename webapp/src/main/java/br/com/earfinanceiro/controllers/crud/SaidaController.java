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

import br.com.earfinanceiro.cadastro.ISaidaNegocio;
import br.com.earfinanceiro.entidades.Saida;
import br.com.earfinanceiro.entidades.Subgrupo;
import java.io.Serializable;

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

	@PostConstruct
	public void init() {
		if (saida == null) {
			saida = new Saida();
			saida.setDataPrevisao(Calendar.getInstance());
		}
	}

	public String criarSaida() {
		init();
		return "saidas";
	}

	public void salvar() {
		if (saida.getId() == null) {
			negocio.salva(saida);
		} else {
			negocio.atualiza(saida);
		}
		saida = null;
		init();
	}

	public void excluir() {
		negocio.excluir(saida);
	}

	public String editar() {
		return "saidas";
	}

	public Saida getSaida() {
		return saida;
	}

	public void setSaida(Saida saida) {
		this.saida = saida;
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
