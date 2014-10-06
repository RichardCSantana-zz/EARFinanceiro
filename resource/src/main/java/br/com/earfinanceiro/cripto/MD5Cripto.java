/**
 * 
 */
package br.com.earfinanceiro.cripto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author richard
 *
 */
@Stateless
@Local
public class MD5Cripto implements ICripto {

	@Inject
	private Logger log;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.earfinanceiro.cripto.ICripto#criptografa(java.lang.String)
	 */
	@Override
	public String criptografa(String senha) {
		String digest = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(senha.getBytes("UTF-8"));
			// converting byte array to Hexadecimal
			StringBuilder sb = new StringBuilder(2 * hash.length);
			for (byte b : hash) {
				sb.append(String.format("%02x", b & 0xff));
			}
			digest = sb.toString();
		} catch (UnsupportedEncodingException ex) {
			log.log(Level.SEVERE, null, ex);
		} catch (NoSuchAlgorithmException ex) {
			log.log(Level.SEVERE, null, ex);
		}
		return digest;
	}

}
