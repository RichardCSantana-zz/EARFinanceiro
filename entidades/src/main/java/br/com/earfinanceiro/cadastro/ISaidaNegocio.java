/**
 * 
 */
package br.com.earfinanceiro.cadastro;

import java.util.List;

import br.com.earfinanceiro.entidades.Saida;
import br.com.earfinanceiro.entidades.Subgrupo;

/**
 * @author Richard
 * 
 */
public interface ISaidaNegocio {

	public abstract void salva(Saida entrada);

	public abstract void atualiza(Saida entrada);

	public abstract void excluir(Saida entrada);

	public abstract List<Subgrupo> getSubgrupos();

}
