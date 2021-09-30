package sell_menu;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DB.DBUtil;
import main.StarbuckMain;

public class SellMenuMain {
	
	public SellMenuMain() {
		StarbuckMain.printBoxTop("메뉴 판매");
		System.out.println("1. 리스트 목록");
		System.out.println("2. ");
//		List<SellMenu> sellMenu = new ArrayList<SellMenu>();
//		sellMenu = SellMenuList();
//		for (SellMenu sellMenu2 : sellMenu) {
//			System.out.println(sellMenu.toString());
//		}
		StarbuckMain.printBoxEnd();
	}
	
	private List<SellMenu> SellMenuList(){
		List<SellMenu> sellMenu = new ArrayList<SellMenu>();
		try {
			DBUtil util = new DBUtil();
			Connection conn = null;
			conn = util.open();
			
			PreparedStatement pstat = null;
			String sql = "SELECT * FROM SELL_MENU ORDER BY SELL_NO";
			
			pstat = conn.prepareStatement(sql);
			ResultSet rs = null;
			rs = pstat.executeQuery();
			while(rs.next()) {
				SellMenu menu = new SellMenu(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
				sellMenu.add(menu);
			}
			
			util.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellMenu;
		
	}
	
}
