/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import br.com.earfinanceiro.entidades.Grupo;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
public interface ISubgrupoNegocio {

	public abstract void salvaSubgrupo(Subgrupo subgrupo);

	public abstract void atualizaSubgrupo(Subgrupo subgrupo);

	public abstract void excluirsubSubgrupo(Subgrupo subgrupo);

	public abstract List<Subgrupo> listarSubgrupos();

	public abstract List<Grupo> getGrupos();

}
