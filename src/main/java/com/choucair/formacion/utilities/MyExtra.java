package com.choucair.formacion.utilities;

import java.io.IOException;
public class MyExtra {

	public static void main(String[] args){
		String UsrAs = "CRERAMOS";
		String ClvAs = "TESTER08";
		try{
			String Ejecutor = "C:/ProgramData/Microsoft/Windows/Start Menu/Programs/Attachmate EXTRA! X-treme/extraini.bat";
			Runtime.getRuntime().exec( Ejecutor );
			
			String programa =  "cscript D:/a_doctos_estudio/ScriptAS.vbs" + " " + UsrAs + " "+ ClvAs;
			Runtime.getRuntime().exec( programa );			
		}catch(IOException e){ System.exit(0); }
	}
}
