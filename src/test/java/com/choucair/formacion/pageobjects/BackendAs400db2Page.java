package com.choucair.formacion.pageobjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.choucair.formacion.utilities.Sql_Execute;

import net.serenitybdd.core.pages.PageObject;

public class BackendAs400db2Page extends PageObject{
	
	public ResultSet Ejecutar_Query(String Query) throws SQLException { 
    	Sql_Execute DAO = new Sql_Execute();
    	ResultSet rs = DAO.sql_Execute(Query);        
        return rs;        
    }
	
    public String Armar_Query_Consulta_CNAME(String strDocumento) {
        String strQuery = "SELECT * FROM GPLILIBRA.TMPCNAME2 WHERE CNNOSS = '<documento>'";
        strQuery = strQuery.replace("<documento>", strDocumento);
		return strQuery;
    }

	public void Verificar_Consulta_CNAME(ResultSet rs, List<List<String>> data) throws SQLException {
        while (rs.next()) {
        	String Documento_Recibido = rs.getString(1);
        	String Documento_Esperado = data.get(0).get(0);
    		assertThat(Documento_Recibido, equalTo(Documento_Esperado));	
        	String TipoDoc_Recibido = rs.getString(2);
        	String TipoDoc_Esperado = data.get(0).get(1);
    		assertThat(TipoDoc_Recibido, equalTo(TipoDoc_Esperado));
        	String Nombre_Recibido = rs.getString(3);
        	String Nombre_Esperado = data.get(0).get(2);
    		assertThat(Nombre_Recibido.trim(), equalTo(Nombre_Esperado.trim()));	
        	String CtrlTercero_Recibido = rs.getString(4);
        	String CtrlTercero_Esperado = data.get(0).get(3);
    		assertThat(CtrlTercero_Recibido.trim(), equalTo(CtrlTercero_Esperado.trim()));    	
        }
	}    
    
	
/*	
	public ResultSet SaldoDisponible(String strCuenta, String strTipoCuenta) throws SQLException {
		// Connection con = DriverManager.getConnection(this.url, this.user,this.password);
    	manager = DBManager.getInstance();
        Connection con = manager.getConeccion();        
        String query = "SELECT SDSDODSP FROM SCILIBRAMD.SCIFFSALDO WHERE SDCUENTA = ? AND SDTIPOCTA = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, strCuenta);
        ps.setString(2, strTipoCuenta);
        ResultSet rs = ps.executeQuery();        
        //ps.close();
        //con.close(); 
        return rs;        
    }
*/    

    public ResultSet Consultar_Saldo_Disponible(String Query) throws SQLException { 
    	Sql_Execute DAO = new Sql_Execute();
    	ResultSet rs = DAO.sql_Execute(Query);        
        return rs;        
    }  
    
    public String Armar_Query_Consulta_Saldo_Disponible(String strCuenta, String strTipoCuenta) {
        String strQuery = "SELECT SDSDODSP FROM SCILIBRAMD.SCIFFSALDO "
        		+ "WHERE SDCUENTA = <NumCuenta> AND SDTIPOCTA = '<TipoCta>'";
        strQuery = strQuery.replace("<NumCuenta>", strCuenta);
        strQuery = strQuery.replace("<TipoCta>", strTipoCuenta);
		return strQuery;
    }


    
}
