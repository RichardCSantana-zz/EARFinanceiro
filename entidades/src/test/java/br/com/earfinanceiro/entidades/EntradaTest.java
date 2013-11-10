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
	 *             - Erro de cadastro quando efetivado antes da data de previsão
	 */
	@Test(expected = ErroCadastroException.class)
	public void testaEfetivaComEfetivacaoInferiorAoCadastro()
			throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(1.0);
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_YEAR,
				Calendar.getInstance().get(Calendar.DAY_OF_YEAR - 1));
		entrada.efetiva(instance);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#efetiva(java.util.Calendar)}
	 * .
	 * 
	 * @throws ErroCadastroException
	 *             - Quando a conta já estiver efetivada
	 */
	@Test(expected = ErroCadastroException.class)
	public void testaEfetivaJahEfetivada() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(1.0);
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_YEAR,
				Calendar.getInstance().get(Calendar.DAY_OF_YEAR + 1));
		entrada.efetiva(instance);
		entrada.efetiva(instance);
	}

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
		instance.set(2013, 10, 20);
		entrada.efetiva(instance);
		Boolean actualEfetiva = entrada.isEfetiva();
		Calendar expectedDataEfetivacao = Calendar.getInstance();
		expectedDataEfetivacao.set(2013, 10, 20);
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
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#reincide(Integer)} .
	 * 
	 * @throws ErroCadastroException
	 *             - quando a reincidencia é 0
	 */
	@Test(expected = ErroCadastroException.class)
	public void testaReincidenciaComMenosDeUmDia() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(1.0);
		entrada.reincide(0);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#reincide(Integer)} .
	 * 
	 * @throws ErroCadastroException
	 *             - Quando tenta reaplicar reincidência
	 */
	@Test(expected = ErroCadastroException.class)
	public void testaReincideJahReincidida() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(1.0);
		entrada.reincide(1);
		entrada.reincide(1);
	}

	/**
	 * Test method for
	 * {@link br.com.earfinanceiro.entidades.AbstractConta#reincide(Integer)} .
	 * 
	 * @throws ErroCadastroException
	 *             - não deve lançar
	 */
	@Test
	public void testaReincidencia() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataPrevisao(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(1.0);
		entrada.reincide(1);
		Boolean actualReincidente = entrada.isReincidente();
		Integer actualReincidencia = entrada.getReincidencia();
		Integer expectedReincidencia = 1;
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
