package inte_ma;

public class InteMa {
	private int inteNo;
	private String inteNm;
	private String inteType;
	private String inteLoc;
	private int stoNo;
	private String delYn;
	
	public InteMa(int inteNo, String inteNm, String inteType, String inteLoc, int stoNo, String delYn) {
		this.inteNo = inteNo;
		this.inteNm = inteNm;
		this.inteType = inteType;
		this.inteLoc = inteLoc;
		this.stoNo = stoNo;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "InteMa [inteNo=" + inteNo + ", inteNm=" + inteNm + ", inteType=" + inteType + ", inteLoc=" + inteLoc
				+ ", stoNo=" + stoNo + ", delYn=" + delYn + "]\n";
	}
	
	
}
