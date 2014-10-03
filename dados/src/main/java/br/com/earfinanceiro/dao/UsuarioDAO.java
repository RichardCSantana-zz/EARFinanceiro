/**
 * 
 */
package br.com.earfinanceiro.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.criteria.Predicate;

import br.com.earfinanceiro.entidades.Usuario;

/**
 * @author richard
 *
 */
@Stateless
@Local
public class UsuarioDAO extends AbstractDAO<Usuario> implements IUsuarioDAO {

	protected UsuarioDAO() {
		super(Usuario.class);
	}

	@Override
	public boolean verifyUser(String nome, String senha) {
		Predicate pred1 = this.cb.equal(this.root.get("nome"), nome);
		Predicate pred2 = this.cb.equal(this.root.get("senha"), nome);
		Predicate predAgregador = this.cb.and(pred1, pred2);
		Usuario usuario = this.unicoCondicoes(predAgregador);
		return (usuario != null);
	}

}
