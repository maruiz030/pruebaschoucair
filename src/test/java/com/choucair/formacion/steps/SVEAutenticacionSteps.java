package com.choucair.formacion.steps;

import java.util.List;

import com.choucair.formacion.pageobjects.SVEAutenticacionPage;

import net.thucydides.core.annotations.Step;

public class SVEAutenticacionSteps {

	SVEAutenticacionPage sVEAutenticacionPage;
	
	@Step
	public void abrirSVE() {
		sVEAutenticacionPage.open();
		sVEAutenticacionPage.llenarpwd("1234567890");
	}

	@Step
	public void autenticar_SVE(List<List<String>> data, int id) {
		sVEAutenticacionPage.strNit.sendKeys("800231969");
		sVEAutenticacionPage.strUsuario.sendKeys("800231969");
		sVEAutenticacionPage.strPass.getAttribute("value");

	}


}
