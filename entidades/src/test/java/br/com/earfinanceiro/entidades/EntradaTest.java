/**
 * 
 */
package br.com.earfinanceiro.entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

/**
 * @author Richard
 * 
 */
public class EntradaTest {

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setDataEfetivacao(java.util.Calendar)}
	 * .
	 * 
	 */
	@Test
	public void testaEfetiva() {
		AbstractConta entrada = new Entrada();
		Calendar instance = Calendar.getInstance();
		instance.set(2013, 9, 20);
		entrada.setDataEfetivacao(instance);
		Boolean actualEfetiva = entrada.isEfetiva();
		Calendar expectedDataEfetivacao = Calendar.getInstance();
		expectedDataEfetivacao.set(2013, 9, 20);
		Calendar actualDataEfetivacao = entrada.getDataEfetivacao();
		assertTrue(actualEfetiva);
		assertEquals(expectedDataEfetivacao.get(Calendar.DAY_OF_MONTH),
				actualDataEfetivacao.get(Calendar.DAY_OF_MONTH));
		assertEquals(expectedDataEfetivacao.get(Calendar.MONTH),
				actualDataEfetivacao.get(Calendar.MONTH));
		assertEquals(expectedDataEfetivacao.get(Calendar.YEAR),
				actualDataEfetivacao.get(Calendar.YEAR));
	}

	/**
	 * 
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setDataEfetivacao(java.util.Calendar)}
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaEfetivaComDataPosterior() {
		AbstractConta entrada = new Entrada();
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_MONTH, 1);
		entrada.setDataEfetivacao(instance);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.Entrada#getContabilizaValor()}.
	 * 
	 */
	@Test
	public void testaContabilizaValor() {
		AbstractConta entrada = new Entrada();
		entrada.setDataVencimento(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(20.0);
		Double expected = 20.0;
		Double actual = entrada.getContabilizaValor();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setValor(Double)}.
	 * 
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testaCadastroValorZerado() throws IllegalArgumentException {
		AbstractConta entrada = new Entrada();
		entrada.setDataVencimento(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(0.0);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setValor(Double)}.
	 * 
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testaCadastroValorNegativo() {
		AbstractConta entrada = new Entrada();
		entrada.setDataVencimento(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(-10.0);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setValor(Double)}.
	 * 
	 */
	@Test
	public void testaCadastroValor() {
		AbstractConta entrada = new Entrada();
		entrada.setDataVencimento(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(10.0);
		Double expected = 10.0;
		Double actual = entrada.getValor();
		assertEquals(expected, actual);
	}

}
