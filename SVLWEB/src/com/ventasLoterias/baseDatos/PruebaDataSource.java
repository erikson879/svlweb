package com.ventasLoterias.baseDatos;

import java.sql.Connection;

import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




@ManagedBean
public class PruebaDataSource {
	
	private Connection  con;	
	public String pruebaFuenteDatos() throws Throwable{
		InitialContext cxt;
		try {
			cxt = new InitialContext ();
			//return ("cxtnocontext");
			System.out.println("Paso 1");
			if (cxt == null){
				System.out.println("Paso 2");
				return ("cxtnocontext");
					
			}
			DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/SVL" );
			//con = ds.getConnection();
			System.out.println("Paso 3");
			if ( ds == null ) {
				System.out.println("Paso 4");
				return("Datasourcenotfound");
				}
			//InitialContext cxt = new InitialContext();*/
			/*if(con == null){
				System.out.println("Paso 4");
				return("Conectionnotfound");
			}*/
			con = ds.getConnection();
			con.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/SVL" );
		
		/*if ( ds == null ) {
			   throw new Exception("Data source not found!");
			}*/
		//InitialContext cxt = new InitialContext();
		System.out.println("Paso 5");
		return "Encontro";
	}

}
