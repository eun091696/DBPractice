package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class projectDB14 {

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
					+ " FROM Book "
					+ " where price >= ? AND price <= ? ";
			System.out.println("가격 정보를 입력하세요:");
			Scanner in = new Scanner(System.in);
			System.out.println("첫 번째 가격:");
			String strprice1 = in.nextLine();
			System.out.println("두 번째 가격:");
			String strprice2 = in.nextLine();
			
			int price1 = Integer.parseInt(strprice1);
			int price2 = Integer.parseInt(strprice2);
			
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, price1);
			pstmt.setInt(2, price2);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
				System.out.println();
			}
			
			pstmt.close();
			conn.close();
					
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
