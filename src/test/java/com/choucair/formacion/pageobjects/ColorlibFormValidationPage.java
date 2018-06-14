package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ColorlibFormValidationPage extends PageObject{

//Campo Required	
	@FindBy(xpath="//*[@id='req']")
	public WebElementFacade txtRequired;
//Campo Seleccion de deporte 1		
	@FindBy(xpath="//*[@id='sport']")
	public WebElementFacade cmbSport1;
//Campo Url	
	@FindBy(xpath="//*[@id='url1']")
	public WebElementFacade txtUrl;
//Campo Email	
	@FindBy(id="email1")
	public WebElementFacade txtEmail1;
//Campo Password1
	@FindBy(id="pass1")
	public WebElementFacade txtPass1;	
//Campo Password2
	@FindBy(id="pass2")
	public WebElementFacade txtPass2;
//Campo Minsize	
	@FindBy(id="minsize1")
	public WebElementFacade txtMinsize1;	
//Campo Minsize	
	@FindBy(name="maxsize1")
	public WebElementFacade txtMaxsize;	
//Campo Number	
	@FindBy(id="number2")
	public WebElementFacade txtNumber;	
//Campo IP
	@FindBy(id="ip")
	public WebElementFacade txtIp;		
//Campo Date
	@FindBy(id="date3")
	public WebElementFacade txtDate;
//Campo Date Earlier
	@FindBy(id="past")
	public WebElementFacade txtDateEarlier;	
}
