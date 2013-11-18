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

/**
 * @author richard.santana
 * 
 */
public class BalancoTest {

	@Test
	public void testaSemEntrada() {
		List<IConta> contas = new ArrayList<>();
		Balanco balanco = new Balanco();
		balanco.setContas(contas);
		Double actual = balanco.getTotal();
		Double expected = 0.0;
		assertEquals(expected, actual);
	}

	/**

	 */
	@Test
	public void testVerificaValorDuasEntradas() {
		List<IConta> parcelas = new ArrayList<>();
		AbstractConta entrada1 = new Entrada();
		entrada1.setDataVencimento(Calendar.getInstance());
		entrada1.setValor(10.0);
		AbstractConta entrada2 = new Entrada();
		entrada2.setDataVencimento(Calendar.getInstance());
		entrada2.setValor(5.0);
		parcelas.add(entrada1);
		parcelas.add(entrada2);
		Balanco balanco = new Balanco();
		balanco.setContas(parcelas);
		Double actual = balanco.getTotal();
		Double expected = 15.0;
		assertEquals(expected, actual);
	}

	/**
	 */
	@Test
	public void testVerificaValorDuasSaidas() {
		List<IConta> parcelas = new ArrayList<>();
		AbstractConta saida1 = new Saida();
		saida1.setDataVencimento(Calendar.getInstance());
		saida1.setValor(10.0);
		AbstractConta saida2 = new Saida();
		saida2.setDataVencimento(Calendar.getInstance());
		saida2.setValor(5.0);
		parcelas.add(saida1);
		parcelas.add(saida2);
		Balanco balanco = new Balanco();
		balanco.setContas(parcelas);
		Double actual = balanco.getTotal();
		Double expected = -15.0;
		assertEquals(expected, actual);
	}

	/**
	 */
	@Test
	public void testVerificaValorEntradasESaidas() {
		List<IConta> parcelas = new ArrayList<>();
		AbstractConta entrada1 = new Entrada();
		entrada1.setDataVencimento(Calendar.getInstance());
		entrada1.setValor(10.0);
		AbstractConta saida2 = new Saida();
		saida2.setDataVencimento(Calendar.getInstance());
		saida2.setValor(5.0);
		parcelas.add(entrada1);
		parcelas.add(saida2);
		Balanco balanco = new Balanco();
		balanco.setContas(parcelas);
		Double actual = balanco.getTotal();
		Double expected = 5.0;
		assertEquals(expected, actual);
	}

}
