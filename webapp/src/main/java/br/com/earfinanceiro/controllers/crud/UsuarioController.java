/**
 * 
 */
package br.com.earfinanceiro.controllers.crud;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.earfinanceiro.cadastro.IUsuarioNegocio;
import br.com.earfinanceiro.entidades.Usuario;

/**
 * @author richard
 *
 */
@Named
@SessionScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8155716435246782816L;

	@EJB
	private IUsuarioNegocio negocio;

	private Usuario usuario;

	@PostConstruct
	public void init() {
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
	}

	public String criarUsuarios() {
		this.init();
		return "usuarios";
	}

	public String salvarUsuario() {
		this.negocio.salva(this.usuario);
		this.usuario = null;
		this.init();
		return "usuarios";
	}

	public String excluiUsuario() {
		this.negocio.exclui(this.usuario);
		return "usuarios";
	}

	public String editarUsuario() {
		return "usuarios";
	}

	public List<Usuario> getUsuarios() {
		return this.negocio.lista();
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
