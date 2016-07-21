package com.cuenta.test.tdd;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cuentas.banca.dao.Cliente;
import com.cuentas.banca.dao.Cuenta;
import com.cuentas.banca.dao.ManejadorCuentas;



public class ManejadorCuentaTest {
	private Cliente clienteOrigen;
	private Cliente clienteDestino;
	private ManejadorCuentas manejadorCuentas;

	/**
	 * Metodo que inicializa datos de prueba
	 */
	@Before
	public void init() {
		//Arrange
		clienteOrigen = new Cliente();
		clienteOrigen.setNombre("Jimmy");
		clienteOrigen.setDireccion("Barrio Manila");
		Cuenta cuenta = new Cuenta();
		cuenta.setFecha(new Date().toString());
		cuenta.setSaldo(10000);
		clienteOrigen.setCuenta(cuenta);
		clienteDestino = new Cliente();
		clienteDestino.setNombre("John");
		clienteDestino.setDireccion("Barrio Manila");
		Cuenta cuentaDestino = new Cuenta();
		cuentaDestino.setFecha(new Date().toString());
		cuentaDestino.setSaldo(2000);
		clienteDestino.setCuenta(cuentaDestino);

		manejadorCuentas = new ManejadorCuentas();
	}

	/**
	 * Metodo test para transferir
	 * @throws Exception
	 */
	@Test
	public void transferirSaldoTest() throws Exception {
		//Arrange
		double saldoVerificar = 8000.0;
		double saldoVerificarNuevoCliente = 4000.0;
		
		//Act
		double saldoClienteOrigen = manejadorCuentas.consultarSaldo(clienteOrigen);
		double saldoClienteDestino = manejadorCuentas.consultarSaldo(clienteDestino);
		System.out.println(saldoClienteDestino+"-"+saldoClienteOrigen);
		manejadorCuentas.transferir(clienteOrigen, clienteDestino, 2000);
		double nuevoSaldoClienteOrigen = manejadorCuentas.consultarSaldo(clienteOrigen);
		double nuevoSaldoClienteDestino = manejadorCuentas.consultarSaldo(clienteDestino);
		System.out.println(nuevoSaldoClienteDestino+"-"+nuevoSaldoClienteOrigen);
		// Assert
		Assert.assertTrue("El saldo no coincide", saldoVerificar == nuevoSaldoClienteOrigen);
		Assert.assertTrue("El saldo del nuevo cliente", saldoVerificarNuevoCliente == nuevoSaldoClienteDestino);
	}

	/**
	 * Metodo para verificar saldo prueba saldo insuficiente
	 * @throws Exception
	 */
	@Test	
	public void saldoInsuficienteTest() throws Exception {
		// Arrange
		double saldoVerificar = 10000;
		
		clienteOrigen.getCuenta().setSaldo(20000D);
		// Act
		manejadorCuentas.transferir(clienteOrigen, clienteDestino, 10000);
		double saldo = manejadorCuentas.consultarSaldo(clienteOrigen);
		// Assert
		Assert.assertTrue("El saldo no conincide", saldoVerificar == saldo);
	}
}
