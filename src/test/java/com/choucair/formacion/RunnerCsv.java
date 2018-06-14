package com.choucair.formacion;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.*;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/Datadriven/tdd.csv")
public class RunnerCsv {
public String nit;
public String usuario;

public void setNit2(String nit) {
	this.nit = nit;
}

public void setUsuario2(String usuario) {
	this.usuario = usuario;
}

@Qualifier
public String qualifier() {
    return nit + "" + usuario;
}

@Test
public void devolverdato() {
	System.out.println("Nit:"+ nit);
	System.out.println(usuario);
}

}
