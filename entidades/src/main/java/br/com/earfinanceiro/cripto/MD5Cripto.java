/**
 * 
 */
package br.com.earfinanceiro.cripto;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author richard
 *
 */
@Stateless
@Local
public class MD5Cripto implements ICripto {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cripto.ICripto#criptografa(java.lang.String)
	 */
	@Override
	public String criptografa(String senha) {
		return DigestUtils.md5Hex(senha);
	}

}
