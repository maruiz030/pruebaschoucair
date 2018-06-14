package com.choucair.formacion.steps;

import com.choucair.formacion.pageobjects.BackendAs400db2Page;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.thucydides.core.annotations.Step;

public class BackendAs400db2Steps {
	
	BackendAs400db2Page backendAs400db2Page;
	
	@Step ("Verificacion de los campos NOMBRE, DOCTO y CONTROL TERCEROS")
	public void Consultar_CNAME(List<List<String>> data) throws SQLException {
		//*Crear query
		String strDocumento = data.get(0).get(0);
		String query = backendAs400db2Page.Armar_Query_Consulta_CNAME(strDocumento);
		//Ejecuta consulta sql
		ResultSet rs = backendAs400db2Page.Ejecutar_Query(query);
		//Verificar resultados
		backendAs400db2Page.Verificar_Consulta_CNAME(rs, data);
	}	
}
