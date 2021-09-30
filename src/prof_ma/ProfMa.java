package prof_ma;

import java.sql.Date;

public class ProfMa {
	private Date calDate;
	private int profit;
	private int expences;
	private String delYn;

	public ProfMa() {
	}

	public Date getCalDate() {
		return calDate;
	}

	public void setCalDate(Date calDate) {
		this.calDate = calDate;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getExpences() {
		return expences;
	}

	public void setExpences(int expences) {
		this.expences = expences;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public ProfMa(Date calDate, int profit, int expences, String delYn) {
		this.calDate = calDate;
		this.profit = profit;
		this.expences = expences;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "ProfMA [calDate=" + calDate + ", profit=" + profit + ", expences=" + expences + ", delYn=" + delYn
				+ "]\n";
	}

}
