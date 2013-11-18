/**
 * 
 */
package br.com.earfinanceiro.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.earfinanceiro.cadastro.IContaNegocio;
import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.entidades.Parcela;
import br.com.earfinanceiro.services.auxiliares.ParametrosBalanco;
import br.com.earfinanceiro.services.auxiliares.ParametrosConta;

/**
 * @author Richard
 * 
 */
@Stateless
@LocalBean
@Path("/contas")
public class ContaServico {

	@EJB
	private IContaNegocio negocio;

	/**
	 * 
	 * Retorna contas
	 * 
	 * @return {@link List} de {@link IConta}
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Parcela> getContas() {
		return this.negocio.getParcelasNaoEfetivas();
	}

	/**
	 * 
	 * Efetiva contas
	 * 
	 * @param parametrosConta
	 *            - {@link ParametrosBalanco}
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void efetivar(ParametrosConta parametrosConta) {
		try {
			this.negocio.efetiva(parametrosConta.getContas(),
					parametrosConta.getDataEfetivar());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
