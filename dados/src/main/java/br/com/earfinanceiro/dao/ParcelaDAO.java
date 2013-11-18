/**
 * 
 */
package br.com.earfinanceiro.dao;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.criteria.Predicate;

import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.entidades.Parcela;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class ParcelaDAO extends ContaAbstractDAO<Parcela> implements
		IParcelaDAO {

	public ParcelaDAO() {
		super(Parcela.class);
	}

	@Override
	public List<Parcela> geraListaPorDataEfetivacaoEConta(Calendar dataInicial,
			Calendar dataFinal, IConta conta) {
		this.gcd = new GeradorCriteriaData<>(this.cb, this.root);
		Predicate pData = this.gcd.geraCriteria(dataInicial, dataFinal);
		Predicate pConta = this.cb.equal(this.root.get("conta")
				.as(IConta.class), conta);
		Predicate pAnd = this.cb.and(pData, pConta);
		return this.listaCondicoes(pAnd);
	}

}
