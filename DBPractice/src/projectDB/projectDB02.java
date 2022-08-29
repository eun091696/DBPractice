package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class projectDB02 {

	public static void main(String[] args) {
		Connection conn = null; //연결을 위한것.
		ResultSet rs = null; //결과를 받아오는것.
		PreparedStatement pstmt = null; //SQL을 전달하기 위한것.
		String dbURL = "jdbc:mariadb://58.229.253.250:3306/student313";
		String dbID = "student313";
		String dbPassword = "1234!!";
		//연결
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String SQL = "CREATE TABLE if not exists acecTable(id varchar(50)," 
					 +"userName varchar(50)," 
					 +"email varchar(50)," 
					+"birthYear int(11))";
			pstmt = conn.prepareStatement(SQL); //SQL문장 전달
			pstmt.executeUpdate(); //실행이며 execute();와 executeUpdate();를 사용한다.
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
