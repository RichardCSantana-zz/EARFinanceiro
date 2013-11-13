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
public class SaidaTest {

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setDataEfetivacao(java.util.Calendar)}
	 * 
	 * 
	 */
	@Test
	public void testaEfetiva() {
		AbstractConta saida = new Saida();
		Calendar instance = Calendar.getInstance();
		instance.set(2013, 9, 20);
		saida.setDataEfetivacao(instance);
		Boolean expectedEfetiva = true;
		Boolean actualEfetiva = saida.isEfetiva();
		assertEquals(expectedEfetiva, actualEfetiva);
		Calendar expectedDataEfetivacao = Calendar.getInstance();
		expectedDataEfetivacao.set(2013, 9, 20);
		Calendar actualDataEfetivacao = saida.getDataEfetivacao();
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
		AbstractConta saida = new Saida();
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_MONTH, 1);
		saida.setDataEfetivacao(instance);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setParcelamento(Integer)}
	 * .
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaParcelamentoComMenosDeUmaParcela() {
		Saida saida = new Saida();
		saida.setDataVencimento(Calendar.getInstance());
		saida.setDescricao("teste");
		saida.setValor(1.0);
		saida.setParcelamento(0);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setParcelamento(Integer)}
	 * .
	 * 
	 */
	@Test
	public void testaParcelamento() {
		Saida saida = new Saida();
		saida.setDataVencimento(Calendar.getInstance());
		saida.setDescricao("teste");
		saida.setValor(1.0);
		saida.setParcelamento(2);
		Boolean actualParcelada = saida.isParcelada();
		Integer actualParcelas = saida.getParcelamento();
		Integer expectedParcelas = 2;
		assertTrue(actualParcelada);
		assertEquals(expectedParcelas, actualParcelas);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.Saida#getContabilizaValor()}.
	 * 
	 */
	@Test
	public void testaContabilizaValor() {
		AbstractConta saida = new Saida();
		saida.setDataVencimento(Calendar.getInstance());
		saida.setDescricao("teste");
		saida.setValor(20.0);
		Double expected = -20.0;
		Double actual = saida.getContabilizaValor();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setValor(Double)}.
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCadastroValorZerado() {
		AbstractConta saida = new Saida();
		saida.setDataVencimento(Calendar.getInstance());
		saida.setDescricao("teste");
		saida.setValor(0.0);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setValor(Double)}.
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testaCadastroValorNegativo() {
		AbstractConta saida = new Saida();
		saida.setDataVencimento(Calendar.getInstance());
		saida.setDescricao("teste");
		saida.setValor(-10.0);
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
