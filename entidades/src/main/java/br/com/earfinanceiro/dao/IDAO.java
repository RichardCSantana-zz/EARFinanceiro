package br.com.earfinanceiro.dao;

import java.util.List;

import br.com.earfinanceiro.entidades.Persistivel;

/**
 * @author Richard
 * 
 * @param <T>
 *            - entidade a ser manipulada pelo DAO
 */
public interface IDAO<T extends Persistivel> {

	/**
	 * 
	 * Retorna um valor baseado em um id
	 * 
	 * @param id
	 *            - Long que representa o objeto a ser retornado
	 * @return T referente ao id
	 */
	public T procurar(Long id);

	/**
	 * 
	 * Persiste um valor
	 * 
	 * @param valor
	 *            - T a ser persistida
	 */
	public abstract void salvar(T valor);

	/**
	 * 
	 * Atualiza um valor já persistido
	 * 
	 * @param valor
	 *            - T a ser atualizada
	 */
	public abstract void atualizar(T valor);

	/**
	 * 
	 * Exclui um valor
	 * 
	 * @param valor
	 *            - T a ser excluído
	 */
	public abstract void excluir(T valor);

	/**
	 * 
	 * Exclui um valor
	 * 
	 * @param id
	 *            - Long que representa o Id do grupo a ser excluído
	 */
	public void excluir(Long id);

	/**
	 * 
	 * Retorna lista com todos os T
	 * 
	 * @return {@link List} de T - lista de todos os T
	 */
	public abstract List<T> listaTodos();

}