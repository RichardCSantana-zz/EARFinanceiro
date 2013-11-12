package br.com.earfinanceiro.controllers.crud;

import java.io.Serializable;
import java.util.ArrayList;
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
	private List<IConta> contas;
	private List<IConta> selecionadas;
	private Calendar dataEfetivacao;

	/**
	 * 
	 */
	public ContaController() {
		this.dataEfetivacao = Calendar.getInstance();
		this.selecionadas = new ArrayList<>();
		this.contas = new ArrayList<>();
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
		this.contas = this.negocio.getContasNaoEfetivas();
		for (IConta contaAtual : this.selecionadas) {
			this.contas.remove(contaAtual);
		}
		return this.contas;
	}

	/**
	 * 
	 * Adiciona conta à lista de selecionados
	 * 
	 */
	public void adicionaConta() {
		this.contas.remove(this.conta);
		this.selecionadas.add(this.conta);
		this.conta = null;
	}

	/**
	 * 
	 * Remove conta da lista de selecionados
	 * 
	 */
	public void removeConta() {
		this.selecionadas.remove(this.conta);
		this.contas.add(this.conta);
		this.conta = null;
	}

	/**
	 * 
	 * Efetiva a conta atual
	 * 
	 */
	public void efetiva() {
		try {
			this.negocio.efetiva(selecionadas, this.dataEfetivacao);
		} catch (ErroCadastroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.selecionadas = new ArrayList<>();
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

	/**
	 * 
	 * Retorna lista das contas selecionadas
	 * 
	 * @return {@link List} de {@link IConta} selecionadas
	 */
	public List<IConta> getSelecionadas() {
		return this.selecionadas;
	}

	/**
	 * 
	 * Preenche as contas selecionadas
	 * 
	 * @param selecionadas
	 *            - {@link List} de {@link IConta} selecionadas
	 */
	public void setSelecionadas(List<IConta> selecionadas) {
		this.selecionadas = selecionadas;
	}

}
