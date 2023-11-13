package entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {
	private String maHD;
	private double thueVAT;
	private LocalDate ngayLapHD;

	public HoaDon() {
		super();
	}

	public HoaDon(String maHD, double thueVAT, LocalDate ngayLapHD) {
		super();
		this.maHD = maHD;
		this.thueVAT = thueVAT;
		this.ngayLapHD = ngayLapHD;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public double getThueVAT() {
		return thueVAT;
	}

	public void setThueVAT(double thueVAT) {
		this.thueVAT = thueVAT;
	}

	public LocalDate getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(LocalDate ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHD, ngayLapHD, thueVAT);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHD, other.maHD) && Objects.equals(ngayLapHD, other.ngayLapHD)
				&& Double.doubleToLongBits(thueVAT) == Double.doubleToLongBits(other.thueVAT);
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", thueVAT=" + thueVAT + ", ngayLapHD=" + ngayLapHD + "]";
	}

}
