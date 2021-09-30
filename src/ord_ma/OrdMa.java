package ord_ma;

public class OrdMa {
	private int ordNo;
	private int furnNo;
	private int stoNo;
	private int ordAmt;
	private int disAmt;
	private int ordPri;
	private String delYn;

	public OrdMa(int ordNo, int furnNo, int stoNo, int ordAmt, int disAmt, int ordPri, String delYn) {
		this.ordNo = ordNo;
		this.furnNo = furnNo;
		this.stoNo = stoNo;
		this.ordAmt = ordAmt;
		this.disAmt = disAmt;
		this.ordPri = ordPri;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "OrdMa [ordNo=" + ordNo + ", furnNo=" + furnNo + ", stoNo=" + stoNo + ", ordAmt=" + ordAmt + ", disAmt="
				+ disAmt + ", ordPri=" + ordPri + ", delYn=" + delYn + "]\n";
	}

}
