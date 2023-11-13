package entity;

import java.time.LocalDate;
import java.util.Objects;

public class KhuyenMai {
	private String maKM;
	private String ten;
	private double chietKhau;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;
	private String mota;
	
	public KhuyenMai() {
	}
	public KhuyenMai(String maKM) {
		this.maKM = maKM;
	}
	public KhuyenMai(String maKM, String ten, double chietKhau, LocalDate ngayBatDau, LocalDate ngayKetThuc,
			String mota) {
		super();
		this.maKM = maKM;
		this.ten = ten;
		this.chietKhau = chietKhau;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.mota = mota;
	}
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public double getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(double chietKhau) {
		this.chietKhau = chietKhau;
	}
	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKM);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuyenMai other = (KhuyenMai) obj;
		return Objects.equals(maKM, other.maKM);
	}
	@Override
	public String toString() {
		return "KhuyenMai [maKM=" + maKM + ", ten=" + ten + ", chietKhau=" + chietKhau + ", ngayBatDau=" + ngayBatDau
				+ ", ngayKetThuc=" + ngayKetThuc + ", mota=" + mota + "]";
	}
}
