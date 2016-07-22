/**
 * 
 */
package com.cuentas.banca;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.cuentas.banca.dao.Cliente;
import com.cuentas.banca.dao.Usuarios;

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
		String existe = "";
		Map<String, Cliente> map = Usuarios.getInstance().getUsuarios();
		for (Map.Entry<String, Cliente> entry : map.entrySet()) {		
			if (entry.getValue().getUsuario().equals(user)) {
				HttpSession session = SessionUtils.getSession();
				session.setAttribute("username", user);
				existe = "success";
			}
		}
		if (existe.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(
					"form:zona",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Usuario no valido."));
		}else{
//			 RequestContext contexto = RequestContext
//					.getCurrentInstance();
//			//contexto.execute("dlgCrearCli.hide();");
//			contexto.update("formadministrar");
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("administrar.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return existe;

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
