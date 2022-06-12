package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Statement;

import config.DB;
import model.vo.UserVO;

public class UserDAO {
	
	private Connection connection = null;
	private DB dbConnect = null;
	private PreparedStatement preStatement = null;
		
	private Statement dbQ;
	
	public UserDAO() {
		this.dbConnect = new DB();
		this.connection = dbConnect.getConnection();
		try {
			this.dbQ =  (Statement) this.connection.createStatement();
		} catch(SQLException ex) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
//	private String conectar() {
//		conexion = new Connect();
//		String resultado=conexion.conectar();
//		if (resultado.equals("conectado")) {
//			connection = conexion.getConnection();
//			preStatement = null;
//		}else {
//			JOptionPane.showMessageDialog(null, resultado,"Error",JOptionPane.ERROR_MESSAGE);
//		}
//		return resultado;
//	}
	
	public UserVO getUser(String username) throws SQLException {
		UserVO user=null;
		
		ResultSet result=null;
		
		String consulta="SELECT id, name, last_name, username, password, status"
				+ " FROM users where username= ? ";
		
		try {
			preStatement=connection.prepareStatement(consulta);
			preStatement.setString(1, username);
				
			result=preStatement.executeQuery();
				
			if(result.next()){
				user=new UserVO();

				user.setId(result.getInt("id"));
				user.setName(result.getString("name"));
				user.setLastName(result.getString("last_name"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setStatus(result.getInt("status"));
	
			}		
			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}finally {
			result.close();
			preStatement.close();
			connection.close();
			dbConnect.desconnect();
		};
		return user;
	}
	
}
