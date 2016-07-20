@tag
Feature: Autenticacion de usuario

@tag1
Scenario: Ingresar con usuario y password
	Given Ingreso a la sucursal virtual	
	When Ingreso login "jimmy"	
	And Ingreso password "1234"
	And Seleccion ingresar
	Then Ingreso a la pagina de transferencias