package entity;

import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String hoTen;
	private String eMail;
	private String sdt;

	public KhachHang() {

	}

	public KhachHang(String maKH, String hoTen, String eMail, String sdt) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.eMail = eMail;
		this.sdt = sdt;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eMail, hoTen, maKH, sdt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(eMail, other.eMail) && Objects.equals(hoTen, other.hoTen)
				&& Objects.equals(maKH, other.maKH) && Objects.equals(sdt, other.sdt);
	}

	@Override
	public String toString() {
		return "NhanVien{" + "maNV='" + maKH + '\'' + ", hoTen='" + hoTen + '\'' + ", eMail='" + eMail + '\''
				+ ", sdt='" + sdt + '\'' + '}';
	}

}
