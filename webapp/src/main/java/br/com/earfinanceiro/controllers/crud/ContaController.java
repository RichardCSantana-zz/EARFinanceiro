package br.com.earfinanceiro.controllers.crud;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.earfinanceiro.cadastro.IContaNegocio;
import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.exceptions.ErroCadastroException;

/**
 * @author Richard
 * 
 */
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

	/**
	 * 
	 */
	public ContaController() {
		this.dataEfetivacao = Calendar.getInstance();
	}

	/**
	 * 
	 * Encaminha para a tela de listagem de contas
	 * 
	 * @return String de mapeamento da página de listagem
	 */
	public String iniciaListagem() {
		return "listaContas";
	}

	/**
	 * 
	 * Retorna lista de contas
	 * 
	 * @return {@link List} de {@link IConta}
	 */
	public List<IConta> getContas() {
		return this.negocio.getContasNaoEfetivas();
	}

	/**
	 * @param conta
	 *            - {@link IConta} que deverá ser efetivada
	 */
	public void iniciaEfetivacao(IConta conta) {
		this.conta = conta;
	}

	/**
	 * 
	 * Efetiva a conta atual
	 * 
	 */
	public void efetiva() {
		try {
			this.negocio.efetiva(this.conta, this.dataEfetivacao);
			this.conta = null;
			this.dataEfetivacao = Calendar.getInstance();
		} catch (ErroCadastroException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Retorna o atributo conta
	 * 
	 * @return IConta que está no controller
	 */
	public IConta getConta() {
		return this.conta;
	}

	/**
	 * 
	 * Preenche o atributo conta
	 * 
	 * @param conta
	 *            - {@link IConta} que representa a conta
	 */
	public void setConta(IConta conta) {
		this.conta = conta;
	}

	/**
	 * 
	 * Preenche o atributo data de efetivação
	 * 
	 * @return {@link Calendar} que representa a data de efetivação
	 */
	public Calendar getDataEfetivacao() {
		return this.dataEfetivacao;
	}

	/**
	 * 
	 * Retorna o atributo data de efetivação
	 * 
	 * @param dataEfetivacao
	 *            - {@link Calendar} que representa a data de efetivação
	 */
	public void setDataEfetivacao(Calendar dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

}
