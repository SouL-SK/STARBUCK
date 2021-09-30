package prof_ma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import DB.DBUtil;
import cus_ma.CusMa;
import main.StarbuckMain;

public class ProfMaMain {
	Scanner sc = new Scanner(System.in);

	public ProfMaMain(List<CusMa> user) {
		StarbuckMain.printBoxTop("profit manage");
		System.out.println("1. 지출 조회");
		System.out.println("2. 순수익 계산");
		System.out.println("3. 내역 삭제");
		StarbuckMain.printBoxEnd();
		int i = sc.nextInt();
		if (i == 1) {
			StarbuckMain.printBoxTop("expences");
			List<ProfMa> profList = new ArrayList<ProfMa>();
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();
				PreparedStatement pstat = null;
				String sql = "SELECT * FROM PROF_MA ORDER BY CAL_DATE";

				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
				while (rs.next()) {
					ProfMa profMa = new ProfMa(rs.getDate(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
					profList.add(profMa);
				}
				util.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(profList.toString());
			
			StarbuckMain.printBoxEnd();
		} else if (i == 2) {
			StarbuckMain.printBoxTop("calculate profit");
			List<ProfMa> list = new ArrayList<ProfMa>();
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();

				PreparedStatement pstat = null;
				String sql = "SELECT CAL_DATE, PROFIT, EXPENCES FROM PROF_MA";

				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();

				while (rs.next()) {
					ProfMa prof = new ProfMa();
					prof.setCalDate(rs.getDate("CAL_DATE"));
					prof.setProfit(rs.getInt("PROFIT"));
					prof.setExpences(rs.getInt("EXPENCES"));
					list.add(prof);
				}
				List<HashMap<String, Integer>> result = profitCal(list);
				System.out.println(result.toString());
				util.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			StarbuckMain.printBoxEnd();
		} else if (i == 3) {
			StarbuckMain.printBoxTop("delete list");
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();

				PreparedStatement pstat = null;
				String sql = "DELETE FROM PROF_MA WHERE TO_CHAR(CAL_DATE, 'YYYYMMDD') = ";

				String str = "";
				while (i == 3) {
					if (str.isEmpty()) {
						System.out.println("삭제할 날짜를 입력하세요.(YYYYMMDD 형식)");
						str = sc.nextLine();
					}else {
						i = 0;
						sql += "\'" + str + "\'";
					}
				}
				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
				System.out.printf("코드 %s의 삭제가 완료되었습니다.\n", str);
				util.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			StarbuckMain.printBoxEnd();
		}
	}
	
	public static List<HashMap<String, Integer>> profitCal(List<ProfMa> prof) {
		List<HashMap<String, Integer>> result = new ArrayList<HashMap<String,Integer>>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (ProfMa element : prof) {
			Integer val = element.getProfit() - element.getExpences();
			String dt = element.getCalDate().toString();
			map.put(dt, val);
			result.add(map);
		}
		return result;
	}
	
	
}
