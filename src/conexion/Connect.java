package conexion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import com.mysql.jdbc.CommunicationsException;


public class Connect {
	private static final String NAMEDB = "db_management";
	private static final String CONTROLLER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/" + NAMEDB;
	private static final String USER = "root";
	private static final String PASS = "root";

	Connection conn=null;
	
	public String conectar() {
		String respuesta="";
		try {
			//obtener el driver
			Class.forName(CONTROLLER);
			//obtener la conexion
			conn=DriverManager.getConnection(URL,USER,PASS);
			if (conn!=null) {
				respuesta="Connected";
			}else{
				respuesta="NO SE PUDO CONECTAR "+NAMEDB;
			}
		}
		catch (ClassNotFoundException e) {
			respuesta="ocurre una ClassNotFoundException : "+e.getMessage();
		}
		catch (SQLSyntaxErrorException e) {
			respuesta="ocurre una SQLSyntaxErrorException: "+e.getMessage()+"\n";
			respuesta+="Verifique que se esté usando la base de datos y tablas correctas...";
		}
		catch (CommunicationsException e) {
			respuesta="ocurre una CommunicationsException: "+e.getMessage()+"\n";
			respuesta+="Verifique que la base de datos fué iniciada...";
		}
		catch (SQLException e) {
			respuesta="ocurre una SQLException: "+e.getMessage()+"\n";
			respuesta+="Este es un problema general de SQL, verifique con el administrador";
		}
		
		return respuesta;
	}
	
	public Connection getConnection(){
		return conn;
	}
	public void desconectar(){
		conn=null;
	}
}

