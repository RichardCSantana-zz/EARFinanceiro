/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import br.com.earfinanceiro.entidades.Entrada;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
public interface IEntradaNegocio {

	public abstract void salva(Entrada entrada);

	public abstract void atualiza(Entrada entrada);

	public abstract void excluir(Entrada entrada);

	public abstract List<Subgrupo> getSubgrupos();

}
