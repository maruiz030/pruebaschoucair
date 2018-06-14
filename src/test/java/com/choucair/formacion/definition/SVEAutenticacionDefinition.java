package com.choucair.formacion.definition;

import java.util.List;

import com.choucair.formacion.steps.ColorlibLoginSteps;
import com.choucair.formacion.steps.SVEAutenticacionSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SVEAutenticacionDefinition {
	
	@Steps
	SVEAutenticacionSteps sVEAutenticacionSteps;
	
	@Given("^Abrir Aplicativo SVE$")
	public void abrir_Aplicativo_SVE() throws Throwable {
		sVEAutenticacionSteps.abrirSVE();
		
	}

	@When("^Autenticar SVE$")
	public void autenticar_SVE(DataTable dtb_DatosPrueba) throws Throwable {
		List<List<String>> data = dtb_DatosPrueba.raw();

		for(int i=1; i<data.size(); i++){
			//sVEAutenticacionSteps.autenticarSVE(data, i);
			//pendiente revisar la forma de enviar el listado
			//colorlibFormValidationSteps.diligenciar_popup_datos_tabla(data.get(i), i);
		}		
	}

	@Then("^Verificar Autenticacion$")
	public void verificar_Autenticacion() throws Throwable {
		
	}
}
