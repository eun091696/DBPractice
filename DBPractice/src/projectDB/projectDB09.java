package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class projectDB09 {

	public static void main(String[] args) {
		Connection conn = null; //연결하기 위함
		ResultSet rs = null; //결과 값
		PreparedStatement pstmt = null; //SQL전달
		
		String dbURL = "jdbc:mariadb://58.229.253.250:3306/student313";
		String dbID = "student313";
		String dbPassword = "1234!!";
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("검색할 책의 이름은:");
			String bookname = in.nextLine();
			
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String SQL = "SELECT bookname, price "
					+ " FROM	Book "
					+ " WHERE	bookname like ? ";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%"+bookname+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("------------------------------------");
				System.out.println("bookname:" + rs.getString("bookname"));
				System.out.println("price:" + rs.getInt("price"));
				System.out.println("------------------------------------");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
