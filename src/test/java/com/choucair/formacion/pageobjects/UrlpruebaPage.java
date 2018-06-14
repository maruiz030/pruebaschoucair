package com.choucair.formacion.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.asobancaria.com/sabermassermas/simulador-de-credito-hipotecario/")
public class UrlpruebaPage extends PageObject{

	@FindBy(css="menu nav-menu")
	WebElementFacade menuppal;
	
	public void seleccionar_menu() {
		String menu = "Consumidor informado";
		List<WebElement> listamenu = menuppal.findElements(By.tagName("a"));
		for(WebElement opcion: listamenu){
			if (opcion.getText().toUpperCase().trim().equals(menu)){
				opcion.click();
			}
		}
	}
}
