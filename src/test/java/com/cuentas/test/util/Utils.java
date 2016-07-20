package com.cuentas.test.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
	private static Utils utils = null;

	private WebDriver webDriver = new ChromeDriver();

	private Utils() {

	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public static Utils getInstance() {

		if (utils == null) {
			String valorDriver = System.getProperty("webdriver");
			if (valorDriver == null) {
				System.setProperty("webdriver",
						"chromedriver.exe");
			}
			utils = new Utils();
		}
		return utils;

	}
}
