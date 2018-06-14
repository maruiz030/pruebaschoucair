package com.choucair.formacion.definition;

import java.util.List;

import com.choucair.formacion.steps.BackendAs400db2Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class BackendAs400db2Definition {

	@Steps
	BackendAs400db2Steps backendAs400db2Steps;

	@Given("^Consultar CNAME$")					//Nombre de la linea gherkin
	public void consultar_CNAME(DataTable dtDatosPrueba) throws Throwable {	//la tabla de datos es recibida tipo DataTable
		List<List<String>> data = dtDatosPrueba.raw();		//Crear una lista con la totalidad de datos recibidos en la tabla
		backendAs400db2Steps.Consultar_CNAME(data);   //invocar el paso respectivo enviando la lista como parámetro
	}	
}
