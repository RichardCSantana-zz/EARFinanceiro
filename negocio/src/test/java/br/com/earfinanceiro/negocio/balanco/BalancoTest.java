/**
 * 
 */
package br.com.earfinanceiro.negocio.balanco;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.earfinanceiro.entidades.AbstractConta;
import br.com.earfinanceiro.entidades.Entrada;
import br.com.earfinanceiro.entidades.IConta;
import br.com.earfinanceiro.entidades.Saida;
import br.com.earfinanceiro.exceptions.ErroCadastroException;

/**
 * @author richard.santana
 * 
 */
public class BalancoTest {

	/**
	 * @throws ErroCadastroException
	 *             - não lança
	 */
	@Test
	public void testVerificaValorDuasEntradas() throws ErroCadastroException {
		List<IConta> contas = new ArrayList<>();
		AbstractConta entrada1 = new Entrada();
		entrada1.setDataVencimento(Calendar.getInstance());
		entrada1.setValor(10.0);
		AbstractConta entrada2 = new Entrada();
		entrada2.setDataVencimento(Calendar.getInstance());
		entrada2.setValor(5.0);
		contas.add(entrada1);
		contas.add(entrada2);
		Balanco balanco = new Balanco();
		balanco.setContas(contas);
		Double actual = balanco.getTotal();
		Double expected = 15.0;
		assertEquals(expected, actual);
	}

	/**
	 * @throws ErroCadastroException
	 *             - não lança
	 */
	@Test
	public void testVerificaValorDuasSaidas() throws ErroCadastroException {
		List<IConta> contas = new ArrayList<>();
		AbstractConta saida1 = new Saida();
		saida1.setDataVencimento(Calendar.getInstance());
		saida1.setValor(10.0);
		AbstractConta saida2 = new Saida();
		saida2.setDataVencimento(Calendar.getInstance());
		saida2.setValor(5.0);
		contas.add(saida1);
		contas.add(saida2);
		Balanco balanco = new Balanco();
		balanco.setContas(contas);
		Double actual = balanco.getTotal();
		Double expected = -15.0;
		assertEquals(expected, actual);
	}

	/**
	 * @throws ErroCadastroException
	 *             - não lança
	 */
	@Test
	public void testVerificaValorEntradasESaidas() throws ErroCadastroException {
		List<IConta> contas = new ArrayList<>();
		AbstractConta entrada1 = new Entrada();
		entrada1.setDataVencimento(Calendar.getInstance());
		entrada1.setValor(10.0);
		AbstractConta saida2 = new Saida();
		saida2.setDataVencimento(Calendar.getInstance());
		saida2.setValor(5.0);
		contas.add(entrada1);
		contas.add(saida2);
		Balanco balanco = new Balanco();
		balanco.setContas(contas);
		Double actual = balanco.getTotal();
		Double expected = 5.0;
		assertEquals(expected, actual);
	}

}
