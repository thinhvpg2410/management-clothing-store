package entity;

import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String hoTen;
	private int namSinh;
	private String eMail;
	private String sdt;
	private boolean gioiTinh;


	public NhanVien() {
	}

	public NhanVien(String maNV, String hoTen, int namSinh, String eMail, String sdt, boolean gioiTinh) {
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.eMail = eMail;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
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

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NhanVien nhanVien = (NhanVien) o;
		return Objects.equals(maNV, nhanVien.maNV);
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public String toString() {
		return "NhanVien{" +
				"maNV='" + maNV + '\'' +
				", hoTen='" + hoTen + '\'' +
				", namSinh=" + namSinh +
				", eMail='" + eMail + '\'' +
				", sdt='" + sdt + '\'' +
				", gioiTinh=" + gioiTinh +
				'}';
	}
}
