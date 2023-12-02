package entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {
	private String maHD;
	private String maNV;
	private String maKH;

	private LocalDate ngayLapHD;

	public HoaDon() {
	}

	public HoaDon(String maHD, String maNV, String maKH, LocalDate ngayLapHD) {
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngayLapHD = ngayLapHD;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public LocalDate getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(LocalDate ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		HoaDon hoaDon = (HoaDon) o;
		return Objects.equals(maHD, hoaDon.maHD);
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}

	@Override
	public String toString() {
		return "HoaDon{" +
				"maHD='" + maHD + '\'' +
				", maNV='" + maNV + '\'' +
				", maKH='" + maKH + '\'' +
				", ngayLapHD=" + ngayLapHD +
				'}';
	}
}
