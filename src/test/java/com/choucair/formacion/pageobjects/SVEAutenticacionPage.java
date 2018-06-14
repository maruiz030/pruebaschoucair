package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://bolebc05.qa.todo1.com/SVE/control/BoleTransactional.bancolombia")
public class SVEAutenticacionPage extends PageObject{

	@FindBy(id="COMPANYID")
	public WebElementFacade strNit;
	
	@FindBy(id="CLIENTID")
	public WebElementFacade strUsuario;	

	@FindBy(id="USERPASS")
	public WebElementFacade strPass;

	@FindBy(xpath="//*[@id='forma']/table[1]/tbody/tr[3]/td[1]/div[2]/input[2]")
	public WebElementFacade btnAceptar;	

	
	public void llenarpwd(String pwd){
//		strPass.click();
		strNit.click();
		for(int i=0; i<pwd.length(); i++){
			char num1 = pwd.charAt(i);
			String idobje = "mykey" + num1;
			find(By.id(idobje)).click();
		}
	}
	
}
