/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.earfinanceiro.cripto.ICripto;
import br.com.earfinanceiro.dao.IUsuarioDAO;
import br.com.earfinanceiro.entidades.Usuario;

/**
 * @author richard
 *
 */
@Stateless
@Local
public class UsuarioNegocio implements IUsuarioNegocio {

	@EJB
	private IUsuarioDAO dao;

	@EJB
	private ICripto cripto;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IUsuarioNegocio#salva(br.com.earfinanceiro
	 * .entidades.Usuario)
	 */
	@Override
	public void salva(Usuario usuario) {
		if (usuario.getId() == null) {
			String senhaCriptografada = cripto.criptografa(usuario.getSenha());
			usuario.setSenha(senhaCriptografada);
			this.dao.salvar(usuario);
		} else {
			this.dao.atualizar(usuario);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IUsuarioNegocio#retorna(java.lang.Long)
	 */
	@Override
	public Usuario retorna(Long id) {
		return this.dao.procurar(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IUsuarioNegocio#exclui(br.com.earfinanceiro
	 * .entidades.Usuario)
	 */
	@Override
	public void exclui(Usuario usuario) {
		this.dao.excluir(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cadastro.IUsuarioNegocio#lista()
	 */
	@Override
	public List<Usuario> lista() {
		return this.dao.listaTodos();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.cadastro.IUsuarioNegocio#verifyUser(java.lang.String
	 * , java.lang.String)
	 */
	@Override
	public Boolean verifyUser(String nome, String senha) {
		String senhaMd5 = cripto.criptografa(senha);
		return this.dao.verifyUser(nome, senhaMd5);
	}

	@Override
	public void exclui(Long id) {
		this.dao.excluir(id);
	}

}
