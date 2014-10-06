/**
 * 
 */
package br.com.earfinanceiro.entidades;

import java.io.Serializable;

/**
 * @author richard.santana
 * 
 */
public interface Persistivel extends Serializable {

	Long getId();

	// Método criado devido ao toString ter problemas com o jpa
	String verbalizar();

}
