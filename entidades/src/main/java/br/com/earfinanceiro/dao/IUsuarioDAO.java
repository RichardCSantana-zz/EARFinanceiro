/**
 * 
 */
package br.com.earfinanceiro.dao;

import br.com.earfinanceiro.entidades.Usuario;

/**
 * @author richard
 *
 */
public interface IUsuarioDAO extends IDAO<Usuario> {

	public boolean verifyUser(String nome, String senha);

}
