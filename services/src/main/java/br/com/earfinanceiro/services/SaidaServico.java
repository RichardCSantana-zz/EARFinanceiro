/**
 * 
 */
package br.com.earfinanceiro.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.earfinanceiro.cadastro.ISaidaNegocio;
import br.com.earfinanceiro.entidades.Saida;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
@Stateless
@LocalBean
@Path("/saidas")
public class SaidaServico {

	@EJB
	private ISaidaNegocio negocio;

	/**
	 * 
	 * Salva uma saida
	 * 
	 * @param saida
	 *            - {@link Saida} grupo a ser persistido
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void salvar(Saida saida) {
		this.negocio.salva(saida);
	}

	/**
	 * 
	 * Retorna uma saida
	 * 
	 * @param id
	 *            - Long que representa a saida a ser retornada
	 * @return {@link Saida} referente ao id
	 */
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Saida retorna(@PathParam("id") Long id) {
		return this.negocio.retorna(id);
	}

	/**
	 * 
	 * Exclui uma saida
	 * 
	 * @param id
	 *            - Long que representa a saida a ser excluída
	 */
	@DELETE
	@Path("{id}")
	public void exclui(@PathParam("id") Long id) {
		this.negocio.exclui(id);
	}

	/**
	 * 
	 * Método que lista os subgrupos
	 * 
	 * @return {@link List} de {@link Subgrupo}
	 */
	@GET
	@Path("/subgrupos")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Subgrupo> getSubgrupos() {
		return this.negocio.getSubgrupos();
	}

}
