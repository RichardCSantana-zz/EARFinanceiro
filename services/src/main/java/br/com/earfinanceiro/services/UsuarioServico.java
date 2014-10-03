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

import br.com.earfinanceiro.cadastro.IUsuarioNegocio;
import br.com.earfinanceiro.entidades.Usuario;

/**
 * @author richard
 *
 */
@Stateless
@LocalBean
@Path("/usuarios")
public class UsuarioServico {

	@EJB
	private IUsuarioNegocio negocio;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void salvar(Usuario usuario) {
		this.negocio.salva(usuario);
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Usuario retornaUsuario(@PathParam("id") long id) {
		return this.negocio.retorna(id);
	}

	@DELETE
	@Path("{id}")
	public void excluiUsuario(@PathParam("id") Long id) {
		this.negocio.exclui(id);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Usuario> getUsuarios() {
		return this.negocio.lista();
	}

}
