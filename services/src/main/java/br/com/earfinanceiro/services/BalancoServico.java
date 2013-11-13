/**
 * 
 */
package br.com.earfinanceiro.services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.earfinanceiro.negocio.balanco.Balanco;
import br.com.earfinanceiro.negocio.balanco.IBalancoBuilder;
import br.com.earfinanceiro.services.auxiliares.ParametrosBalanco;

/**
 * @author Richard
 * 
 */
@Stateless
@LocalBean
@Path("/balancos")
public class BalancoServico {

	@EJB
	private IBalancoBuilder negocio;

	/**
	 * 
	 * Retorna um balanco
	 * 
	 * @param parametrosBalanco
	 *            - classe com as informações necessárias a geração do balanço
	 * @return {@link Balanco} com as informações do período pedido
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Balanco getBalanco(ParametrosBalanco parametrosBalanco) {
		return this.negocio.geraBalanco(parametrosBalanco.getDataInicial(),
				parametrosBalanco.getDataFinal());
	}
}
