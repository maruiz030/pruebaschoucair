#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@Backend
Feature: Title of your feature
	I want to use this template for my feature file

@tag1
Scenario Outline: Title of your scenario
Given Consultar Saldo en SCIFFSALDO <cuenta> <tipo cuenta>

Examples:
    | cuenta  		|tipo cuenta 	| saldo esperado 	|
    | 100005403  	|1 						| 90000000 				|

@CasoFeliz
Scenario Outline: Consultar tabla de clientes CNAME y verificar resultados
Given Consultar CNAME
		| <Documento>  	|<Tipo Docto>		| <Nombre> 	| <Control Terceros>|

Examples:
    | Documento  				|Tipo Docto		| Nombre 						| Control Terceros|
    | 000008000003931  	|3 						| PERFORMANCE2 			| 8 							|
    | 000008000004576  	|3 						| ELIANA MORALES 		| 1 							|

@MYEXTRA
    Scenario: Trabajar con el objeto MyExtra
Given Abrir MyExtra "C:\\Users\\reramos\\Desktop\\CALIDAD.EDP"
When Autenticar MyExtra

    