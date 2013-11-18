package br.com.earfinanceiro.controllers.crud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.earfinanceiro.cadastro.IContaNegocio;
import br.com.earfinanceiro.entidades.Parcela;

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

	private Parcela parcela;
	private List<Parcela> parcelas;
	private List<Parcela> selecionadas;
	private Calendar dataEfetivacao;

	/**
	 * 
	 */
	public ContaController() {
		this.dataEfetivacao = Calendar.getInstance();
		this.selecionadas = new ArrayList<>();
		this.parcelas = new ArrayList<>();
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
	 * @return {@link List} de {@link Parcela}
	 */
	public List<Parcela> getParcelas() {
		this.parcelas = this.negocio.getParcelasNaoEfetivas();
		for (Parcela parcelaAtual : this.selecionadas) {
			this.parcelas.remove(parcelaAtual);
		}
		return this.parcelas;
	}

	/**
	 * 
	 * Adiciona conta à lista de selecionados
	 * 
	 */
	public void adiciona() {
		this.parcelas.remove(this.parcela);
		this.selecionadas.add(this.parcela);
		this.parcela = null;
	}

	/**
	 * 
	 * Remove conta da lista de selecionados
	 * 
	 */
	public void remove() {
		this.selecionadas.remove(this.parcela);
		this.parcelas.add(this.parcela);
		this.parcela = null;
	}

	/**
	 * 
	 * Efetiva a conta atual
	 * 
	 */
	public void efetiva() {
		try {
			this.negocio.efetiva(this.selecionadas, this.dataEfetivacao);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		this.selecionadas = new ArrayList<>();
	}

	/**
	 * @return the parcela
	 */
	public Parcela getParcela() {
		return parcela;
	}

	/**
	 * @param parcela
	 *            the parcela to set
	 */
	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
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
	 * @return {@link List} de {@link Parcela} selecionadas
	 */
	public List<Parcela> getSelecionadas() {
		return this.selecionadas;
	}

	/**
	 * 
	 * Preenche as contas selecionadas
	 * 
	 * @param selecionadas
	 *            - {@link List} de {@link Parcela} selecionadas
	 */
	public void setSelecionadas(List<Parcela> selecionadas) {
		this.selecionadas = selecionadas;
	}

}
