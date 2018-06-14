package com.choucair.formacion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.choucair.formacion.pageobjects.ColorlibMenuPage;
import com.choucair.formacion.steps.ColorlibLoginSteps;

import net.serenitybdd.junit.runners.*;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;

//@RunWith(SerenityRunner.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/Datadriven/tdd.csv")
public class RunnerSerenityJunit {
	public String clave;
	public String usuario;
	
	@Managed(driver="chrome", uniqueSession = true)
	WebDriver driver;
	
	@Steps
	ColorlibLoginSteps colorlibLoginSteps;
	@Steps
	ColorlibMenuPage colorlibMenuPage;

/*	@Qualifier
	public String qualifier() {
	    return nit + "" + usuario;
	}
*/	
	@Test
	public void login_en_colorlib() {
		// GIVEN
		colorlibLoginSteps.login_colorlib(usuario, clave );
		// WHEN
		colorlibMenuPage.menuFormValidation();
		// THEN
		System.out.println(usuario);		
		System.out.println(clave);		
	}
}
