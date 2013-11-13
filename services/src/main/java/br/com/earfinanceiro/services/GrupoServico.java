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
import br.com.earfinanceiro.entidades.TipoEnum;

/**
 * @author richard.santana
 * 
 */
@Stateless
@LocalBean
@Path("/grupos")
public class GrupoServico {

	@EJB
	private IGrupoNegocio negocio;

	/**
	 * 
	 * Salva um grupo
	 * 
	 * @param grupo
	 *            - {@link Grupo} grupo a ser persistido
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void salvar(Grupo grupo) {
		this.negocio.salva(grupo);
	}

	/**
	 * 
	 * Retorna um grupo
	 * 
	 * @param id
	 *            - Long que representa o grupo a ser retornado
	 * @return {@link Grupo} referente ao id
	 */
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Grupo retornaGrupo(@PathParam("id") long id) {
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
	 * Método que lista os grupos
	 * 
	 * @return {@link List} de {@link Grupo}
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Grupo> getGrupos() {
		return this.negocio.lista();
	}

	/**
	 * 
	 * Método que lista os tipos
	 * 
	 * @return {@link List} de {@link Grupo}
	 */
	@GET
	@Path("/tipos")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<TipoEnum> listaTipos() {
		return this.negocio.listaTipos();
	}
}
