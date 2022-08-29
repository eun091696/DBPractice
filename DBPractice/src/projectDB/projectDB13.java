package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class projectDB13 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbURL = "jdbc:mariadb://58.229.253.250:3306/student313";
		String dbID = "student313";
		String dbPassword = "1234!!";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String SQL = " SELECT * "
					+ " FROM Book"
					+ " WHERE PRICE < ?";
			System.out.println("비교할 가격을 입력하세요:");
			Scanner in = new Scanner(System.in);
			String strprice = in.nextLine();
			int price = Integer.parseInt(strprice);
			
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, price);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)); //bookid
				System.out.println(rs.getString(2)); //bookname
				System.out.println(rs.getString(3)); //publisher
				System.out.println(rs.getInt(4)); //price
			}
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
