package emp_ma;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;


import DB.DBUtil;
import cus_ma.CusMa;
import main.StarbuckMain;

public class EmpMaMain {
	Scanner sc = new Scanner(System.in);

	public EmpMaMain(List<CusMa> user) {
		StarbuckMain.printBoxTop("manage menu");
		System.out.println("1. 직원 등록");
		System.out.println("2. 직원 조회");
		System.out.println("3. 직원 수정");
		System.out.println("4. 직원 삭제");
		StarbuckMain.printBoxEnd();
		int key = sc.nextInt();
		switch (key) {
		case 1:
			EmpMaMain c = new EmpMaMain(user);
			break;
		case 2:
			EmpMaMain r = new EmpMaMain(user);
			break;
		case 3:
			EmpMaMain u = new EmpMaMain(user);
			break;
		case 4:
			EmpMaMain d = new EmpMaMain(user);
			break;
		default:
			System.out.println("위에 번호 4가지 중에 고르세요");
			EmpMaMain s = new EmpMaMain(user);
			break;
		}
	}

	public EmpMaMain(List<CusMa> user, String title, int key) {
		StarbuckMain.printBoxTop(title);
		if (key == 1) {
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();
				PreparedStatement pstat = null;
				String empNm = "";
				String empGrd = "";
				int stoNo = 0;

				System.out.print("등록할 직원의 이름: ");
				empNm = sc.nextLine();
				System.out.println("등록할 직원의 직급: ");
				empGrd = sc.nextLine();
				System.out.println("등록할 직원의 근무 매장");
				stoNo = sc.nextInt();
				String sql = "INSERT INTO EMP_MA(EMP_NO, EMP_NM, EMP_GRD, HIRE_DATE, FIRE_DATE, STO_NO, DEL_YN) VALUES(EMP_MA_SEQ.NEXTVAL, \'"
						+ empNm + "\', \'" + empGrd + "\', SYSDATE, NULL, " + stoNo + ", DEFAULT)";
				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
				util.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			StarbuckMain.printBoxEnd();
			EmpMaMain d = new EmpMaMain(user);
		} else if (key == 2) {
			List<EmpMa> empMa = new ArrayList<EmpMa>();
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();

				PreparedStatement pstst = null;
				String sql = "SELECT * FROM EMP_MA ORDER BY EMP_NO";
				pstst = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstst.executeQuery();
				while (rs.next()) {
					EmpMa menu = new EmpMa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(8),
							rs.getInt(8), rs.getString(9));
					empMa.add(menu);
				}
				System.out.println(empMa.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			StarbuckMain.printBoxEnd();
			EmpMaMain d = new EmpMaMain(user);
		} else if (key == 3) {
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();
				PreparedStatement pstat = null;
				String type = "";
				String val = "";
				int empNo = 0;

				System.out.println("수정할 칼럼: ");
				type = sc.nextLine();
				System.out.println("수정할 내용: ");
				val = sc.nextLine();
				System.out.println("수정할 직원번호: ");
				empNo = sc.nextInt();

				String sql = "UPDATE EMP_MA SET " + type + " = \'" + val + "\'" + " WHERE EMP_NO = " + empNo;
				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}
			StarbuckMain.printBoxEnd();
			EmpMaMain d = new EmpMaMain(user);
		} else if (key == 4) {
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();
				int empNo = 0;
				System.out.println("삭제할 직원의 직원번호를 입력해주세요.");
				empNo = sc.nextInt();
				
				PreparedStatement pstat = null;
				String sql = "DELETE FROM EMP_MA WHERE EMP_NO = "+empNo;
				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}
			StarbuckMain.printBoxEnd();
			EmpMaMain d = new EmpMaMain(user);
		}
	}
}
