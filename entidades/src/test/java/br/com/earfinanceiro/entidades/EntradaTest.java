/**
 * 
 */
package br.com.earfinanceiro.entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import br.com.earfinanceiro.exceptions.ErroCadastroException;

/**
 * @author Richard
 * 
 */
public class EntradaTest {

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#efetiva(java.util.Calendar)}
	 * .
	 * 
	 * @throws ErroCadastroException
	 *             -não deve lançar
	 */
	@Test
	public void testaEfetiva() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(1.0);
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
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setParcelamento(Integer)}
	 * .
	 * 
	 * @throws ErroCadastroException
	 *             - quando a reincidencia é 0
	 */
	@Test(expected = ErroCadastroException.class)
	public void testaParcelamentoComMenosDeUmaParcela()
			throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(1.0);
		entrada.setParcelamento(0);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#reincide(Integer)} .
	 * 
	 * @throws ErroCadastroException
	 *             - não deve lançar
	 */
	@Test
	public void testaParcelamento() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(1.0);
		entrada.setParcelamento(2);
		Boolean actualReincidente = entrada.isParcelada();
		Integer actualReincidencia = entrada.getParcelamento();
		Integer expectedReincidencia = 2;
		assertTrue(actualReincidente);
		assertEquals(expectedReincidencia, actualReincidencia);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.Entrada#contabilizaValor()}.
	 * 
	 * @throws ErroCadastroException
	 *             - não deve lançar
	 */
	@Test
	public void testaContabilizaValor() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(20.0);
		Double expected = 20.0;
		Double actual = entrada.contabilizaValor();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setValor(Double)}.
	 * 
	 * @throws ErroCadastroException
	 *             - quando o valor cadastrado é 0
	 */

	@Test(expected = ErroCadastroException.class)
	public void testaCadastroValorZerado() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(0.0);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setValor(Double)}.
	 * 
	 * @throws ErroCadastroException
	 *             - quando o valor cadastrado é negativo
	 */

	@Test(expected = ErroCadastroException.class)
	public void testaCadastroValorNegativo() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(-10.0);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#setValor(Double)}.
	 * 
	 * @throws ErroCadastroException
	 *             - não deve lançar
	 */
	@Test
	public void testaCadastroValor() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(10.0);
		Double expected = 10.0;
		Double actual = entrada.getValor();
		assertEquals(expected, actual);
	}

}
