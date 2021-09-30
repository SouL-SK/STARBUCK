package DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DBUtil {

	private Connection conn = null;

	/**
	 * oracle 서버 연결
	 * 
	 * @return 연결 객체를 반환합니다.
	 */
	public Connection open() {
		String url = "jdbc:oracle:thin:@kdw.cb0dtwejkkxo.us-east-2.rds.amazonaws.com:1521:KDW";
		String id = "KDW";
		String pw = "rlaehddnr12";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DBUtil.open()");
			return conn;
		} catch (Exception e) {
			System.out.println("DBUtil.error()");
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * DB연결 종료
	 */
	public void close() {
		try {
			conn.close();
			System.out.println("DBUtil.close()");
		} catch (Exception e) {
			System.out.println("DBUtil.closeError()");
			e.printStackTrace();
		}
	}
}
