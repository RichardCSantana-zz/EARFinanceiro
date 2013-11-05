package br.com.earfinanceiro.controllers.crud;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.richfaces.component.UIPopupPanel;

import br.com.earfinanceiro.cadastro.IContaNegocio;
import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.exceptions.ErroCadastroException;

@Named
@SessionScoped
public class ContaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8427441249616901663L;

	@EJB
	private IContaNegocio negocio;

	private IConta conta;
	private Calendar dataEfetivacao;

	private UIPopupPanel popup;

	/**
	 * 
	 */
	public ContaController() {
		dataEfetivacao = Calendar.getInstance();
	}

	public String iniciaListagem() {
		return "listaContas";
	}

	public List<IConta> getContas() {
		return negocio.getContasNaoEfetivas();
	}

	public void iniciaEfetivacao(IConta conta) {
		this.conta = conta;
		popup.setShow(true);
	}

	public void efetiva() {
		try {
			negocio.efetiva(conta, dataEfetivacao);
			conta = null;
			dataEfetivacao = Calendar.getInstance();
		} catch (ErroCadastroException e) {
			e.printStackTrace();
		}
	}

	public IConta getConta() {
		return conta;
	}

	public void setConta(IConta conta) {
		this.conta = conta;
	}

	public Calendar getDataEfetivacao() {
		return dataEfetivacao;
	}

	public void setDataEfetivacao(Calendar dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

	public UIPopupPanel getPopup() {
		return popup;
	}

	public void setPopup(UIPopupPanel popup) {
		this.popup = popup;
	}

}
