/**
 * 
 */
package com.cuentas.banca;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cuentas.banca.dao.Cliente;
import com.cuentas.banca.dao.Cuenta;
import com.cuentas.banca.dao.ManejadorCuentas;
import com.cuentas.banca.dao.Usuarios;

/**
 * @author jimmy
 *
 */
@ManagedBean
@SessionScoped
public class Administrar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cuentaOrigen;
	private String cuentaDestino;
	private String valorActual;
	private String valorRetiro;
	Cliente clienteOrigen;
	private ManejadorCuentas manejadorCuentas;
	String user;
	@PostConstruct
	public void init(){
		user = (String) SessionUtils.getSession().getAttribute("username");
	}
	public void transferir() {
		this.clienteOrigen = Usuarios.getInstance().getUsuarios().get(user);
		this.cuentaOrigen=clienteOrigen.getCuenta().getNumero();
		this.valorActual=String.valueOf(clienteOrigen.getCuenta().getSaldo());
		Cliente clienteDestino = new Cliente();
		Cuenta cuenta= new Cuenta();
		cuenta.setNumero(this.cuentaDestino);
		clienteDestino.setCuenta(cuenta);
		try {
			this.manejadorCuentas.transferir(this.clienteOrigen, clienteDestino, Double.valueOf(valorRetiro));
			FacesContext.getCurrentInstance().addMessage("form:zona", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Transferencia exitosa."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("form:zona", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo realizar el proceso. Contacte con Administrador"));
			e.printStackTrace();
		}
		
	}

	/**
	 * @return the cuentaOrigen
	 */
	public String getCuentaOrigen() {
		return cuentaOrigen;
	}

	/**
	 * @param cuentaOrigen
	 *            the cuentaOrigen to set
	 */
	public void setCuentaOrigen(String cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	/**
	 * @return the cuentaDestino
	 */
	public String getCuentaDestino() {
		return cuentaDestino;
	}

	/**
	 * @param cuentaDestino
	 *            the cuentaDestino to set
	 */
	public void setCuentaDestino(String cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	/**
	 * @return the valorActual
	 */
	public String getValorActual() {
		return valorActual;
	}

	/**
	 * @param valorActual
	 *            the valorActual to set
	 */
	public void setValorActual(String valorActual) {
		this.valorActual = valorActual;
	}

	/**
	 * @return the valorRetiro
	 */
	public String getValorRetiro() {
		return valorRetiro;
	}

	/**
	 * @param valorRetiro
	 *            the valorRetiro to set
	 */
	public void setValorRetiro(String valorRetiro) {
		this.valorRetiro = valorRetiro;
	}

}
