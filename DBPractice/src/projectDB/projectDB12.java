package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class projectDB12 {

	public static void main(String[] args) {
		Connection conn = null; //연결하기 위함
		ResultSet rs = null; //결과 값
		PreparedStatement pstmt = null; //SQL전달
		
		String dbURL = "jdbc:mariadb://58.229.253.250:3306/student313";
		String dbID = "student313";
		String dbPassword = "1234!!";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String SQL = "SELECT DISTINCT publisher "
					+ " FROM	Book ";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
