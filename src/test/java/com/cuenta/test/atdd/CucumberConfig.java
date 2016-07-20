package com.cuenta.test.atdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author USUARIO
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
					features = {"src/test/java/"},
					glue={"com.cuenta.test.atdd"})
public class CucumberConfig {
	
}