package com.choucair.formacion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.choucair.formacion.pageobjects.UrlpruebaPage;

import net.serenitybdd.junit.runners.*;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;


@RunWith(SerenityRunner.class)
public class RunnerSerJunitdemos {

	@Steps
	UrlpruebaPage urlpruebaPage;
	
	@Managed(driver="chrome", uniqueSession = true)
	WebDriver driver;
	
	@Test
	public void pruebaobjetos() {
		urlpruebaPage.open();
		urlpruebaPage.seleccionar_menu();
	}
	
}
