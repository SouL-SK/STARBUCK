package ord_ma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DB.DBUtil;
import cus_ma.CusMa;
import main.EmployerLoginMain;
import main.StarbuckMain;

public class OrderMaMain {
	Scanner sc = new Scanner(System.in);

	public OrderMaMain(List<CusMa> user) {
		if (user.get(4).toString().equals("점장") == true) {
			int key = 0;
			StarbuckMain.printBoxTop("ordering system");
			System.out.println("1. order the furniture");
			System.out.println("2. order the ingredient");
			System.out.println("3. back to the main");
			key = sc.nextInt();
			if (key > 0 && key < 3) {
				OrderMaMain a = new OrderMaMain(user, "order the furniture", key);
			}else if (key == 3) {
				EmployerLoginMain s = new EmployerLoginMain(user);
			}
		}
	}

	public OrderMaMain(List<CusMa> user, String title, int key) {
		StarbuckMain.printBoxTop(title);
		try {
			DBUtil util = new DBUtil();
			Connection conn = null;
			conn = util.open();
			PreparedStatement pstat = null;
			String sql = "";
			ResultSet rs = null;
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			util.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		StarbuckMain.printBoxEnd();
	}
}
