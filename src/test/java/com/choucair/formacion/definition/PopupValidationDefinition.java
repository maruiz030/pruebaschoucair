package com.choucair.formacion.definition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;

import com.choucair.formacion.RunnerCsv;
import com.choucair.formacion.pageobjects.ColorlibMenuPage;
import com.choucair.formacion.steps.ColorlibFormValidationSteps;
import com.choucair.formacion.steps.ColorlibLoginSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityParameterizedRunner.class)
public class PopupValidationDefinition {
	@Steps
	ColorlibLoginSteps colorlibLoginSteps;
	@Steps
	ColorlibMenuPage colorlibMenuPage;
	@Steps
	ColorlibFormValidationSteps colorlibFormValidationSteps;
	
	@When("^Diligenciar Fomulario Popup Validation con tabla$")
	public void diligenciar_Fomulario_Popup_Validation_con_tabla(DataTable dtb_DatosPrueba) throws Throwable {	
/*
 * Con este metodo se captura la tabla de datos adjunta en la feature
 * se invoca el script de pasos pasando por parámetro la lista		
 */
		List<List<String>> data = dtb_DatosPrueba.raw();

		for(int i=1; i<data.size(); i++){
			colorlibFormValidationSteps.diligenciar_popup_datos_tabla(data, i);
			//pendiente revisar la forma de enviar el listado
			//colorlibFormValidationSteps.diligenciar_popup_datos_tabla(data.get(i), i);
		}
		
/* De esta forma se asignan los valores de la tala a variables locales
		String str_required = data.get(1).get(0).trim();
		String str_select  	= data.get(1).get(1).trim();
		String str_url  	= data.get(1).get(2).trim();
*/

/* 
 * Con este metodo se captura la tabla de datos adjunta en la feature
 * posteriormente se crea una matriz del mismo tamaño
 * los valores de la tabla son pasados a la matriz
 * se invoca el script de pasos pasando por parámetro la matriz
 * 			
		String[] DataPrueba = new String [data.size()];		
		for(int i=1; i<data.size(); i++){
			DataPrueba[0] = data.get(i).get(0).trim();
			DataPrueba[1] = data.get(i).get(1).trim();
			DataPrueba[2] = data.get(i).get(2).trim();
			colorlibFormValidationSteps.diligenciar_popup_datos(DataPrueba);
		}    
*/
	}
	@Given("^Verificar en Home el label \"([^\"]*)\"$")
	public void verificar_en_Home_el_label(String labelv) throws Throwable {
		colorlibLoginSteps.VerificaHome(labelv);
	}
	@Given("^Ingresar Formulario Forms Validation$")
	public void ingresar_Formulario_Forms_Validation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		colorlibMenuPage.menuFormValidation();	
	}
	@Then("^Diligenciar Fomulario Popup Validation$")
	public void diligenciar_Fomulario_Popup_Validation() throws Throwable {
		colorlibFormValidationSteps.diligenciar_popup();
	
	}	
	@Then("^Verificar mensaje de validacion$")
	public void verificar_mensaje_de_validacion() throws Throwable {
		
	}	
	
	
	@Given("^Autenticar con usuario \"([^\"]*)\" y clave \"([^\"]*)\"$")
	public void autenticar_con_usuario_y_clave(String strUsuario, String strPass) throws Throwable {
		colorlibLoginSteps.login_colorlib(strUsuario, strPass);
	}	
	
	
	
	@Given("^Autenticar ColorLib$")
	public void autenticar_ColorLib(DataTable dtb_tablaDatos) throws Throwable {
		// DataTable es una sentencia de Cucumber
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
//
//		Carga en mapa los datos de acceso de pagina login
		List<List<String>> data = dtb_tablaDatos.raw();
		String str_user  	= data.get(1).get(0).trim();
		String str_pass  	= data.get(1).get(1).trim();
		colorlibLoginSteps.login_colorlib(str_user, str_pass);	}
	@Given("^Cargar Datos \"([^\"]*)\"$")
	public void cargar_Datos(String rutaData) throws Throwable {
		String path = "D:/a_doctos_estudio/Selenium_Excel/APP_SuraLogueo.csv";
		// Abro el .csv en buffer de lectura
		BufferedReader bufferLectura = new BufferedReader(new FileReader(path));
			
		// Leo una línea del archivo
		String linea = bufferLectura.readLine();
		
		while (linea != null) {
			// Separa la línea leída con el separador definido previamente
			String[] campos = linea.split(String.valueOf(";"));
			System.out.println(Arrays.toString(campos));
			
			// Vuelvo a leer del fichero
			linea = bufferLectura.readLine();
		}
		
		// CIerro el buffer de lectura
		if (bufferLectura != null) {
			bufferLectura.close();
		}
	}
	@Given("^Autenticar MyExtra \"([^\"]*)\" y clave \"([^\"]*)\"$")
	public void autenticar_MyExtra_y_clave(String UsrAS, String ClvAS) throws Throwable {
		String programa =  "cscript D:/a_doctos_estudio/ScriptAS.vbs" + " " + UsrAS + " "+ ClvAS;
		Runtime.getRuntime().exec( programa );
	}
	@Given("^Inicio MyExtra \"([^\"]*)\"$")
	public void inicio_MyExtra(String Aplicativo) throws Throwable {
		String Ejecutor = "C:/ProgramData/Microsoft/Windows/Start Menu/Programs/Attachmate EXTRA! X-treme/extraini.bat";
		
		Runtime.getRuntime().exec( Ejecutor );
	}
	
	/**
     * Método que se encarga de consultar los datos ingresados en el query para
     * alimentar la base de datos
     * 
      * @return
     */
	@Given("^Consultar AS400$")
     public ResultSet consultarDatosQuery() {
           Connection con = null;
           try {
                  Class.forName("com.ibm.as400.access.AS400JDBCDriver");
           } catch (ClassNotFoundException e) {
                  System.out.println(e);
                  System.exit(0);
           }
           try {
                  con = DriverManager.getConnection(
                                "jdbc:as400://10.9.2.221/CALIDAD", "CJUDHERNA", "TESTER03");
                  //url = "jdbc:as400:10.9.2.221"
                  Statement stmt = con.createStatement();
                  ResultSet rs = stmt
                                .executeQuery("SELECT * from PCCLIBRAMD.PCCFFPARGR where PAR_VALPAR='SVP63049'");
                  while (rs.next()) {
                         String field1 = rs.getString(4);
                         String field2 = rs.getString(5);
                         System.out.println(field1);
                         System.out.println(field2);
                  }
                  rs.close();
                  stmt.close();
                  con.close();
           } catch (Exception e) {
                  e.printStackTrace();
           }
           return null;

     }
	
	@Given("^Prueba yeison$")	
	public void prueba_yeison() {
		RunnerCsv datoscsv = new RunnerCsv();	
		String cadena = datoscsv.qualifier();
		System.out.println("cadena:=" + cadena);
			System.out.println("cadena:=" + datoscsv.nit);
			System.out.println("cadena:=" + datoscsv.usuario);
	}	
	
}
