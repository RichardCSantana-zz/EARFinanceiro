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

	/**
	 * 
	 * Persiste um grupo
	 * 
	 * @param grupo
	 *            - {@link Grupo} a ser persistido
	 */
	public abstract void salvaGrupo(Grupo grupo);

	/**
	 * 
	 * Atualiza os dados de um grupo já persistido
	 * 
	 * @param grupo
	 *            - {@link Grupo} a ser atualizado
	 */
	public abstract void atualizaGrupo(Grupo grupo);

	/**
	 * 
	 * Exclui um grupo
	 * 
	 * @param grupo
	 *            - {@link Grupo} a ser excluído
	 */
	public abstract void excluirGrupo(Grupo grupo);

	/**
	 * 
	 * Retorna lista de grupos
	 * 
	 * @return {@link List} de {@link Grupo} - lista de grupos
	 */
	public abstract List<Grupo> listarGrupos();

}