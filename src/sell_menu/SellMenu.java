package sell_menu;

import java.sql.Date;


public class SellMenu {
	private int sellNo;
	private Date sellDate;
	private String disYn;
	private int menuNo;
	private int cusNo;
	private int empNo;
	private String delYn;
	private int billNo;
	
	public SellMenu(int sellNo, Date sellDate, String disYn, int menuNo, int cusNo, int empNo, String delYn, int billNo) {
		this.sellNo = sellNo;
		this.sellDate = sellDate;
		this.disYn = disYn;
		this.menuNo = menuNo;
		this.cusNo = cusNo;
		this.empNo = empNo;
		this.delYn = delYn;
		this.billNo = billNo;
	}

	@Override
	public String toString() {
		return "SellMenu [sellNo=" + sellNo + ", sellDate=" + sellDate + ", disYn=" + disYn + ", menuNo=" + menuNo
				+ ", cusNo=" + cusNo + ", empNo=" + empNo + ", delYn=" + delYn + ", billNo=" + billNo + "]\n";
	}
	
	
}
