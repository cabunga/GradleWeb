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
public class Login implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String pass;

	public String autenticarse() {
		System.out.print(user+"--------"+pass);		
		// FacesContext.getCurrentInstance().addMessage("form:zona", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por Favor Seleccione un Servicio."));
		 return "success";
			
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass
	 *            the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
}
