/**
 * 
 */
package br.com.earfinanceiro.entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import br.com.earfinanceiro.exceptions.ArgumentoInvalidoException;

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
	 * @throws ArgumentoInvalidoException
	 *             - Erros no cadastro do objeto
	 */
	@Test
	public void testaEfetiva() throws ArgumentoInvalidoException {
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
	 * @throws ArgumentoInvalidoException
	 *             - Erros no cadastro do objeto
	 */
	@Test(expected = ArgumentoInvalidoException.class)
	public void testaEfetivaComDataPosterior() throws ArgumentoInvalidoException {
		AbstractConta entrada = new Entrada();
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_MONTH, 1);
		entrada.setDataEfetivacao(instance);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.Entrada#getContabilizaValor()}.
	 * 
	 * @throws ArgumentoInvalidoException
	 *             - não deve lançar
	 */
	@Test
	public void testaContabilizaValor() throws ArgumentoInvalidoException {
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
	 * @throws ArgumentoInvalidoException
	 *             - quando o valor cadastrado é 0
	 */

	@Test(expected = ArgumentoInvalidoException.class)
	public void testaCadastroValorZerado() throws ArgumentoInvalidoException {
		AbstractConta entrada = new Entrada();
		entrada.setDataVencimento(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(0.0);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setValor(Double)}.
	 * 
	 * @throws ArgumentoInvalidoException
	 *             - quando o valor cadastrado é negativo
	 */

	@Test(expected = ArgumentoInvalidoException.class)
	public void testaCadastroValorNegativo() throws ArgumentoInvalidoException {
		AbstractConta entrada = new Entrada();
		entrada.setDataVencimento(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(-10.0);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setValor(Double)}.
	 * 
	 * @throws ArgumentoInvalidoException
	 *             - não deve lançar
	 */
	@Test
	public void testaCadastroValor() throws ArgumentoInvalidoException {
		AbstractConta entrada = new Entrada();
		entrada.setDataVencimento(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(10.0);
		Double expected = 10.0;
		Double actual = entrada.getValor();
		assertEquals(expected, actual);
	}

}
