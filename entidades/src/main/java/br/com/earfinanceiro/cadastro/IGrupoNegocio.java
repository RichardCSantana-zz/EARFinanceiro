/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import br.com.earfinanceiro.entidades.Grupo;

/**
 * @author Richard
 * 
 */
public interface IGrupoNegocio {

	public abstract void salvaGrupo(Grupo grupo);

	public abstract void atualizaGrupo(Grupo grupo);

	public abstract void excluirGrupo(Grupo grupo);

	public abstract List<Grupo> listarGrupos();

}