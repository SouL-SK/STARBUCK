package main;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import DB.DBUtil;
import cus_ma.CusMa;
import cus_ma.CusMaMain;
import emp_ma.EmpMaMain;
import menu_ma.MenuMaMain;
import prof_ma.ProfMaMain;
import sto_ma.StoMaMain;

public class EmployerLoginMain {
	Scanner sc = new Scanner(System.in);

	public EmployerLoginMain() {
		StarbuckMain.printBoxTop("login page");
		List<CusMa> user = new ArrayList<CusMa>();
		try {
			DBUtil util = new DBUtil();
			Connection conn = null;
			conn = util.open();
			System.out.printf("ID : ");
			String id = sc.next();
			System.out.printf("PASSWORD : ");
			String pass = sc.next();
			PreparedStatement pstat = null;
			String sql = "SELECT CUS_NO, CUS_NM FROM CUS_MA WHERE CUS_ID = \'" + id + "\' AND CUS_PASS = \'" + pass+"\'";
			ResultSet rs = null;
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			while (rs.next()) {
				CusMa list = new CusMa(rs.getInt(1), rs.getString(2), id, pass);
				user.add(list);
			}
			util.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		StarbuckMain.printBoxEnd();
		EmployerLoginMain login = new EmployerLoginMain(user);
	}

	public EmployerLoginMain(List<CusMa> user) {
		int key = 1;
		while (key == 1) {
			StarbuckMain.printBoxTop("manage list");
			System.out.println("1. 메뉴 관리");
			System.out.println("2. 매장 관리");
			System.out.println("3. 직원 관리");
			System.out.println("4. 경영 관리");
			System.out.println("5. 고객 관리");
			System.out.println("6. 종료");
			StarbuckMain.printBoxEnd();
			String val = sc.nextLine();
			switch (val) {

			case "1":
				MenuMaMain m = new MenuMaMain(user);
				break;
			case "2":
				StoMaMain v = new StoMaMain(user);
				break;
			case "3":
				EmpMaMain z = new EmpMaMain(user);
				break;
			case "4":
				ProfMaMain a = new ProfMaMain(user);
				break;
			case "5":
				CusMaMain c = new CusMaMain(user);
				break;
			case "6":
				key = 0;
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("항목에 있는 번호만 입력하세요");
				break;
			}
		}
	}
}
