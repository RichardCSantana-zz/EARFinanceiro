/**
 * 
 */
package br.com.financemanager.entidades;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import br.com.financemanager.entidades.AbstractConta;
import br.com.financemanager.entidades.Entrada;
import br.com.financemanager.entidades.Saida;
import br.com.financemanager.exceptions.ErroCadastroException;

/**
 * @author Richard
 * 
 */
public class SaidaTest {

	/**
	 * Test method for
	 * {@link br.com.financemanager.entidades.AbstractConta#efetiva(java.util.Calendar)}
	 * .
	 * 
	 * @throws ErroCadastroException
	 */
	@Test(expected = ErroCadastroException.class)
	public void testaEfetivaComEfetivacaoInferiorAoCadastro()
			throws ErroCadastroException {
		AbstractConta saida = new Saida();
		saida.setDataCadastro(Calendar.getInstance());
		saida.setDescricao("teste");
		saida.setValor(1.0);
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_YEAR,
				Calendar.getInstance().get(Calendar.DAY_OF_YEAR - 1));
		saida.efetiva(instance);
	}

	/**
	 * Test method for
	 * {@link br.com.financemanager.entidades.AbstractConta#efetiva(java.util.Calendar)}
	 * .
	 * 
	 * @throws ErroCadastroException
	 */
	@Test(expected = ErroCadastroException.class)
	public void testaEfetivaJahEfetivada() throws ErroCadastroException {
		AbstractConta saida = new Saida();
		saida.setDataCadastro(Calendar.getInstance());
		saida.setDescricao("teste");
		saida.setValor(1.0);
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_YEAR,
				Calendar.getInstance().get(Calendar.DAY_OF_YEAR + 1));
		saida.efetiva(instance);
		saida.efetiva(instance);
	}

	/**
	 * Test method for
	 * {@link br.com.financemanager.entidades.AbstractConta#efetiva(java.util.Calendar)}
	 * .
	 * 
	 * @throws ErroCadastroException
	 */
	@Test
	public void testaEfetiva() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataCadastro(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(1.0);
		Calendar instance = Calendar.getInstance();
		instance.set(2013, 10, 20);
		entrada.efetiva(instance);
		Boolean expectedEfetiva = true;
		Boolean actualEfetiva = entrada.efetiva;
		assertEquals(expectedEfetiva, actualEfetiva);
		Calendar expectedDataEfetivacao = Calendar.getInstance();
		expectedDataEfetivacao.set(2013, 10, 20);
		Calendar actualDataEfetivacao = entrada.getDataEfetivacao();
		assertEquals(expectedDataEfetivacao.get(Calendar.DAY_OF_MONTH),
				actualDataEfetivacao.get(Calendar.DAY_OF_MONTH));
		assertEquals(expectedDataEfetivacao.get(Calendar.MONTH),
				actualDataEfetivacao.get(Calendar.MONTH));
		assertEquals(expectedDataEfetivacao.get(Calendar.YEAR),
				actualDataEfetivacao.get(Calendar.YEAR));
	}

	/**
	 * Test method for
	 * {@link br.com.financemanager.entidades.Saida#contabilizaValor()}.
	 * 
	 * @throws ErroCadastroException
	 */
	@Test
	public void testaContabilizaValor() throws ErroCadastroException {
		AbstractConta saida = new Saida();
		saida.setDataCadastro(Calendar.getInstance());
		saida.setDescricao("teste");
		saida.setValor(20.0);
		Double expected = -20.0;
		Double actual = saida.contabilizaValor();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link br.com.financemanager.entidades.AbstractConta#setValor()}.
	 * 
	 * @throws ErroCadastroException
	 */
	@Test(expected = ErroCadastroException.class)
	public void testaCadastroValorZerado() throws ErroCadastroException {
		AbstractConta saida = new Saida();
		saida.setDataCadastro(Calendar.getInstance());
		saida.setDescricao("teste");
		saida.setValor(0.0);
	}

	/**
	 * Test method for
	 * {@link br.com.financemanager.entidades.AbstractConta#setValor()}.
	 * 
	 * @throws ErroCadastroException
	 */
	@Test(expected = ErroCadastroException.class)
	public void testaCadastroValorNegativo() throws ErroCadastroException {
		AbstractConta saida = new Saida();
		saida.setDataCadastro(Calendar.getInstance());
		saida.setDescricao("teste");
		saida.setValor(-10.0);
	}

	/**
	 * Test method for
	 * {@link br.com.financemanager.entidades.AbstractConta#setValor()}.
	 * 
	 * @throws ErroCadastroException
	 */
	@Test
	public void testaCadastroValor() throws ErroCadastroException {
		AbstractConta entrada = new Entrada();
		entrada.setDataCadastro(Calendar.getInstance());
		entrada.setDescricao("teste");
		entrada.setValor(10.0);
		Double expected = 10.0;
		Double actual = entrada.getValor();
		assertEquals(expected, actual);
	}

}
