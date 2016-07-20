package com.cuenta.test.atdd;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;





import com.cuentas.banca.dao.Cliente;
import com.cuentas.banca.dao.Usuarios;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestTransferir {
	WebDriver webDriver;
	Cliente cliente;
	
	@After
	public void after() {
		webDriver.close();
	}

	@Given("^mi saldo actual es \"([^\"]*)\"$")
	public void mi_saldo_actual_es(String saldo) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\Test\\GradleWeb\\src\\test\\java\\resources\\chromedriver.exe");
		webDriver = new ChromeDriver();
		
		cliente = Usuarios.getInstance().getUsuarios().get("jimmy");
		cliente.getCuenta().setSaldo(Double.valueOf(saldo));
	
	}

	@Given("^estoy en la pantalla de cuentas$")
	public void estoy_en_la_pantalla_de_cuentas() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		webDriver.get("http://localhost:8080/GradleWeb/faces/index.xhtml");
		WebElement input = webDriver.findElement(By.xpath(".//*[contains(@id,'idusuario')]"));
		input.sendKeys(cliente.getUsuario());
		WebElement inputpass = webDriver.findElement(By.xpath(".//*[contains(@id,'idpass')]"));
		inputpass.sendKeys(cliente.getPassword());
		WebElement button = webDriver.findElement(By.xpath(".//*[contains(@id,'idIngresar')]"));
		button.click();
		
	}

	@When("^ingreso el saldo a transferir de \"([^\"]*)\"$")
	public void ingreso_el_saldo_a_transferir_de(String monto) throws Throwable {
		WebElement inputCuentaO = webDriver.findElement(By.xpath(".//*[contains(@id,'idcuentaOrigen')]"));
		
		inputCuentaO.sendKeys(cliente.getCuenta().getNumero().toString());
		WebElement inputMontoActual = webDriver.findElement(By.xpath(".//*[contains(@id,'idvalorActual')]"));
		inputMontoActual.sendKeys(String.valueOf(cliente.getCuenta().getSaldo()));
		
		
		Thread.sleep(1000);
		WebElement inputMonto = webDriver.findElement(By.xpath(".//*[contains(@id,'idmonto')]"));
		inputMonto.sendKeys(monto);

	}

	@When("^ingreso la cuenta destino \"([^\"]*)\"$")
	public void ingreso_la_cuenta_destino(String cuenta) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement input = webDriver.findElement(By.xpath(".//*[contains(@id,'idcuentaDestino')]"));
		input.sendKeys(cuenta);

	}

	@When("^seleccion la opcion Transferir$")
	public void seleccion_la_opcion_Transferir() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement button = webDriver.findElement(By.xpath(".//*[contains(@id,'idTransferir')]"));
		button.click(); 
		
	}

	@Then("^veo el mensaje \"([^\"]*)\"$")
	public void veo_el_mensaje(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
	}

	@Then("^mi nuevo saldo es \"([^\"]*)\"$")
	public void mi_nuevo_saldo_es(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		

	}
}
