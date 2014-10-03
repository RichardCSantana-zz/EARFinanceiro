package br.com.earfinanceiro.cadastro;

import java.util.List;

import br.com.earfinanceiro.entidades.Usuario;

public interface IUsuarioNegocio {

	void salva(Usuario usuario);

	Usuario retorna(Long id);

	void exclui(Usuario usuario);

	void exclui(Long id);

	List<Usuario> lista();

	Boolean verifyUser(String nome, String senha);

}
