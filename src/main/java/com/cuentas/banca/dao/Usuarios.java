package com.cuentas.banca.dao;

import java.util.HashMap;
import java.util.Map;

public class Usuarios {
	private static Usuarios usuarios;
	private Map<String, Cliente> usuers = new HashMap<String, Cliente>();

	private Usuarios() {
		this.init();
	}

	public void init() {
		Cliente cliente = new Cliente();
		cliente.setUsuario("jimmy");
		cliente.setPassword("jimmy");
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(1000D);
		cuenta.setFecha("2015-12-5");
		cuenta.setNumero("109434565221");	
		cliente.setCuenta(cuenta);
		usuers.put(cliente.getUsuario(), cliente);

		cliente = new Cliente();
		cuenta = new Cuenta();
		cuenta.setSaldo(1000D);
		cuenta.setFecha("2015-12-5");
		cuenta.setNumero("109434565443");
		cliente.setCuenta(cuenta);
		usuers.put(cliente.getUsuario(), cliente);
	}

	public static Usuarios getInstance() {
		if (usuarios == null)
			usuarios = new Usuarios();

		return usuarios;
	}

	public Map<String, Cliente> getUsuarios() {
		return this.usuers;
	}
}
