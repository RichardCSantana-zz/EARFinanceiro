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

import br.com.earfinanceiro.cadastro.IGrupoNegocio;
import br.com.earfinanceiro.entidades.Grupo;

/**
 * @author richard.santana
 * 
 */
@Stateless
@LocalBean
@Path("/grupos")
public class GrupoServico {

	@EJB
	private IGrupoNegocio grupoNegocio;

	/**
	 * 
	 * Salva um grupo
	 * 
	 * @param grupo
	 *            - {@link Grupo} grupo a ser persistido
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void salvarGrupo(Grupo grupo) {
		this.grupoNegocio.salvaGrupo(grupo);
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
		this.grupoNegocio.excluirGrupo(id);
	}

	/**
	 * 
	 * Método que lista os grupos
	 * 
	 * @return {@link List} de {@link Grupo}
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Grupo> getGrupos() {
		return this.grupoNegocio.listarGrupos();
	}

}
