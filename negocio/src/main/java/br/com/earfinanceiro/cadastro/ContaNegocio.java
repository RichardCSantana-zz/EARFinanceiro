/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.dao.IParcelaDAO;
import br.com.earfinanceiro.entidades.Parcela;

/**
 * @author richard.santana
 * 
 */
@Stateless
@Local
public class ContaNegocio implements IContaNegocio {

	@EJB
	private IParcelaDAO daoParcelas;

	public List<Parcela> getParcelasNaoEfetivas() {
		return daoParcelas.getNaoEfetivas();
	}

	public void efetiva(List<Parcela> parcelas, Calendar dataEfetivacao) {
		for (Parcela parcela : parcelas) {
			parcela.setDataEfetivacao(dataEfetivacao);
			daoParcelas.atualizar(parcela);
		}
	}

}
