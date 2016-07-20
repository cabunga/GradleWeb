package com.cuentas.banca.dao;

public class ManejadorCuentas {

	public boolean saldoSuficiente(Cliente cliente, double monto) {
		boolean sedebito = false;
		if (cliente.getCuenta().getSaldo() >= monto) {			
			sedebito = true;
		}
		return sedebito;
	}

	public double consultarSaldo(Cliente cliente) {

		return cliente.getCuenta().getSaldo();
	}

	public void transferir(Cliente clienteOrigen, Cliente clienteDestino, double monto) throws Exception {
		if(saldoSuficiente(clienteOrigen,monto)){
			clienteOrigen.getCuenta().debitar(monto);
			clienteDestino.getCuenta().adicionar(monto);	
		}else{
			throw new Exception("Saldo Insuficiente");
		}
		
		
	}

}
