/**
 * 
 */
package com.cuentas.banca;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author USUARIO
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

	public void transferir() {
		FacesContext.getCurrentInstance().addMessage("form:zona", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Transaccion realizada con exito."));
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
