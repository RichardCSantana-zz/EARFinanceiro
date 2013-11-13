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

import br.com.earfinanceiro.cadastro.ISubgrupoNegocio;
import br.com.earfinanceiro.entidades.Grupo;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
@Stateless
@LocalBean
@Path("/subgrupos")
public class SubgrupoServico {

	@EJB
	private ISubgrupoNegocio negocio;

	/**
	 * 
	 * Salva um grupo
	 * 
	 * @param subgrupo
	 *            - {@link Grupo} grupo a ser persistido
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void salvarGrupo(Subgrupo subgrupo) {
		this.negocio.salva(subgrupo);
	}

	/**
	 * 
	 * Retorna um grupo
	 * 
	 * @param id
	 *            - Long que representa o grupo a ser retornado
	 * @return {@link Subgrupo} referente ao id
	 */
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Subgrupo retornaGrupo(@PathParam("id") Long id) {
		return this.negocio.retorna(id);
	}

	/**
	 * 
	 * Exclui um grupo
	 * 
	 * @param id
	 *            - Long que representa o grupo a ser excluído
	 */
	@DELETE
	@Path("{id}")
	public void excluiGrupo(@PathParam("id") Long id) {
		this.negocio.exclui(id);
	}

	/**
	 * 
	 * Método que lista os subgrupos
	 * 
	 * @return {@link List} de {@link Subgrupo}
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Subgrupo> getSubgrupos() {
		return this.negocio.lista();
	}

	/**
	 * 
	 * Método que lista os grupos
	 * 
	 * @return {@link List} de {@link Grupo}
	 */
	@GET
	@Path("/grupos")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Grupo> getGrupos() {
		return this.negocio.getGrupos();
	}

}
