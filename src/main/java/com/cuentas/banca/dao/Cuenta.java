package com.cuentas.banca.dao;

public class Cuenta {
	private double saldo;
	private double monto;
	private String fecha;
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void debitar(double monto2) {
		this.saldo= saldo -monto2;
		
	}

	public void adicionar(double monto2) {
		this.saldo= saldo +monto2;
		
	}

}
