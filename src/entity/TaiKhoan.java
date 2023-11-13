package entity;

import java.time.LocalDate;
import java.util.Objects;

public class TaiKhoan {
	private String taiKhoan;
	private String matKhau;
	private String loaiTaiKhoan;
	private LocalDate ngayTao;

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String taiKhoan, String matKhau, String loaiTaiKhoan, LocalDate ngayTao) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.loaiTaiKhoan = loaiTaiKhoan;
		this.ngayTao = ngayTao;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	public LocalDate getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(loaiTaiKhoan, matKhau, ngayTao, taiKhoan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(loaiTaiKhoan, other.loaiTaiKhoan) && Objects.equals(matKhau, other.matKhau)
				&& Objects.equals(ngayTao, other.ngayTao) && Objects.equals(taiKhoan, other.taiKhoan);
	}

	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", loaiTaiKhoan=" + loaiTaiKhoan
				+ ", ngayTao=" + ngayTao + "]";
	}

}
