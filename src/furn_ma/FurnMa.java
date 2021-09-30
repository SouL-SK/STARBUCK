package furn_ma;

import java.sql.Date;

public class FurnMa {
	private int furnMa;
	private String furnType;
	private String furnNm;
	private String furnHome;
	private int furnRem;
	private Date expirDate;
	private Date openDate;
	private String delYn;

	public FurnMa(int furnMa, String furnType, String furnNm, String furnHome, int furnRem, Date expirDate,
			Date openDate, String delYn) {
		this.furnMa = furnMa;
		this.furnType = furnType;
		this.furnNm = furnNm;
		this.furnHome = furnHome;
		this.furnRem = furnRem;
		this.expirDate = expirDate;
		this.openDate = openDate;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "FurnMa [furnMa=" + furnMa + ", furnType=" + furnType + ", furnNm=" + furnNm + ", furnHome=" + furnHome
				+ ", furnRem=" + furnRem + ", expirDate=" + expirDate + ", openDate=" + openDate + ", delYn=" + delYn
				+ "]\n";
	}

}
