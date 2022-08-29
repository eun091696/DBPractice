package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class projectDB03 {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String dbURL = "jdbc:mariadb://58.229.253.250:3306/student313";
		String dbID = "student313";
		String dbPassword = "1234!!";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			for(int i = 0; i < 5; i++) {
				Scanner in = new Scanner(System.in);
				System.out.println("이름을 입력하세요:");
				String name = in.nextLine();
				System.out.println("이메일을 입력하세요:");
				String email = in.nextLine();
				System.out.println("출생년도를 입력하세요:");
				String year = in.nextLine();
				int birthYear = Integer.parseInt(year);
				String SQL = "INSERT INTO acecTable(username, email, birthYear) VALUES(?,?,?)"; //입력된 값을 ?에 설정한다.
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, name); // 첫 번째 물음표의 값
				pstmt.setString(2, email); //두 번째 물음표의 값
				pstmt.setInt(3, birthYear); //세 번째 물음표의 값
				int result = pstmt.executeUpdate();
				System.out.println("결과는: " + result);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
